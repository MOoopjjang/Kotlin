package com.mooop.m.component

import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.simple.parser.JSONParser
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties


val gson:Gson = Gson()

/**
 * Collection의 count값을 반환한다
 */
fun getCollectionCount(data: Any):Int{
    return when(data){
        is List<*>-> data.count()
        is Map<*,*>-> data.count()
        is Set<*>-> data.count()
        else-> -1
    }
}

/**
 *
 */
fun convertDataToMap(obj: Any , arg: KClass<*>):MutableMap<String , Any>{
    if(!arg.isData){
        throw Throwable("arg is not Data!!!!")
    }
    val retMap:MutableMap<String , Any> = mutableMapOf()
    arg.declaredMemberProperties.forEach {retMap[it.name] = it.getter.call(obj) as Any }
    return retMap
}

fun convertDataToJson(obj:Any , arg: KClass<*>):String{
    if(!arg.isData){
        throw Throwable("arg is not Data!!!!")
    }

    return gson.toJson(obj)
}



//fun main(){
//
//
//    val r:String = convertDataToJson(User("cwkim" , 20) , User::class)
//    println("${r}")
//}