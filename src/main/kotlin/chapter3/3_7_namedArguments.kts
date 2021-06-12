fun createPerson(name: String, age: Int = 1, height: Int, weight: Int) = println("$name $age $height $weight")

createPerson(name = "Jake", age = 12, weight = 43, height = 152) //Jake 12 152 43
createPerson("Jake", age = 12, weight = 43, height = 152) //Jake 12 152 43
createPerson("Jake", 12, weight = 43, height = 152) //Jake 12 152 43
createPerson(weight = 43, height = 152, name = "Jake") //Jake 1 152 43
createPerson("Jake", weight = 43, height = 152) //Jake 1 152 43