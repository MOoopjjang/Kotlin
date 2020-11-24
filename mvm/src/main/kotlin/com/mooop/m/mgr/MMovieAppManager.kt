package com.mooop.m.mgr


/**
 * Main Manager
 */
object MMovieAppManager {

    /** Manager 등록 map*/
    private val mgrMap: Map<String , BaseManager<*>> = mapOf<String , BaseManager<*>>(
            //Category 매니저
            CategoryManager.getClassName() to CategoryManager
            //변경감지 Dir 등록 매니저
            ,ChangeDirManager.getClassName() to ChangeDirManager
    )

    init{
        println(" === MMovieAppManager === ")
    }

    /** 등록된 manager의 instance를 반환 */
    fun getManager(mName: String): BaseManager<*>? = mgrMap[mName]
}


