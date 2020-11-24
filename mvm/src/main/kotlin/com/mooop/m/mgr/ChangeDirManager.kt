package com.mooop.m.mgr

import com.mooop.m.data.Directory
import com.mooop.m.data.Message
import com.mooop.m.module.ISubscribe

object ChangeDirManager : BaseManager<Directory>  , ISubscribe {
    override fun getClassName(): String = ChangeDirManager::class.simpleName.toString()

    override fun registry(data: Directory): Boolean {
        TODO("Not yet implemented")
    }

    override fun unregistry(param: String): Boolean {
        TODO("Not yet implemented")
    }


    override fun getRegistryItems(): List<Directory> {
        TODO("Not yet implemented")
    }



    override fun <T> notify(msg: Message<T>, eFunc: (msg: Message<*>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun registryObserver() {
        TODO("Not yet implemented")
    }

    override fun unregistryObserver() {
        TODO("Not yet implemented")
    }



}