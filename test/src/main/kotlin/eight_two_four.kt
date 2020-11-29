package etf

/**
 *  초기돠 미루기 ( by lazy )
 *  - 초기화를 프로퍼티의 이용 시점으로 미룬다
 *  - 즉 선언시점이 아닌 이용시점에 초기화 할수 있다
 *  규칙
 *   - 호출시점에 초기화 진행
 *   - val로 선언한 프로퍼티에만 사용 가능
 *   - 클래스 몸체 이외에 최상위 레벨에서 사용 가능
 *   - 기초 타입에도 사용가능
 *
 * */

val someData: String by lazy{
    println("hello")
    "hello"
}


class User1{
    val name: String by lazy{
        println("i am lazy name")
        "xferlog"
    }

    val age: Int by lazy{
        println("i am lazy age")
        20
    }

    init{
        println("i am init...")
    }

    constructor(){
        println("i am constructor...")
    }
}


fun main(args:Array<String>){

    val user1 = User1()

    println("name : ${user1.name}")
    println("name use after....")
    println("age use before....")
    println("age : ${user1.age}")
    println("age use after....")
}