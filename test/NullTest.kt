package com.mooop.m.nt


fun SafeCallandElvis()
{
    var str1: String? = "xferlog";
    str1 = null

    println("SafeCallandElvis() -- $str1 is length ${str1?.length ?:-1}");
}


fun cacheTest(){
    var test: Number = 12.2;
    println("$test");

    test = 12;
    println("$test");

    test = 120L;
    println("$test");

    test += 12.0f;
    println("$test");
}


fun tst1(){
    var str:String? = "xferlog"

    var len:Int? = str?.length
    println("len ${len}")

    // :?

    str = null
    len = str?.length?:-1
    println("-> ( -1 )-> len : ${len}")
}


fun tst2(arg : String?){
    class User constructor(var name:String? , age: Int?)

    var result: Int = try{
        println("try ... top")
        arg?.toInt()?:-1
    }catch(e: Exception){
        e.printStackTrace()
        10
    }finally{
        100
    }

    println("result : ${result}")
}


fun main(args : Array<String>)
{
//    var name: String? = "xferlog";
//    name = null;
//
//
//    println("safe call name length : ${name?.length}")

//    println("safe call name length : ${name!!.length}") //NPE 강제발생

//    if (name != null) {
//        println("safe call 2 name length : ${name.length}")
//    }

//    SafeCallandElvis();

//    cacheTest();

//    tst1()
    var vv: String? = null
    tst2(vv)
}