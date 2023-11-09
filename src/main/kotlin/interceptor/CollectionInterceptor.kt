package interceptor

import model.Collection

/**
 * Responsible for creating final collections, validating them, and resolving aliases.
 */
class OutputCollectionFactory {
    private val validator = CollectionValidator()
    private val aliasConnector = AliasConnector()
    fun create(
        nameConverters: Map<String, NameConverter>,
        vararg collections: Collection
    ): List<Collection> {
        collections.forEach(validator::validate)
        val convertedNames = collections.map {
            val nameConverter = nameConverters.getValue(it.id)
            it.copy(
                variables = it.variables.map(nameConverter::convert)
            )
        }
        return aliasConnector.connect(*convertedNames.toTypedArray())
    }
}