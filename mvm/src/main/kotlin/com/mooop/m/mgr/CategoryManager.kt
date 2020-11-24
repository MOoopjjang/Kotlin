package com.mooop.m.mgr

import com.mooop.m.data.Category
import com.mooop.m.data.Message
import com.mooop.m.data.Movie as Movie
import com.mooop.m.enums.EVENT
import com.mooop.m.module.ISubscribe
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
//            var dd = listCategory.filter { it.name == nData.category }.map{
//                it.idxList
//            }
//            dd.forEach { println("${it}") }
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
    CategoryManager.registry(Category("action"))
    CategoryManager.getRegistryItems().forEach {
        println("${it.name}")
    }


//    val addFunc: (Message<*>)->Unit = {msg->
//        val nData = (msg.body as Movie)
//        CategoryManager.listCategory.filter { it.name == nData.category }.map { it.idxList.add(nData.Path) }
//    }


    val m:Movie = Movie("/aaa/bbb/ccc.mp4" , "action" , 100)
//    MObserver.registry(EVENT.FILE_ADD , CategoryManager)
    MObserver.notify(EVENT.FILE_ADD , Message<Movie>(EVENT.FILE_ADD , "OK" , m) , ChangeDirManager)


}