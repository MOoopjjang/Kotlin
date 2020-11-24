package com.mooop.m.ct

import com.mooop.m.Animal
import com.mooop.m.Person


class MyClass1
class MyClass2()
class MyClass3 constructor()

/** exam : 주생성자 property 형태를 선언
 *
 *  - 주생성자와 보조생성자를 동시에 선언
 *
 *
 * */
class User constructor(var name: String = "jone" ,var age: Int = 999){
    var address: String? = null

    init{
        println("User init call...${name} - ${age}")
    }

    /** 보조생성자에서는 주생성자를 호출해줘야 한다. ( this(... ) )*/
    constructor(name: String , age: Int , address: String):this(name , age){
        this.address = address
    }


    public override fun toString():String{
        return "toString name : ${name} - age : ${age}"
    }
}

/**
 *  class property 테스트
 *
 * */
class User2{
    var name:String = "cwkim"
    get() = field
    set(value){
        if(value.length == 0){
            field = "unknown"
        }else{
            field = value
        }
    }

    val age: Int = 20
    get() = field
}


fun tst1(){
    // 주생성자 테스트
    var user1: User = User("kim" , 45)
    println("${user1.toString()}")
}

fun tst2(){
    val user2 = User2()

    user2.name = ""
    println("name : ${user2.name} - age : ${user2.age}")
}

fun main(){
    val p = Person("cwkim" , 20);
    val p2 = Person("cwkim" , 20);
    println("${p.toString()}")

    println("=========================================")
    val a1 = Animal()
//    println("a1 : ${a1.kind}")

    val a2 = Animal("fish")
    println("a1 : ${a2.getKind()}")

    println("=========================================")
//    tst1()
    tst2()
}


