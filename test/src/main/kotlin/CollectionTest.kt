package com.mooop.m.ctm

val l = arrayOf<String>("a" , "b" , "ccc" , "d" , "e")

class Person constructor(val name:String , val age:Int)

fun mapTest(){
    var mm = mapOf<String , String>("one" to "1" , "two" to "2")
    println("${mm.keys}")

    var iter: Iterator<Map.Entry<String , String>> = mm.iterator()
    while(iter.hasNext()){
        var entry = iter.next()
        println("${entry.key} : ${entry.value}")
    }
    println("==================================================")
    var iter2 = mm.iterator()
    while(iter2.hasNext()){
        var k = iter2.next()
        println("${k.key}")
    }

    var mm2: MutableMap<String , String> = mutableMapOf<String , String>()
    mm2.put("xferlog" , "kknda")
    println("mm2 count : ${mm2.count()}")
}

fun test2(){
    var marr = MutableList<String>(4 , {i->"cwkim_${i}"})
    for(i in marr){
        println("${i}")
    }

    var arr = ArrayList<String>()
    arr.add("xferlog")
    arr.add("xferlog1")
    arr.add("xferlog2")
}


fun test1(){

//    var arr = arrayOf(1 , "kkang" , true)
//    arr[0] = 10
//    arr[2] ="world"
//    println("${arr[0]} .. ${arr[1]} ..${arr[2]}")
//
//    println("==================================================")
//    var ia: IntArray = IntArray(6 , {i->i*2})
//    for(i in ia){
//        println("${i}")
//    }

}

/**
 * 집합 연산
 */
fun set_op_test(){

    /** forEach( .. ) , forEachIndexed( .. ) */
    l.filter { d->d.length == 1 }.forEach{
        println(it)
    }
    println("==================== forEachIndexed ====================")
    l.filter { it.length == 1 }.forEachIndexed({i , v-> println("${i} : ${v}")})

    /** all() , any() */
    println("==================== all() , any() ==================")
    class User constructor(val name:String , val age: Int)
    val userList = arrayOf<User>(User("xferlog" , 20) , User("kknda" , 31))
    println("all : ${userList.all { it.age > 30 }}")
    println("any : ${userList.any { it.age > 30}}")


    /** count() , find() */
    println("==================== count() , find() ==================")
    println("count : ${userList.count{ it.age > 30}}")
    val user = userList.find { it.age > 30 }
    println("name : ${user?.name} - ${user?.age}")

    /** reduce() , fold() */
    println("==================== reduce() , fold() ==================")
    var foldList = listOf<Int>(1,2).fold(10 , {total , next->
        println("${total} ... ${next}")
        total + next
    })
    println("fold test : ${foldList}")


}


fun filter_op_tst(){
    /** drop()  , */
    println("==================== drop() , fold() ==================")
    l.drop(2).forEach{
        println("$it")
    }
    println("-----------------------------------------------")

    listOf<Int>(2,1,12,5,23).dropWhile { it < 10 }.forEach{
        println("${it}")
    }

    /** slice()  , */
    println("==================== slice() , fold() ==================")
    listOf<Int>(1,12,5,23,5,4).slice(1..3)
            .forEach{ println("slice -> ${it}")}
    println("-------------------------------------------------------")
    listOf<String>("a" , "b" , "c" , "d" , "e").slice(listOf(1,4))
            .forEach { println("$it") }
}


fun mapping_op_tst(){
    println("==================== mapIndexed() ==================")
    val list = listOf<Int>(12,8,9,20)
    list.filter{ it%2 == 0}.mapIndexed{index , data->
        println("index : ${index} - ${data}")
        data *10
    }.forEachIndexed({index , data-> println("${index} : ${data}")})

    println("==================== groupBy() ==================")
    listOf<Person>(Person("aaa" , 10) , Person("bbb" , 10) , Person("ccc" ,20))
            .groupBy { it.age }
            .forEach{
                println("key : ${it.key} ... count : ${it.value.count()}")
                it.value.forEach{ println("${it.name} .. ${it.age}")}
            }
}

fun main(args:Array<String>){
//    test1()
//    test2()
    mapTest()

//    set_op_test()
//    filter_op_tst()
//    mapping_op_tst()
}