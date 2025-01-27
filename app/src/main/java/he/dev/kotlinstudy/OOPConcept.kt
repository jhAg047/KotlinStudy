interface Flyable {
    fun fly()
}

open class Animal(val name: String) {
    open fun move() {
        println("$name이 움직입니다.")
    }
}

class Bird(override val name: String) : Animal(name), Flyable {
    override fun fly() {
        println("$name이 하늘을 날아다닙니다.")
    }
}

class Dog(name: String) : Animal(name) {
    override fun move() {
        println("$name이 뛰어다닙니다.")
    }
}

class Person(val name: String, var age: Int) {
    fun introduce() {
        println("안녕하세요, 저는 $name이고, $age살입니다.")
    }

    companion object {
        fun createPerson(name: String, age: Int): Person {
            return Person(name, age)
        }
    }
}

fun main() {
    // 동물 클래스 상속 및 인터페이스 구현
    val bird = Bird("독수리")
    bird.fly() // Bird가 Flyable 인터페이스를 구현했으므로 fly() 메소드 호출 가능
    bird.move() // Bird가 Animal 클래스를 상속했으므로 move() 메소드 호출 가능

    val dog = Dog("멍멍이")
    dog.move()

    // 사람 클래스와 컴패니언 객체
    val person = Person.createPerson("Alice", 30)
    person.introduce()
}