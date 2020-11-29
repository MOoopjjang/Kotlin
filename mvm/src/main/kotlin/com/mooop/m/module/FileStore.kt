package com.mooop.m.module

import com.mooop.m.enums.FSTORE


object MFileStore : IStore{
    private var tag:FSTORE = FSTORE.CATEGORY_W

    val setTag:(tag:FSTORE)->MFileStore = {t->
        this.tag = tag
        this
    }

    override fun  insertData(data: Any): Boolean {
        return tag.eFunc(tag.path , data) as Boolean
    }

    override fun readAllData(): List<Any> {
        return tag.eFunc(tag.path , "") as List<Any>
    }

    override fun deleteData(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun readData(id: String): List<Any> {
        TODO("Not yet implemented")
    }



    override fun updateData(data: Any): Boolean {
        TODO("Not yet implemented")
    }




}