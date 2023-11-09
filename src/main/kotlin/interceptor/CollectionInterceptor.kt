package interceptor

import model.Collection

interface CollectionInterceptor {
    fun intercept(
        nameConverters: Map<String, NameConverter>,
        vararg collections: Collection
    ): List<Collection>
}

class DefaultCollectionInterceptor : CollectionInterceptor {
    private val validator = CollectionValidator()
    private val aliasConnector = AliasConnector()
    override fun intercept(
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