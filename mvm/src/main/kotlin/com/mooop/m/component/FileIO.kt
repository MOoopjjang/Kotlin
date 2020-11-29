package com.mooop.m.component

import com.google.gson.Gson
import java.io.*
import java.nio.charset.StandardCharsets
import kotlin.reflect.KClass

/**
 * JsonString 값을 file로 write한다.
 *
 * 개선점
 *  - lock 기능 추가필요
 *  - 예외 처리 기능추가 필요
 *
 * @ver 0.5
 */
fun writeJsonToFile(path:String , data: String , clsType:KClass<*>):Boolean{
    if(!clsType.isData)
        throw Throwable("No Data Class")

    val file:File = File(path)
    val bos:BufferedOutputStream = BufferedOutputStream(FileOutputStream(file , file.exists()))

    bos.write(data.toByteArray())
    bos.write("\n".toString().toByteArray())
    bos.close()
    return true
}

/**
 *
 */
fun readFileToJsonString(path:String):List<String>{

    val file:File = File(path)
    val resultList:MutableList<String> = mutableListOf()
    if(!file.exists()){
        return resultList
    }

    val bis: BufferedInputStream = BufferedInputStream(FileInputStream(file))
    val br: BufferedReader = BufferedReader(InputStreamReader(bis , StandardCharsets.UTF_8))
    var line:String? = null

    while(true){
        line = br.readLine()
        if(line == null)break
        resultList.add(line)
    }
    br.close()
    return resultList
}
