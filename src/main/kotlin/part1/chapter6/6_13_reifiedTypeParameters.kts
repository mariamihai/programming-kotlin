package part1.chapter6

abstract class Book(val name: String)
class Fiction(name: String): Book(name)
class NonFiction(name: String): Book(name)

val books: List<Book> = listOf(
    Fiction("Moby Dick"),
    NonFiction("Learn to Code"),
    Fiction("LOTR"))


fun <T> findFirst(books: List<Book>, ofClass: Class<T>): T {
    val selected = books.filter { book -> ofClass.isInstance(book) }
    if(selected.size == 0) {
        throw RuntimeException("Not found")
    }
    return ofClass.cast(selected[0])
}

println(findFirst(books, NonFiction::class.java).name) // Learn to Code


// Kotlin permits the use of the parameter type within the function
// when the parametric type is marked as reified and the function is
// marked as inline

// Inline functions are expanded at compile time, thus removing a
// function call overhead

 inline fun <reified T> findFirstReified(books: List<Book>): T {
    val selected = books.filter { book -> book is T }
    if(selected.size == 0) {
        throw RuntimeException("Not found")
    }
    return selected[0] as T
}

println(findFirstReified<NonFiction>(books).name) //Learn to Code