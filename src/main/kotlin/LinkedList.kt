sealed class LinkedList<out T : Any>

data object Nil : LinkedList<Nothing>() {
    override fun toString(): String = "Nil"
}

fun <T : Any, R : Any> LinkedList<T>.map(f: (T) -> R): LinkedList<R> = when (this) {
    Nil -> Nil
    is Cons -> Cons(f(head), tail.map(f))
}

tailrec fun <T : Any> LinkedList<T>.filter(f: (T) -> Boolean): LinkedList<T> = when (this) {
    Nil -> Nil
    is Cons -> if (f(head)) Cons(head, tail.filter(f)) else tail.filter(f)
}

fun <T : Any> LinkedList<T>.append(e: T): LinkedList<T> = when (this) {
    Nil -> Cons(e, Nil)
    is Cons -> Cons(head, tail.append(e))
}

fun <T : Any> LinkedList<T>.prePend(e: T): LinkedList<T> = when (this) {
    Nil -> Cons(e, Nil)
    is Cons -> Cons(e, tail.prePend(head))
}

fun <T : Any> LinkedList<T>.concat(l: LinkedList<T>): LinkedList<T> = when (this) {
    Nil -> l
    is Cons -> Cons(head, tail.concat(l))
}

fun <T : Any> LinkedList<T>.remove(e: T): LinkedList<T> = when (this) {
    Nil -> Nil
    is Cons -> if (head == e) tail else Cons(head, tail.remove(e))
}

fun <T : Any> LinkedList<T>.reverse(): LinkedList<T> = when (this) {
    Nil -> this
    is Cons -> tail.reverse().append(head)
}

fun <T : Any, R : Any> LinkedList<T>.flatMap(f: (T) -> LinkedList<R>): LinkedList<R> = when (this) {
    Nil -> Nil
    is Cons -> f(head).concat(tail.flatMap(f))
}

