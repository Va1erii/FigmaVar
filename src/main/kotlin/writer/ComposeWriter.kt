package writer

import extension.clear
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.Collection
import model.Mode
import model.VariableValue
import java.io.File
import java.io.Writer
import java.util.*
import kotlin.math.roundToInt

data class ComposeOutput(
    val name: String,
    val value: String,
)

object ComposeWriter {
    suspend fun write(
        outputDirectory: File,
        collection: Collection
    ) {
        withContext(Dispatchers.IO) {
            if (!outputDirectory.isDirectory) {
                throw IllegalArgumentException("Output is not a directory: $outputDirectory")
            }
            val variablesByMode = HashMap<Mode, SortedSet<ComposeOutput>>()
            collection.variables.forEach { variable ->
                variable.valuesByMode.forEach { valueEntry ->
                    variablesByMode.compute(valueEntry.key) { _, values ->
                        val set = TreeSet<ComposeOutput>(Comparator.comparing { it.name })
                        values?.let { set.addAll(it) }
                        set.add(
                            ComposeOutput(
                                name = "${valueEntry.key.name}${variable.name}",
                                value = when (val value = valueEntry.value) {
                                    is VariableValue.Alias -> throw IllegalStateException("Variable is not resolved")
                                    is VariableValue.ResolvedVariable -> {
                                        if (value.variable.valuesByMode.size == 1) {
                                            value.variable.name
                                        } else {
                                            "${valueEntry.key.name}${value.variable.name}"
                                        }
                                    }

                                    is VariableValue.Rgba -> value.toComposeColor()
                                },
                            )
                        )
                        set
                    }
                }
            }
            variablesByMode.forEach { (mode, variables) ->
                with(File(outputDirectory, "${mode.name.lowercase()}.kt")) {
                    writer().use { writer ->
                        clear()
                        writer.writeHeader()
                        variables.forEach { writer.write(it) }
                        writer.writeFooter()
                    }
                }
            }
        }
    }

    private fun Writer.writeHeader() {

    }

    private fun Writer.writeFooter() {

    }

    private fun Writer.write(variable: ComposeOutput) {
        write("""val ${variable.name} = ${variable.value}""")
        write("\n")
    }

    private fun VariableValue.Rgba.toComposeColor(): String {
        val r = convertToChannelValue(red)
        val g = convertToChannelValue(green)
        val b = convertToChannelValue(blue)
        val a = convertAlphaValue(alpha)
        return """
            Color(red = $r, green = $g, blue = $b, alpha = $a)
        """.trimIndent()
    }

    private fun convertToChannelValue(double: Double): Int {
        return (double * 255).roundToInt()
    }

    private fun convertAlphaValue(double: Double): Int {
        return (double * 255).toInt()
    }
}