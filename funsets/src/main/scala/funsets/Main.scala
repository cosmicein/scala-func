package funsets

object Main extends App {
  import FunSets._
   println(contains(singletonSet(1), 1))

  val singleton1 = singletonSet(1)
  val singleton2 = singletonSet(2)

  val unionVal = union(singleton1, singleton2)
  printSet(unionVal)

  printSet(map(unionVal, x=>x))
}
