package com.mooop.m.t2




/** 늦은초기화 ( lateinit ) 테스트 */
class User2{
    lateinit var lateData: String
}




/** 최사위 레벨변수 */
var myVal: String = "hello"
    get()=field.toUpperCase()
    set(value){
        if(value.length == 0){
            field = "unknown"
        }else{
            field = value
        }
    }

class User1 constructor(val name: String){
    /** 클래스 멤버 변수 */
    var age: Int = 0
    set(value){
        if(value < 0){
            field = 0
        }else{
            field = value
        }
    }

    fun myFun(){
        /** 함수의 지역변수 */
        var no = 0
//            get() = field*10   //<===== 에러 ( 지역변수는 프로퍼티가 아님 )
    }
}



fun main(args:Array<String>){
    val user1 = User1("cwkim")
    println("name : ${user1.name}")
    user1.age = -1
    println("age : ${user1.age}")

    myVal = "xferlog"
    println("myval : ${myVal}")
}