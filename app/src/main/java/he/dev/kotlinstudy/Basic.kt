package he.dev.kotlinstudy

fun main() {
    // 변수와 자료형
    val name: String = "코틀린" // 변경 불가능한 변수
    var age = 30 // 변경 가능한 변수

    // null safety
    var nullableName: String? = null
    val length = nullableName?.length ?: 0 // null 안전 연산자

    // 함수
    fun greet(name: String): String {
        return "안녕하세요, ${name}님!"
    }

    println(greet(name))

    // 클래스
    class Person(val name: String, var age: Int) {
        fun introduce() {
            println("저는 ${name}이고, ${age}살 입니다.")
        }
    }
    val person = Person("Alice", 25)
    person.introduce()

    // 데이터 클래스
    data class User(val name: String, val age: Int)
    val user = User("Bob", 30)
    println(user) // User(name=Bob, age=30)

    // 컬렉션
    val numbers = listOf(1, 2, 3)
    val names = mutableListOf("Alice", "Bob", "Charlie")
    names.add("David")

    // 제어 흐름
    for (i in 1..10) {
        println(i)
    }
    when (age) {
        in 10..19 -> println("10대입니다.")
        in 20..29 -> println("20대입니다.")
        else -> println("다른 연령대입니다.")
    }

    // 예외 처리
    try {
        val result = 10 / 0
    } catch (e: ArithmeticException) {
        println("0으로 나눌 수 없습니다.")
    } finally {
        println("항상 실행됩니다.")
    }
}