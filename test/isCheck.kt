package com.mooop.m



fun t1(){
    val n = 256;
    if( n is Int){
        println("$n is Int");
    }
}

fun t2(){
    val s: Any;
    s = "Hello";
    if(s is String){
        println(s.length);
    }
}

fun t3(){
    var a:Any = 1;
    a = 20L;
    println("a : $a type: ${a.javaClass}");
}

fun checkArg(x: Any){
    if( x is String){
        println("$x is String . lenght : ${x.length}");
    }else if(x is Int){
        println("$x is Int");
    }
}

fun t4(){
    var x: Any;

    x = "xferlog";
    checkArg(x);

    x = 20;
    checkArg(x);
}

fun main()
{
//    t1();
//    t2();
//    t3();

    t4();
}