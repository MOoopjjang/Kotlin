package com.mooop.m.ift


interface IMy{
    var name: String?
    var age: Int?

    fun getInfo():String
}
class MyClass(name: String? , age: Int?) : IMy{
    override var name: String? = name
    override var age: Int? = age
    override fun getInfo():String = "name : ${this.name} - age : ${age}"
}
fun tst1(){
    var myClass = MyClass("xferlog" , 20)
    println(myClass.getInfo())
}


fun main(args:Array<String>){
    tst1()

}

