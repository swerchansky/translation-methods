package generator

data class VisitorData(
    val rules: HashMap<String, MutableList<MutableList<String>>>,
    val tokens: LinkedHashMap<String, String>,
    val first: HashMap<String, HashSet<String>>,
    val follow: HashMap<String, HashSet<String>>,
    val packageName: String,
    val ruleNumberFromFirst: HashMap<String, HashMap<String, Int>>,
    val nodeValues: List<String>,
    val attributes: List<String>,
)