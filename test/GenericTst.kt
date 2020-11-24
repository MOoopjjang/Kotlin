package com.mooop.m.gtt




fun tst1(){
    class Base<T: Any>{
        lateinit var data:T
    }


    var b:Base<String> = Base<String>()
    b.data = "xferlog"
    println("${b.data}")
}


fun<T: Any> funnn(data:T ):T{
    return data
}


fun main(){
//    tst1()

    println("${funnn<String>("xferlog")}")
}

