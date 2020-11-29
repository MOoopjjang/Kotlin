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



inline fun<reified T> some2(l:Any){
    val list = l as List<Int>
    list.forEach { println(it) }
}

fun tst2(){


    fun some(l:List<*>){
        val list = l as List<Int>
        list.forEach { println(it) }
    }




    val list2:MutableList<Any?> = mutableListOf(10 , 10.0 , "kkang")
    list2.forEach{ println(it)}
    println("===========================================")
    val list3:MutableList<*>  = mutableListOf(10 , 10.0 , "kkang")
    list3.forEach{ println(it)}
    println("===========================================")

//    var ll = listOf<Int>(10,20,30)
//    some2(listOf(10,20,30))
//    some2(listOf("a" , "b" , "c"))
}


fun main(){
//    tst1()
//    println("${funnn<String>("xferlog")}")

    tst2()
}

