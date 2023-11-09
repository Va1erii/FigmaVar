package json

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import java.io.ByteArrayOutputStream
import java.io.FileInputStream

object JsonReader {
    private val json = Json {
        isLenient = true
    }

    suspend fun read(path: String): JsonElement = withContext(Dispatchers.IO) {
        val jsonString = FileInputStream(path).use {
            val output = ByteArrayOutputStream()
            var ctr = it.read();
            while (ctr != -1) {
                output.write(ctr);
                ctr = it.read();
            }
            output.toString()
        }
        json.parseToJsonElement(jsonString)
    }
}