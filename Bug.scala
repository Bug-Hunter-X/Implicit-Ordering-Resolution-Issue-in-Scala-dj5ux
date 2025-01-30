```scala
class MyClass[T](val value: T) {
  def myMethod(implicit ev: Ordering[T]): T = {
    // Some logic here
    value
  }
}

object MainObject {
  implicit val intOrdering: Ordering[Int] = Ordering.Int
  implicit val stringOrdering: Ordering[String] = Ordering.String

  def main(args: Array[String]): Unit = {
    val myInt = new MyClass(10)
    val myString = new MyClass("hello")

    println(myInt.myMethod)
    println(myString.myMethod)

    // This will compile and run fine

    // Now let's try with a custom type
    class MyCustomType(val value: Int)

    // This will NOT compile without implicit Ordering[MyCustomType]
    val myCustom = new MyClass(new MyCustomType(100))
    // println(myCustom.myMethod) // Compilation error
  }
}
```