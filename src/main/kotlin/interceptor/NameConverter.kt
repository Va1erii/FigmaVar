package interceptor

import model.Variable

interface NameConverter {
    fun convert(variable: Variable): Variable
}

class XmlPrimitiveNameConverter : NameConverter {
    override fun convert(variable: Variable): Variable {
        return variable.copy(
            name = variable.name
                .split("/")
                .last()
                .removeSuffix("\"")
                .lowercase()
        )
    }
}

class XMLSemanticNameConverter : NameConverter {
    override fun convert(variable: Variable): Variable {
        return variable.copy(
            name = variable.name
                .lowercase()
                .replace("&", "")
                .replace("/", "_")
                .replace(" ", "_")
                .replace("-", "_")
        )
    }
}

class SwiftPrimitiveNameConverter : NameConverter {
    override fun convert(variable: Variable): Variable {
        return variable.copy(
            name = variable.name
                .split("/")
                .last()
                .removeSuffix("\"")
                .lowercase()
                .replaceFirstChar { it.uppercase() }
        )
    }
}

class SwiftSemanticNameConverter : NameConverter {
    override fun convert(variable: Variable): Variable {
        val name = variable.name
            .replace("&", "")
            .replace(" ", "-")
            .split("/")
            .joinToString(
                separator = "-",
                transform = { it.lowercase().replaceFirstChar { it.uppercase() } }
            )
        return variable.copy(
            name = name
        )
    }
}