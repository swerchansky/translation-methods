package generator

data class VisitorData(
    val rules: HashMap<String, MutableList<MutableList<String>>>,
    val tokens: HashMap<String, String>,
    val first: HashMap<String, HashSet<String>>,
    val follow: HashMap<String, HashSet<String>>,
    val packageName: String,
)