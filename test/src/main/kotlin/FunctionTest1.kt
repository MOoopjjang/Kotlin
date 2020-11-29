package com.mooop.m


/* 함수를 parameter로 받음*/
fun highFunc(sum : (Int , Int)->Int , a:Int , b: Int):Int = sum(a,b);
//var sum: Int = { (Int , Int)->Int , a:Int , b:Int->a+b}


/* 함수를 return값으로 반환 */
fun hFunc2(): (Int, Int) -> Int = {x: Int , y: Int->x+y};
val hFunc21 :(Int,Int)->Int = {x:Int , y:Int->x+y};

val greet: (String )->Unit = {s-> println("${s} hello")}
fun greetFunc(s:String = "default"):Unit = println("${s} hello")

fun callSumFun():(Int , Int)->Int = {x: Int , y: Int->x+y};


fun main(){
    println(highFunc({x,y->x+y} , 10 , 20));

    println("=================================================");

    var hf2: (Int , Int)->Int = hFunc2();
    var result = hf2(10 , 20);
    println("result : "+result);

    println("=================================================")
    var mulFunc = {x:Int , y:Int->x*y};
    println("mulFunc : "+mulFunc(10,20));

    println("=================================================");
    greet("hi");

    println("=================================================");
    var vCall = callSumFun();
    println("callSumFun : ${vCall(10,20)}")

}