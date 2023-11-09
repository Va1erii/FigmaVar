package model

data class Collection(
    val id: String,
    val name: String,
    val modes: List<Mode>,
    val variableIds: List<String>,
    val variables: List<Variable>
)