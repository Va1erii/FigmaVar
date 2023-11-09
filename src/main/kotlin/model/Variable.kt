package model

enum class VariableType {
    COLOR
}

sealed class VariableValue {
    data class Rgba(
        val red: Double,
        val green: Double,
        val blue: Double,
        val alpha: Double,
    ) : VariableValue()

    data class Alias(
        val variableId: String
    ) : VariableValue()

    data class ResolvedVariable(
        val variable: Variable,
    ) : VariableValue()
}

data class Variable(
    val id: String,
    val name: String,
    val type: VariableType,
    val valuesByMode: Map<Mode, VariableValue>
)