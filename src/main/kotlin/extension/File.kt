package extension

import java.io.File

fun File.clear() {
    writeText("")
}