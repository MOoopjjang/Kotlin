package com.mooop.m.act


/** test 1 */
abstract class Person{

    abstract var name: String
    abstract var age: Int

    init{
         println("##### Person Init ####")
     }
}

class Programmer constructor(name: String , age: Int) : Person() {
    override var name: String = name
        get()=field
        set(value){
            if(value.length == 0)field = "unknown"
            else field = value
        }
    override var age: Int = age
        get() = field
        set(value){
            if(value < 0)field = 0
            else field = value
        }
    var kind: String = "unknown"
    var price: Long = 0

    constructor(name:String , age: Int , kind: String , price: Long):this(name , age){
        this.kind = kind
        this.price = price
    }


    override fun toString(): String {
        return "name : ${this.name} , age : ${this.age} , kind : ${this.kind} , price : ${this.price}"
    }
}
fun tst1(){
    var programmer = Programmer("cwkim" , 20 , "SERver" , 21)
    println("programmer info : ${programmer.toString()}")

    var prog2 = Programmer("" , -1)
    println("prog2 info : ${prog2.toString()}")
    prog2.name = ""
    println("prog2 info : ${prog2.toString()}")

}




fun main(args:Array<String>){
    tst1()
}







