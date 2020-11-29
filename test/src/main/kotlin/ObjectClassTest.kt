package com.mooop.m.oct




//===================================================
class Outer{

    private var no: Int = 0
    private val myInner = object {
        val name: String = "kkang"
        fun innerFun(){
            println("innerFun...")
            no++
        }
    }

    fun outerFun(){
        myInner.name
        myInner.innerFun()
    }
}
fun tst1(){
    val obj  = Outer()
//    obj.myInner.name
//    obj.myInner.innerFun()
}

object Test{
    var name: String = "xferlog"
        set(value){
            if(value.length == 0)field = "unknown"
            else field = value
        }
    var age: Int = 0
        set(value){
            if(value < 0)field = 0
            else field = value
        }
}
fun tst2(){
    println("${Test.name}")
}

fun main(args:Array<String>){
    tst2()
}

