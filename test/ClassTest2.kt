package ct2

import kotlin.properties.Delegates


/** 클래스 상속테스트 */
open class Shape{
    var x: Int = 0
        set(value){
            if(value < 0)field = 0
            else field = value
        }

    var y: Int = 0
        set(value){
            if(value < 0)field = 0
            else field = value
        }

    lateinit var name: String

    open fun print(){
        println("$name : location: $x , $y")
    }
}

class Rect : Shape(){
    var width:Int = 0
        set(value){
            if(value < 0)field = 0
            else field = value
        }

    var height: Int = 0
        set(value){
            if(value < 0)field = 0
            else field = value
        }

     override fun print(){
         super.print()
        println("$width , $height")
    }
}

class Circle:Shape(){
    var r: Int = 0
        set(value){
            if(value < 0)field = 0
            else field = value
        }
}


fun tst1(){
    val rect = Rect()
    rect.x = 100
    rect.y = 200
    rect.width = 45
    rect.height = 45
    rect.name = "Rect"

    rect.print()
}


open class Super{
    open val name: String = "kknag"
}
class Sub:Super(){
    final override var name: String = "aaaaa"
}
fun tst2(){
    var sub = Sub()
    println("sub name : ${sub.name}")
}

/** 생성자 테스트 - 1 */
open class Super2 constructor(var name:String){

    init{
        println("init!!!")
        name = "unknown"
    }
    open fun print(){
        println("${this.name}")
    }
}
class Sub2(name: String , var age: Int):Super2(name){
    override fun print(){
        super.print()
        println("${age}")
    }
}
fun tst3(){
    val sub2 = Sub2("cwkim" , 20)
    sub2.print()
}

/** 생성자 테스트 - 2
 * - 생성자 호출순서 테스트
 * */
open class Super3 constructor(var name:String){
    open fun print(){
        println("supr --> $name")
    }
}
class Sub3 : Super3{
    var age: Int = 0
    constructor(name: String , age: Int):super(name){
        this.age = age
    }

    override fun print(){
        super.print()
        println("sub --> $age")
    }
}
fun tst4(){
    val sub3 = Sub3("cwkim" , 20)
    sub3.print()
}

/**
 * as 캐스팅
 *
 * */
open class Super4{
    fun superFun(){
        println("superFun...")
    }
}
class Sub4 : Super4(){
    fun subFun1(){
        println("subFun1...")
    }
}
class Sub41 : Super4(){
    fun subFun2(){
        println("subFun2...")
    }
}
fun tst5(){
    val obj3: Super4 = Sub4()
    val obj4: Sub4 = obj3 as Sub4
    obj3.superFun()
    obj4.subFun1()
}


/** 접근제한자 테스트 */
var myData: Int = 10
private var myData2: String = "Hello"

class MyClass
private class MyClass2

fun myFunc():Unit=println("myFun")
private fun myFunc2():Unit=println("myFun2")
fun tst6(){
    println("$myData")
    println("$myData2")
    var myClass = MyClass()
    var myClass2 = MyClass2()
    myFunc()
    myFunc2()
}


/** 접근제한자 테스트 */
class PropertyVisibilityTest{
    private val name: String by lazy{
        "kcwda"
    }
    fun getData(): String = this.name

    var age: Int = 0
        get() = field
        private set(value){
            if(value < 0)field = 0
            else field = value
        }
}
fun tst7(){
    var pv = PropertyVisibilityTest()
    println(" pv : ${pv.getData()} - ${pv.age}")

}

fun main(args:Array<String>){
//    tst1()
//    tst2()
//    tst3()
//    tst4()
//    tst5()
//    tst6()
    tst7()
}

