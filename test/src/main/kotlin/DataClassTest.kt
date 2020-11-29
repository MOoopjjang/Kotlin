package com.mooop.m.dct


/** .equals() 테스트 */
class User1 constructor(val name:String , val age: Int)
data class User2 constructor(val name: String , val age: Int)

data class User3(val name:String){
    var age:Int = 0
}
fun tst1(){
    var u1 = User1("kcwda" , 20)
    var u2 = User1("kcwda" , 20)
    println("u1 == u2 : ${u1.equals(u2)}")

    var du1 = User2("aaa" , 10)
    var du2 = User2("aaa" , 10)
    println("du1 == du2 : ${du1.equals(du2)}")
    var du3 = User2("aaa" , 20)
    println("du1 == du3 : ${du1.equals(du3)}")

    println("du1 toString : ${du1.toString()}")

    val (name , age) = du1
    println("du1 분해선언 ( Destructuring declarations ) : ${name} - ${age}")

    val du4 = du3.copy(age = 40)
    println("du3  : ${du3.toString()}")
    println("du3 의 age 변경후 du4로 copy : ${du4.toString()}")

    var u3 = User3("xferlog")
    u3.age = 10
}

fun main(args:Array<String>){
    tst1()
}

