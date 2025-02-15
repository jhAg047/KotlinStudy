package he.dev.kotlinstudy

// 제네릭을 사용하여 재사용 가능한 클래스 만들기
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)
class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)
class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)

/// 이렇게 하면 answer을 제외한 나머지 요소의 중복, 그러므로 answer를 일반데이터 유형으로 정의 ///

/* 데이터 클래스 사용 - 데이터만 포함하고 작업을 실행하는 메서드가 없는
 데이터 클래스 선언하면 자동으로 toString() 구현해줌*/

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
// enum 클래스 사용
enum class Difficulty {
    EASY, MEDIUM, HARD
}

// interface 확장
/* class Class name: Interface name {
 		class body
 }*/
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}


class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    override val progressText: String
        get() = "${answered} of ${total} answered"

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    // 범위 함수
    // let
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }


}

/* 싱글톤 객체 사용
 싱글톤 : 인스턴스를 하나만 가질 수 있는 클래스
 kotlin에서 싱글톤 클래스 만들때는 object 키워드 작성
 컴패니언 객체를 선언하려면 object 키워드앞에 companion 키워드 추가*/
/* companion object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}
*/

// 확장 속성 추가
// 확장 속성은 데이터 저장 X -> get-only
/* val type name.property name: data type
     property getter*/
/* val Quiz.StudentProgress.progressText: String
	get() = "${answered} of ${total} answered" */

// 확장 함수 추가
/* fun type name.function name(parameters) : return type {
 	   function body
 }*/
/* fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
} */


fun main() {
    /* val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    println(question1.toString()) */

//     println("${Quiz.answered} of ${Quiz.total} answered.")

//     println(Quiz.progressText)

//     Quiz.printProgressBar()
//     Quiz().printProgressBar()

    //val quiz = Quiz()
    //quiz.printQuiz()

    // apply()를 통한 변수 없이 객체의 메서드 호출
    /* val quiz = Quiz().apply {
        printQuiz
    } */
    // 인스턴스를 반환하지만 사용하는곳이 없어서 quiz 변수 삭제
    // apply() 사용하면 인스턴스에서 메서드를 호출하는 변수도 필요 X
    Quiz().apply {
        printQuiz()
    }

}