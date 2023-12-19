package generator

interface Generator {
    fun generate(data: VisitorData, stringPath: String, prefix: String = "Grammar")
}