package com.mooop.m.mgr

interface BaseManager<T> {

    fun getClassName():String

    /**
     * 등록
     */
    fun registry(data: T):Boolean

    /**
     * 해지
     */
    fun unregistry(param: String):Boolean

    /**
     * 등록된 목록반환
     */
    fun getRegistryItems():List<T>


}