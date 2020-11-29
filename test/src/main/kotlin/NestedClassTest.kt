package com.mooop.m.nct

class Outer{
    var no: Int = 0
    fun outerFun(){
        println("outerFun")
    }

    inner class OuterIn{
        var name: String = "ccc"
        fun inFun(){
            outerFun()
            println("no : ${no} - name : ${name}")
        }
    }
}
fun tst1(){
    var obj1:Outer.OuterIn = Outer().OuterIn()
    obj1.inFun()
}


class Test{
    val name:String = "xferlog"

    companion object TT{
        operator fun invoke() {
            TODO("Not yet implemented")
        }

        val age:Int = 20
    }
}
fun tst2(){
    Test.TT()
}


fun main(args:Array<String>){
    tst1()
}