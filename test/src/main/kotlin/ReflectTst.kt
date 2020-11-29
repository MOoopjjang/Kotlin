package rft

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.*


fun tst1(){
    val myVal:KClass<*> = String::class
    fun myFun(arg: KClass<*>){

    }
}

fun class_info(){
    data class User(val name:String , val age:Int)

    val ref:KClass<*> = User::class

    println("----------------------------------")
    println("isAbstract : ${ref.isAbstract}")
    println("isCompanion : ${ref.isCompanion}")
    println("isData : ${ref.isData}")
    println("isFinal : ${ref.isFinal}")
    println("isOpen : ${ref.isOpen}")
    println("isInner : ${ref.isInner}")
    println("isSealed : ${ref.isSealed}")
}


fun constructor_info(){

    open class MyClass constructor(no: Int){
        constructor(no:Int , name: String):this(no)
    }

    fun someFun(arg : KClass<*>){
        val constructors = arg.constructors
        for(constructor in constructors){
            println("constructor.............. primaryConstructor : ${constructor === arg.primaryConstructor}")
            val parameters = constructor.parameters
            for(parameter in parameters){
                print("name : ${parameter.name} , type : ${parameter.type} --")

            }
            println()
        }

        println("================== primaryConstructor =======================")
        val pConstructor = arg.primaryConstructor
        if (pConstructor != null) {
            for(param in pConstructor.parameters){
                println("${param.name} : ${param.type}")
            }
        }
    }

    someFun(MyClass::class)

}


fun property_info(){
    open class SuperClass{
        val superVal: Int = 10
    }


    class MyClass(val no:Int):SuperClass(){
        val myVal: String = "hello"
        val String.someVal: String
            get() = "world"
    }

    fun someFun(arg:KClass<*>){
        println("declaredMemberProperties.........................")
        val properties = arg.declaredMemberProperties
        properties.forEach{
            println("${it.name} - ${it.returnType}")
        }

        println("memberProperties.........................")
        val properties2 = arg.memberProperties
        properties2.forEach {
            println("${it.name} - ${it.returnType}")
        }

        println("declaredMemberExtensionProperties........")
        val properties3 = arg.declaredMemberExtensionProperties
        for(property in properties3){
            println("${property.name} - ${property.returnType}")
        }
    }

    someFun(MyClass::class)


}


fun method_info(){
    open class SuperClass{
        fun superFun():Unit = println("superFun()")
    }

    class ChildClass(val name:String):SuperClass(){

        fun childFun():Unit = println("childFun : $name")

        fun String.someFun():Unit = println("String.someFun")
    }


    fun some(arg:KClass<*>){
        println("declaredMemberFunctions.......")
        val properties = arg.declaredMemberFunctions
        properties.forEach {
            println("${it.name} - ${it.returnType}")
        }

        println("memberFunctions.......")
        val mproperties = arg.memberFunctions
        mproperties.forEach {
            println("${it.name} - ${it.returnType}")
        }

        println("declaredMemberExtensionFunctions.......")
        val eproperties = arg.declaredMemberExtensionFunctions
        eproperties.forEach {
            println("${it.name} - ${it.returnType}")
        }

        println("memberExtensionFunctions.......")
        val eeproperties = arg.memberExtensionFunctions
        for(property in eeproperties){
            println("${property.name} - ${property.returnType}")
        }

    }

    some(ChildClass::class)
}

fun myFun(no:Int, name:String):Boolean = true
fun method_ref_info(){
//    fun myFun(no:Int, name:String):Boolean = true

    class MyClass constructor(val no:Int = 10 , var name:String = "kcwda"){

        fun data(n:Int , n2:Int):Int = n+n2
    }

    fun some(arg: KFunction<*>){

        println("${arg.name}")

        val pams = arg.parameters
        print("(")
        for(pam in pams){
            print("${pam.name}:${pam.type}")
            if(pam.index < pams.size)
                print(",")
        }
        print("):")
        print("${arg.returnType}")
    }

//    some(::myFun)

    some(MyClass::data)
}


fun tst2(){
    data class User(val name: String , val age: Int)

    fun convertToMap(obj:Any , arg: KClass<*>):MutableMap<String , Any>{
        val dmembers = arg.declaredMemberProperties
        val mMap: MutableMap<String , Any> = mutableMapOf<String , Any>()
        dmembers.forEach {
            println("name : ${it.name} - ${it.returnType}")
            println("${it.getter.call(obj)}")
            mMap[it.name] = it.getter.call(obj) as Any
        }

        return mMap
    }

    val u = User("cwkim" , 45)

    val retM = convertToMap(u , User::class)
    retM.forEach { t, u ->
        println("k : ${t} , u:${u}")
    }
}

fun main(){
//    class_info()
//    constructor_info()
//    property_info()
//    method_info()
//    method_ref_info()

    tst2()
}



