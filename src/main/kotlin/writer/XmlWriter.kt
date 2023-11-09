package writer

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.Collection
import model.Mode
import model.VariableValue
import model.VariableValue.Rgba
import java.io.File
import java.io.Writer
import java.util.*
import kotlin.math.roundToInt

data class XmlOutput(
    val name: String, val value: String
)

object XmlWriter {
    suspend fun write(
        outputDirectory: File,
        collection: Collection
    ) {
        withContext(Dispatchers.IO) {
            if (!outputDirectory.isDirectory) {
                throw IllegalArgumentException("Output is not a directory: $outputDirectory")
            }
            val variablesByMode = HashMap<Mode, SortedSet<XmlOutput>>()
            collection.variables.forEach { variable ->
                variable.valuesByMode.forEach { valueEntry ->
                    variablesByMode.compute(valueEntry.key) { _, values ->
                        val set = TreeSet<XmlOutput>(Comparator.comparing { it.name })
                        values?.let { set.addAll(it) }
                        set.add(
                            XmlOutput(
                                name = variable.name,
                                value = when (val value = valueEntry.value) {
                                    is VariableValue.Alias -> throw IllegalStateException("Variable is not resolved")
                                    is VariableValue.ResolvedVariable -> {
                                        "@color/${value.variable.name}"
                                    }

                                    is Rgba -> value.toAndroidHex()
                                }
                            )
                        )
                        set
                    }
                }
            }
            variablesByMode.forEach { (mode, variables) ->
                with(File(outputDirectory, "${mode.name.lowercase()}.xml")) {
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
        write(
            """
            <?xml version="1.0" encoding="utf-8"?>
            <resources>
        """.trimIndent()
        )
        write("\n")
    }

    private fun Writer.writeFooter() {
        write(
            """
            </resources>
        """.trimIndent()
        )
    }

    private fun Writer.write(variable: XmlOutput) {
        write("""    <color name="${variable.name}">${variable.value}</color>""")
        write("\n")
    }

    private fun Rgba.toAndroidHex(): String {
        val r = convertToChannelValue(red)
        val g = convertToChannelValue(green)
        val b = convertToChannelValue(blue)
        val a = convertAlphaValue(alpha)
        val androidHexColor = (a shl 24) or (r shl 16) or (g shl 8) or b
        return String.format("#%08X", androidHexColor).uppercase()
    }

    private fun convertToChannelValue(double: Double): Int {
        return (double * 255).roundToInt()
    }

    private fun convertAlphaValue(double: Double): Int {
        return (double * 255).toInt()
    }

    private fun File.clear() {
        writeText("")
    }
}