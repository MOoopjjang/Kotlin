package com.mooop.m

import com.mooop.m.nMax
import com.mooop.m.getSum





fun tst1(){
    println(nMax)
    println(getSum(1,2))
}

fun tst2(){
    fun cases(obj: Any):String{
        /** when */
        when(obj){
            1->return "Number One"
            "Hello"->return "Greeting"
            is Long->return "Long"
            is String->return "String"
            else->return "unknown"
        }
    }


    println("${cases(1)}")
    println("${cases("xferlog")}")

}


fun type_casting(){

    fun callCasting(obj: Any):Unit{
        if(obj is String){
            println("obj String is ${obj.length}")
        }else if(obj is Number){
            println("obj Number is ${obj}")
        }
    }

    callCasting(1)
    callCasting("cwkim")
}

fun main(args:Array<String>){
//    tst1()
//    tst2()
    type_casting()
}