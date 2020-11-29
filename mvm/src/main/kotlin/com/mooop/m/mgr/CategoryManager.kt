package com.mooop.m.mgr

import com.mooop.m.data.Category
import com.mooop.m.data.Message
import com.mooop.m.data.Movie as Movie
import com.mooop.m.enums.EVENT
import com.mooop.m.enums.FSTORE
import com.mooop.m.module.ISubscribe
import com.mooop.m.module.MFileStore
import com.mooop.m.module.MObserver


/**
 *  카테고리 매니저 클래스
 */
object CategoryManager : BaseManager<Category> , ISubscribe{

    private val listCategory: MutableList<Category> = mutableListOf<Category>()

    init{
        /** Observer 등록 */
        registryObserver()
    }

    override fun getClassName(): String = CategoryManager::class.simpleName.toString()

    override fun  registry(data: Category): Boolean {
        if(data !in listCategory){
            listCategory.add(data)

//            MFileStore.setTag(FSTORE.CATEGORY_W).insertData(data)
        }
        return true
    }

    override fun unregistry(param: String): Boolean = listCategory.removeIf { it.name == param }

    override fun getRegistryItems(): List<Category> = listCategory


    //============================ Observer ===============================================

    /**
     *
     */
    override fun<Moive> notify(msg: Message<Moive> , eFunc:(msg:Message<*>)->Unit) {
        println("eType : ${msg.eType}")
        eFunc(msg)
    }

    override fun registryObserver() {

        val addFunc: (Message<*>)->Unit = {msg->
            val nData = (msg.body as Movie)
            listCategory.filter { it.name == nData.category }.map { it.idxList.add(nData.Path) }
        }

        val delFunc: (Message<*>)->Unit = {msg->

        }

        MObserver.registry(EVENT.FILE_ADD , this , addFunc)
                .registry(EVENT.FILE_DELETE , this , delFunc)
    }

    override fun unregistryObserver() {
        MObserver.unregistry(EVENT.FILE_ADD , this)
                .unregistry(EVENT.FILE_DELETE , this)
    }
}



fun main(){

    CategoryManager.registry(Category("japan"))
    CategoryManager.registry(Category("kor"))




}