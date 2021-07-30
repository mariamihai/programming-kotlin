package part1.chapter6

fun fetchMessage(id: Int) : Any =
    if(id == 1) "Record found" else StringBuilder("Data not found")

for (id in 1..2) {
    println("Message length: ${(fetchMessage(id) as? String)?.length ?: "---"}")
}

// Use smart cast as much as possible - the is operator
// Use safe cast only when smart cast isn't an option - the as? operator
// Don't use the unsafe cast (or use it as little as possible) - the as operator