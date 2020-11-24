package com.mooop.m.pr

import kotlin.properties.Delegates

/** 프로퍼티 변경감지 테스트 */
class User{

    var name: String by Delegates.observable("init" , {props , old , new->
        println("${old} --> ${new}")
    })
}


fun observer_tst(){
    var u = User()
    println("1 . ${u.name}")
    u.name = "xferlog"
    println("2 . ${u.name}")
    u.name = "aaaa"
    println("3 . ${u.name}")
}


fun main(args:Array<String>){
    observer_tst()
}
