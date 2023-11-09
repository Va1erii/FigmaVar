import interceptor.*
import json.JsonParser
import json.JsonReader
import kotlinx.coroutines.runBlocking
import writer.SwiftWriter
import writer.XmlWriter
import java.io.File

fun main() = runBlocking {
    runSample()
}

private suspend fun runSample() {
    val semantics = JsonReader.read("src/main/resources/sample_semantic_color.json")
    val primitives = JsonReader.read("src/main/resources/sample_primitive_color.json")
    val output = File("src/main/resources")

    val semanticCollection = JsonParser.parse(semantics)
    val primitiveCollection = JsonParser.parse(primitives)
    val factory = OutputCollectionFactory()

    // XML
    val xmlCollections = factory.create(
        nameConverters = mapOf(
            primitiveCollection.id to XmlPrimitiveNameConverter(),
            semanticCollection.id to XMLSemanticNameConverter()
        ),
        primitiveCollection,
        semanticCollection
    )
    val xmlOutputPrimitives = requireNotNull(xmlCollections.find { it.id == primitiveCollection.id })
    val xmlOutputSemantics = requireNotNull(xmlCollections.find { it.id == semanticCollection.id })
    XmlWriter.write(
        outputDirectory = output,
        collection = xmlOutputPrimitives
    )
    XmlWriter.write(
        outputDirectory = output,
        collection = xmlOutputSemantics
    )

    // Swift
    val swiftCollections = factory.create(
        nameConverters = mapOf(
            primitiveCollection.id to SwiftPrimitiveNameConverter(),
            semanticCollection.id to SwiftSemanticNameConverter()
        ),
        primitiveCollection,
        semanticCollection
    )
    val swiftOutputPrimitives = requireNotNull(swiftCollections.find { it.id == primitiveCollection.id })
    val swiftOutputSemantics = requireNotNull(swiftCollections.find { it.id == semanticCollection.id })
    SwiftWriter.write(
        outputDirectory = output,
        collection = swiftOutputPrimitives
    )
    SwiftWriter.write(
        outputDirectory = output,
        collection = swiftOutputSemantics
    )
}