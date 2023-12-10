package dsl

@DslMarker
annotation class CodeDsl

@CodeDsl
fun generateClass(name: String, isDataClass: Boolean = false, init: ClassBuilder.() -> Unit): String {
    return ClassBuilder(name, isDataClass).apply(init).toString()
}

@CodeDsl
fun generateEnumClass(name: String, init: EnumClassBuilder.() -> Unit): String {
    return EnumClassBuilder(name).apply(init).toString()
}

@CodeDsl
class EnumClassBuilder(private val name: String) {
    private val enumValues: MutableList<EnumValue> = mutableListOf()
    private var packageName: String = ""

    @CodeDsl
    fun packageName(packageName: String) {
        this.packageName = packageName
    }

    @CodeDsl
    fun value(value: String) {
        enumValues += EnumValue(value)
    }

    override fun toString(): String {
        val values = enumValues.joinToString(",$SEPARATOR").prependIndent("\t")
        val packageName = if (packageName.isNotEmpty()) "package $packageName" else ""
        return StringBuilder()
            .append(packageName)
            .append("$SEPARATOR$SEPARATOR")
            .append("enum class $name {")
            .append(SEPARATOR)
            .append(values)
            .append(SEPARATOR)
            .append("}")
            .toString()
    }
}

@CodeDsl
class ClassBuilder(private val name: String, private val isDataClass: Boolean = false) {
    private val arguments: MutableList<Argument> = mutableListOf()
    private val variables: MutableList<Argument> = mutableListOf()
    private val functions: MutableList<FunctionsBuilder> = mutableListOf()
    private val imports: MutableList<Import> = mutableListOf()
    private var packageName: String = ""
    private var init: InitBuilder? = null

    @CodeDsl
    fun packageName(packageName: String) {
        this.packageName = packageName
    }

    @CodeDsl
    fun import(import: String) {
        imports += Import(import)
    }

    @CodeDsl
    fun argument(
        argumentName: String,
        argumentType: String,
        defaultValue: String = "",
        isVal: Boolean = false,
        isVar: Boolean = false,
        isPrivate: Boolean = false,
    ) {
        arguments += Argument(argumentName, argumentType, defaultValue, isVal, isVar, isPrivate)
    }

    @CodeDsl
    fun variable(
        variableName: String,
        variableType: String,
        defaultValue: String = "",
        isVal: Boolean = false,
        isVar: Boolean = false,
        isPrivate: Boolean = false,
    ) {
        variables += Argument(variableName, variableType, defaultValue, isVal, isVar, isPrivate)
    }

    @CodeDsl
    fun init(init: InitBuilder.() -> Unit) {
        this.init = InitBuilder().apply(init)
    }

    @CodeDsl
    fun function(
        name: String,
        returnType: String = "Unit",
        isPrivate: Boolean = false,
        init: FunctionsBuilder.() -> Unit
    ) {
        functions += FunctionsBuilder(name, returnType, isPrivate).apply(init)
    }

    override fun toString(): String {
        val functions = functions.joinToString("$SEPARATOR$SEPARATOR").prependIndent("\t")
        val imports = imports.joinToString(SEPARATOR)
        val data = if (isDataClass) "data " else ""
        val argument = arguments.joinToString(", ")
        val variables = variables.joinToString(SEPARATOR).prependIndent("\t")
        val init = init?.toString()?.prependIndent("\t") ?: ""
        val packageName = if (packageName.isNotEmpty()) "package $packageName" else ""
        return StringBuilder()
            .append(packageName)
            .append("$SEPARATOR$SEPARATOR")
            .append(imports)
            .append("$SEPARATOR$SEPARATOR")
            .append("${data}class $name($argument) {")
            .append(SEPARATOR)
            .append(variables)
            .append(SEPARATOR)
            .append(init)
            .append(SEPARATOR)
            .append(functions)
            .append(SEPARATOR)
            .append("}")
            .toString()
    }
}

@CodeDsl
class InitBuilder {
    private val lines: MutableList<String> = mutableListOf()

    @CodeDsl
    operator fun String.unaryPlus() {
        lines += this
    }

    override fun toString(): String {
        val lines = lines.joinToString(SEPARATOR).prependIndent("\t")
        return StringBuilder()
            .append("init {")
            .append(SEPARATOR)
            .append(lines)
            .append(SEPARATOR)
            .append("}")
            .append(SEPARATOR)
            .toString()
    }
}

@CodeDsl
class FunctionsBuilder(
    private val name: String,
    private val returnType: String = "Unit",
    private val isPrivate: Boolean = false,
) {
    private val arguments: MutableList<Argument> = mutableListOf()
    private val lines: MutableList<String> = mutableListOf()

    @CodeDsl
    fun argument(argumentName: String, argumentType: String, defaultValue: String = "") {
        arguments += Argument(argumentName, argumentType, defaultValue)
    }

    @CodeDsl
    fun generateWhile(condition: String, init: WhileBuilder.() -> Unit) {
        lines += WhileBuilder(condition).apply(init).toString()
    }

    @CodeDsl
    fun generateIf(condition: String, init: IfBuilder.() -> Unit) {
        lines += IfBuilder(condition).apply(init).toString()
    }

    @CodeDsl
    operator fun String.unaryPlus() {
        lines += this
    }

    override fun toString(): String {
        val args = arguments.joinToString(", ")
        val name = if (isPrivate) "private fun $name" else "fun $name"
        val lines = lines.joinToString(SEPARATOR).prependIndent("\t")
        return StringBuilder()
            .append("$name($args): $returnType {")
            .append(SEPARATOR)
            .append(lines)
            .append(SEPARATOR)
            .append("}")
            .toString()
    }
}

@CodeDsl
class WhileBuilder(private val condition: String) {
    private val lines: MutableList<String> = mutableListOf()

    @CodeDsl
    fun generateIf(condition: String, init: IfBuilder.() -> Unit) {
        lines += IfBuilder(condition).apply(init).toString()
    }

    @CodeDsl
    operator fun String.unaryPlus() {
        lines += this
    }

    override fun toString(): String {
        val lines = lines.joinToString(SEPARATOR).prependIndent("\t")
        return StringBuilder()
            .append("while ($condition) {")
            .append(SEPARATOR)
            .append(lines)
            .append(SEPARATOR)
            .append("}")
            .append(SEPARATOR)
            .toString()
    }
}

@CodeDsl
class IfBuilder(private val condition: String) {
    private val lines: MutableList<String> = mutableListOf()
    private var elseBuilder: ElseBuilder? = null

    @CodeDsl
    fun generateIf(condition: String, init: IfBuilder.() -> Unit) {
        lines += IfBuilder(condition).apply(init).toString()
    }

    @CodeDsl
    fun generateElse(init: ElseBuilder.() -> Unit) {
        elseBuilder = ElseBuilder().apply(init)
    }

    @CodeDsl
    operator fun String.unaryPlus() {
        lines += this
    }

    override fun toString(): String {
        val lines = lines.joinToString(SEPARATOR).prependIndent("\t")
        return StringBuilder()
            .append("if ($condition) {")
            .append(SEPARATOR)
            .append(lines)
            .append(SEPARATOR)
            .append("}")
            .append(elseBuilder?.toString() ?: "")
            .append(SEPARATOR)
            .toString()
    }
}

@CodeDsl
class ElseBuilder {
    private val lines: MutableList<String> = mutableListOf()

    @CodeDsl
    operator fun String.unaryPlus() {
        lines += this
    }

    override fun toString(): String {
        val lines = lines.joinToString(SEPARATOR).prependIndent("\t")
        return StringBuilder()
            .append(" else {")
            .append(SEPARATOR)
            .append(lines)
            .append(SEPARATOR)
            .append("}")
            .append(SEPARATOR)
            .toString()
    }
}

data class Argument(
    val name: String,
    val type: String,
    val defaultValue: String,
    val isVal: Boolean = false,
    val isVar: Boolean = false,
    val isPrivate: Boolean = false,
) {
    override fun toString(): String {
        val default = if (defaultValue.isNotEmpty()) " = $defaultValue" else ""
        val varType = when {
            isVal && isPrivate -> "private val "
            isVar && isPrivate -> "private var "
            isVal -> "val "
            isVar -> "var "
            else -> ""
        }
        return "$varType$name: $type$default"
    }
}

data class EnumValue(
    val name: String
) {
    override fun toString() = name
}

data class Import(
    val name: String
) {
    override fun toString() = "import $name"
}

val SEPARATOR: String = System.lineSeparator()
