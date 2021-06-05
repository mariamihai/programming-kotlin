// Kotlin has 2 types of equality checks:
// == (same as equals() in Java) = structural equality (take into consideration that
// Kotlin handles nulls safety)
// === (same as == in Java)) = referential equality

println("abc" == "abc") // true => "abc".equals("abc")
println("abc" == "Abc") // false => "abc".equals("Abc")
println(null  == "abc") // false => null.equals("abc"); warning: condition 'null  == "abc"' is always 'false'
println("abc" ==  null) // false => "abc".equals(null); warning: condition '"abc" ==  null' is always 'false'
println(null  ==  null) // true => null.equals(null); warning: condition 'null  ==  null' is always 'true'