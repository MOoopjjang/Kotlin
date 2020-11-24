package com.mooop.m.data

import com.mooop.m.enums.EVENT
import kotlin.properties.Delegates

/**
 *  Manager 사이에 통신하는 message 클래스
 */
data class Message<T> constructor(val eType: EVENT, val result: String?, val body: T?)

/**
 * 파일 정보
 */
data class Movie(val Path:String  , var category:String = "unknown" , val size:Long){
    /** 파일 이름 */
    val name: String by lazy {
        val sPaht: ArrayList<String> = ( Path.split("/") as ArrayList<String> )
        sPaht[sPaht.count() - 1]
    }

    /** 확장자 */
    val ext:String? by lazy{
        val exts: ArrayList<String> =  this.name.split(".") as ArrayList<String>
        exts[ exts.count() - 1]
    }
}

/**
 * Category
 */
data class Category(val name:String
                    , var count:Int = 0
                    , var idxList:MutableList<String> = mutableListOf<String>())


/**
 * 디렉토리 class
 */
data class Directory(val name:String
                     , var count:Int = 0
                     , var idxList:MutableList<String> = mutableListOf<String>())



//fun main(){
//    val m: Movie = Movie("/aaa/bbb/ccc/ddd.txt" , "tmp",10)
//    println("${m.name} - ${m.ext}")
//
//}


