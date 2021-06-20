package chapter5

// Can be mutable or immutable
// mapOf(), mutableMapOf(), hashMapOf(), linkedMapOf(), sortedMapOf()
val sites = mapOf("pragprog" to "https://www.pragprog.com",
    "agiledeveloper" to "https://agiledeveloper.com")
println(sites.size) // 2

println(sites.containsKey("agiledeveloper")) // true
println(sites.containsValue("http://www.example.com")) // false
println(sites.contains("agiledeveloper")) // true - checks the keys
println("agiledeveloper" in sites) // true - checks the keys

// get() returns a nullable type - This returns an error
//val pragProgSite: String = sites.get("pragprog")
val pragProgSite1: String? = sites.get("pragprog")
val pragProgSite2: String? = sites["pragprog"]

val agiledeveloper =
    sites.getOrDefault("agiledeveloper", "http://www.example.com")

// Create a new map with or without a specific element
val sitesWithExample = sites + ("example" to "http://www.example.com")
val withoutAgileDeveloper = sites - "agiledeveloper"

// Iteration over the entries in the map
for (entry in sites) {
    println("${entry.key} --- ${entry.value}")
}
for ((key, value) in sites) {
    println("$key --- $value")
}
