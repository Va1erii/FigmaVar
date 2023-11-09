package json

import kotlinx.serialization.json.*
import model.*
import model.Collection
import kotlin.math.roundToInt

object JsonParser {
    fun parse(jsonElement: JsonElement): Collection {
        require(jsonElement is JsonObject) { "Only single collection parsing is supported!" }
        val id = jsonElement.getString("id")
        val name = jsonElement.getString("name")
        val modes = jsonElement.getValue("modes").jsonObject
            .map {
                Mode(it.key, it.value.jsonPrimitive.content)
            }
        val modeById = modes.groupBy { it.id }.mapValues { it.value.single() }
        val variableIds = jsonElement.getValue("variableIds").jsonArray
            .map { it.jsonPrimitive.content }
        val variables = jsonElement.getValue("variables").jsonArray
            .map(JsonElement::jsonObject)
            .map { parseVariable(it, modeById) }
        return Collection(
            id = id,
            name = name,
            modes = modes,
            variableIds = variableIds,
            variables = variables
        )
    }

    private fun parseVariable(jsonObject: JsonObject, modeById: Map<String, Mode>): Variable {
        return with(jsonObject) {
            val id = getString("id")
            val name = getString("name")
            val type = VariableType.valueOf(getString("type"))
            val valuesByMode: Map<Mode, VariableValue> = getValue("valuesByMode").jsonObject
                .map {
                    val mode = modeById.getValue(it.key)
                    mode to parseVariableValue(it.value.jsonObject)
                }
                .toMap()
            Variable(
                id = id,
                name = name,
                type = type,
                valuesByMode = valuesByMode
            )
        }
    }

    private fun parseVariableValue(jsonObject: JsonObject): VariableValue {
        return when {
            jsonObject.isRgba() -> {
                VariableValue.Rgba(
                    red = jsonObject.getDouble("r"),
                    green = jsonObject.getDouble("g"),
                    blue = jsonObject.getDouble("b"),
                    alpha = jsonObject.getDouble("a"),
                )
            }

            jsonObject.isAlias() -> {
                VariableValue.Alias(
                    variableId = jsonObject.getString("id")
                )
            }

            else -> throw IllegalArgumentException("Unknown variable type $jsonObject")
        }
    }
}
private fun JsonObject.isRgba(): Boolean = containsKey("r") && containsKey("g") && containsKey("b")

private fun JsonObject.isAlias(): Boolean = get("type")?.jsonPrimitive?.contentOrNull == "VARIABLE_ALIAS"

private fun JsonObject.getDouble(key: String) = getValue(key)
    .jsonPrimitive
    .double

fun JsonObject.getString(key: String): String = getValue(key)
    .jsonPrimitive
    .content
    .removeSurrounding("\"")