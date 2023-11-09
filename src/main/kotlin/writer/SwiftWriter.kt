package writer

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.Collection
import model.Mode
import model.VariableValue
import java.io.File
import java.io.Writer
import java.util.*

data class SwiftOutput(
    val name: String,
    val value: String
)

object SwiftWriter {
    suspend fun write(
        outputDirectory: File,
        collection: Collection
    ) {
        withContext(Dispatchers.IO) {
            if (!outputDirectory.isDirectory) {
                throw IllegalArgumentException("Output is not a directory: $outputDirectory")
            }
            val variablesByMode = HashMap<Mode, SortedSet<SwiftOutput>>()
            collection.variables.forEach { variable ->
                variable.valuesByMode.forEach { valueEntry ->
                    variablesByMode.compute(valueEntry.key) { _, values ->
                        val set = TreeSet<SwiftOutput>(Comparator.comparing { it.name })
                        values?.let { set.addAll(it) }
                        set.add(
                            SwiftOutput(
                                name = variable.name,
                                value = when (val value = valueEntry.value) {
                                    is VariableValue.Alias -> throw IllegalStateException("Variable is not resolved")
                                    is VariableValue.ResolvedVariable -> {
                                        value.variable.name
                                    }

                                    is VariableValue.Rgba -> value.toSwiftColor()
                                }
                            )
                        )
                        set
                    }
                }
            }
            variablesByMode.forEach { (mode, variables) ->
                with(File(outputDirectory, "${mode.name.lowercase()}.swift")) {
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

    private fun Writer.write(variable: SwiftOutput) {
        write("""${variable.name} = ${variable.value}""")
        write("\n")
    }

    private fun VariableValue.Rgba.toSwiftColor(): String {
        return """
            Color(red: $red, green: $green, blue: $blue, opacity: $alpha)
        """.trimIndent()
    }

    private fun File.clear() {
        writeText("")
    }
}