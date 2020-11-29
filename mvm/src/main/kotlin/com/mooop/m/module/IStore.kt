package com.mooop.m.module

interface IStore {

    fun insertData(data:Any):Boolean

    fun readData(id:String):List<Any>

    fun readAllData():List<Any>

    fun updateData(data:Any):Boolean

    fun deleteData(id:String): Boolean


}