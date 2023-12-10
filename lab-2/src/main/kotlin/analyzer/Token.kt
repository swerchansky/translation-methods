package analyzer

enum class Token(val value: String = "", val values: List<String> = emptyList()) {
    VAR(value = "var"),
    ARRAY(value = "Array"),
    TUPLE(value = "Tuple"),
    DD(value = ":"),
    LB(value = "<"),
    RB(value = ">"),
    CM(value = ","),
    TYPE(values = listOf("Int", "Char", "String", "Boolean", "Float", "Double", "Long", "Short", "Byte", "Any")),
    END(value = "\uFFFF"),
    NAME, // [a-zA-Z][a-zA-Z0-9]*
}