package com.mooop.m.enums

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.mooop.m.component.convertDataToJson
import com.mooop.m.component.readFileToJsonString
import com.mooop.m.component.writeJsonToFile
import com.mooop.m.data.Category
import com.mooop.m.data.Directory
import kotlin.reflect.KClass

enum class FSTORE constructor(val path:String
              , val eFunc:(path:String , data:Any)->Any?) {

    CATEGORY_W ("category.json" , {p,d->
        val jsonString = convertDataToJson(d , Category::class)
        writeJsonToFile(p , jsonString , Category::class)
    })
    ,CATEGORY_R ("category.json" , {p,d->
        val tList = readFileToJsonString(p)
        val gson:Gson = Gson()
         if(tList.isEmpty()){
            listOf<Category>()
        }else{
             val retList = mutableListOf<Category>()
            tList.forEach {
                retList.add(gson.fromJson(it , Category::class.java))
            }
             retList
        }
    })
    ,CHANGEDIR_W ("changedir.json",{p,d->
        val jsonString = convertDataToJson(d , Directory::class)
        writeJsonToFile(p , jsonString , Directory::class)
    })
}