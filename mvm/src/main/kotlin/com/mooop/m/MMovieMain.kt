package com.mooop.m.demo.vm

import com.mooop.m.mgr.CategoryManager
import com.mooop.m.mgr.MMovieAppManager


fun main(args:Array<String>){
    val cm = MMovieAppManager.getManager(CategoryManager.getClassName())
    if (cm != null) {
        println("${cm.getClassName()}")
    }
}