package com.mooop.m.fp2




/** run() 함수 */
fun tst1(){
    val result = run {
        println("### Run ###")
        10 + 20
    }

    println("result : ${result}")
}

fun tst2(){
    class User (){
        var name: String? = null
        var age: Int? = null
        fun sayHello():Unit = println("hello ${name}")
        fun sayInfo():Unit = println("i am ${name} , ${age} yars old")
    }

    // before
    val user = User()
    user.name = "cwkim"
    user.age = 33
    user.sayHello()
    user.sayInfo()
    println("=================== run() 테스트 ===================")
    // run () 테스
    val result = user.run{
        name = "kim"
        age = 28
        sayHello()
        sayInfo()
        10+20
    }
    println("run() --> result : ${result}")
    println("=================== apply() 테스트 ===================")
    val user1 = user.apply{
        name = "xferlog"
        age = 45
    }
    user1.sayHello()
    user1.sayInfo()
    user1.name = "bhkim"
    user1.sayHello()

    println("=================== with() 테스트 ===================")
    with(user1){
        name = "kknda"
        age = 1
        sayHello()
        ""
    }
}

inline fun eFunc(a:Int , b:Int , pFunc :(Int , Int)->Int):Unit = println("pFunc : ${pFunc(a,b)}")
fun inline_tst(){
    eFunc(1 , 2 , {a:Int , b:Int->a+b})
}

fun label_test(){
    println("========== 람다에서 return ===============")
    val array = arrayOf(1,-2,3)
    fun arrayLoop(){
        println("arrayLoop")

        array.forEach aaa@{
            if(it < 0)return@aaa
            println(it)
        }
        println("--------------------------------------")
        array.forEach {
            if( it < 0)return@forEach
            println(it)
        }
        println("loop bottom..")
    }
    arrayLoop()
}

inline fun hoTest(argFun : (String)->Unit){
    argFun("hello")
    argFun("kim")
    argFun("kang")
}

fun hl_labelTest(){

    hoTest{
        if(it.length > 4)return@hoTest
        println(it)
    }
    println("test bottom...")
}


fun closure_test(){
    fun closureTest(x:Int):(Int)->Int {
        println("x : ${x}")
        return { it * x }
    }
    val ct = closureTest(2)
    println("==> ${ct(3)}")
}


fun main(args:Array<String>){
//    tst1()
//    tst2()
//    inline_tst()
//    label_test()
//    hl_labelTest()
    closure_test()
}

