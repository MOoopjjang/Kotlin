package com.mooop.m.etst


class Super{
    val data:Int = 0

    fun print(){
        println("Super :: ${data}")
    }
}

val Super.name:String
    get() = "xferlog"

val Super.data:Int
    get() = 20


fun Super.subPrint(){
    println("subPrint")
}


fun main(){
    val obj:Super = Super()
    println("${obj.print()} - ${obj.subPrint()}")
    println("${obj.name}")
}

