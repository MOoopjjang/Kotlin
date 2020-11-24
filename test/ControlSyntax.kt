package com.mooop.m

import java.util.*



fun for_test(){
    var sum: Int = 0
    for(i in 1..10){
        sum += i
    }
    println("sum : ${sum}")

    println("====================================")

    var arr = listOf<String>("a" , "b" , "c" , "d")
    for(i in arr.indices){
        println(i)
    }

    println("====================================")

    for((i,v) in arr.withIndex()){
        println("${i} : ${v}")
    }
}

fun when_test(){


    val arr1 = arrayOf<String>("xferlog" , "kknda" , "dddd")
    val list1 = listOf<String>("one" , "two" , "three")

    while(true){
        var input_value: Scanner = Scanner(System.`in`)

        var result: String = when(input_value.next()){
            in arr1->"arr1 in"
            in list1->"list1 in"
            else->"unknown"
        }

        println("result : ${result}")
        if(result == "unknown")
            break
    }

}


fun expression_if(){
    var num: Int = 10
    var result: String = if(num%2 == 0)"h" else "i"
    println("result : ${result}")

    var result2 : Int = if(num > 10 ){
        println("10 over")
        num * 2
    }else if(num < 10 && num > 5){
        println("6 ~ 9")
        num +2
    }else{
        println("not 0")
        num - 1
    }
    println("result2 : ${result2}")


}

fun main(args:Array<String>){
//    expression_if()
//    when_test()
    for_test()
}