package com.mooop.m.fp1






fun tst1(){
    /** lambda */
    val sum = {x:Int , y:Int->x+y}
    println("sum : ${sum(1,2)}")

    println("======================================")
    fun someFun():Unit = println("someFun")
    var sf = ::someFun
    println("sf : ${sf()}")
}

/**
 * 다양한 구성요소 포함
 */
fun tst2(){
    /** 함수내 함수 포함 */
    fun s1():Unit = println("s1")
    fun s2(a:Int , b:Int):Int = a+b

    /** .. class 포함 */
    class Scls constructor(var p:String){

        fun print() = println("p : ${p}")
    }

    s1()
    println("s2 : ${s2(1,2)}")
    var scls = Scls("xferog")
    scls.print()

}


fun tst3(){
    val cf = {a:Int , b:Int->a<b}
    println("cf : ${cf(10 , 20)}")
}

fun tst4(){
    class User constructor(val name: String , val age: Int)
    val lambda1: (User)->Int = {user:User->user.age}
    println("${lambda1(User("xferlog" , 20))}")
}


fun tst5(){
    /** 고차함수 테스트 - 함수를 파라미터로 받기 */
    fun callsFunc(a:Int , b:Int , cFunc: (Int , Int)->Int):Int = cFunc(a , b)

    println("callFunc \"+\" : ${callsFunc(10 , 20 , {a,b->a+b})}")
    println("callFunc \"*\" : ${callsFunc(10 , 20 , {a,b->a*b})}")
    println("=====================================================")
    val array = arrayOf(10,20,15,22,8)
    array.filter { x->x > 10 }.forEach{x -> println("$x")}
    println("=====================================================")

    /** 고차함수 - 함수 타입 기본값 */
    println("고차함수 - 함수 타입 기본값")
    fun some(x:Int = 1 , ef :(Int)->Int = {x:Int->x*2}):Int = ef(x)
    println("some no param : ${some()}")
    println("some param 2 : ${some(2 , {x:Int->x+2})}")


    /** 함수 반환 */
    println("=====================================================")
    println("고차함수 - 함수 반환")
    fun hoFun5(op: String = "+"):(Int , Int)->Int{
        return when(op){
            "+" -> {pam1 ,pam2 ->pam1+pam2}
            "*" -> {pam1 , pam2->pam1*pam2}
            "/" -> {pam1 , pam2->pam1/pam2}
            else -> {pam1 , pam2->pam1-pam2}
        }
    }
    var ho = hoFun5( "-")
    println("${ho(10 , 5)}")

    /** 함수 반환 */
    println("=====================================================")
    fun hoFun6(a: Int , argFun : (Int)->Int):Unit = println("argFun : ${argFun(a)}")
    fun nFun(a: Int):Int = a*2
    hoFun6(10 , ::nFun)
}




fun main(args:Array<String>){
//    tst1()
//    tst2()
//    tst3()
//    tst4()
    tst5()
}

