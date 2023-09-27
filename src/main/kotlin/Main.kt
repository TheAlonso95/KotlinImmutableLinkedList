fun main(args: Array<String>) {
    val list = Cons("Head", Cons("Tail1", Nil))

    val appendItemList = list.append("Appended Item")
    val prePendItemList = list.prePend("Prepended Item")
    val listRemovedItem = list.remove("Tail1")
    val reverseList = list.reverse()
    val concatList = list.concat(Cons("add1", Cons("add2", Nil)))
    val flattenedList = list.flatMap { Cons(it, Cons("add1", Cons("add2", Nil))) }

    println(appendItemList)
    println(prePendItemList)
    println(listRemovedItem)
    println(reverseList)
    println(concatList)
    println(flattenedList)
}