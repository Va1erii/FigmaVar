package interceptor

import extension.groupBySingle
import model.Collection
import model.Variable
import model.VariableValue

class AliasConnector {
    fun connect(vararg collections: Collection): List<Collection> {
        val variables: Map<String, Variable> = collections
            .map { it.variables }
            .flatten()
            .groupBySingle { it.id }
        return collections.map { collection ->
            collection.copy(
                variables = collection.variables.map { variable ->
                    variable.copy(
                        valuesByMode = variable.valuesByMode.mapValues { (mode, variableValue) ->
                            when (variableValue) {
                                is VariableValue.Rgba -> variableValue
                                is VariableValue.Alias -> {
                                    val resolvedVariable = variables
                                        .getValue(variableValue.variableId)
                                    if (resolvedVariable.valuesByMode.size == 1) {
                                        // Has only 1 mode. So use that one
                                        VariableValue.ResolvedVariable(resolvedVariable)
                                    } else {
                                        // Should use the same mode. Check that is has the target mode
                                        resolvedVariable
                                            .valuesByMode
                                            .getValue(mode)
                                        VariableValue.ResolvedVariable(resolvedVariable)
                                    }
                                }

                                is VariableValue.ResolvedVariable -> variableValue
                            }
                        }
                    )
                }
            )
        }
    }
}