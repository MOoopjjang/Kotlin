package com.mooop.m.module

import com.mooop.m.data.Message

interface ISubscribe {

    fun registryObserver():Unit

    fun unregistryObserver():Unit

    /** */
    fun<T> notify(msg: Message<T> , eFunc:(msg:Message<*>)->Unit):Unit
}