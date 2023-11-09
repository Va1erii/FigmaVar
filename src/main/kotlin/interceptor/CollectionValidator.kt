package interceptor

import model.Collection

class CollectionValidator {
    fun validate(collection: Collection) {
        val variableIds = HashSet(collection.variableIds)
        if (!variableIds.containsAll(collection.variables.map { it.id })) {
            val missing = collection.variables.filter { !variableIds.contains(it.id) }
            throw IllegalStateException("Variables are missing in variableIds: [${missing.joinToString()}]")
        }
        val modes = HashSet(collection.modes)
        if (!modes.containsAll(collection.variables.map { it.valuesByMode.keys }.flatten())) {
            val missing = collection.variables.filter { !modes.containsAll(it.valuesByMode.keys) }
            throw IllegalStateException("Variables contains unknown modes: [${missing.joinToString()}]")
        }
    }
}