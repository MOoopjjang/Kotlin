package com.mooop.m.demo.ph

import kotlin.properties.Delegates

/**
 * Singleton 객체
 */
object UserManager{
    /**
     * 사용자정보를 저장하는 list
     */
    private var userInfos: ArrayList<UserInfo> = ArrayList<UserInfo>()

    private var nUserInfos: Int by Delegates.observable(0 , {prop , old , new->
        println("${old}-->${new}")
    })

    /**
     * 사용자 정보를 반환한다.
     */
    fun getInfo(name:String):UserInfo?{
        var retUserInfo: UserInfo? = null
        for(userInfo in this.userInfos){
            if(userInfo.username == name){
                retUserInfo = userInfo
                break
            }
        }
        return retUserInfo
    }

    /**
     * 사용자 정보를 저장한다
     */
    fun setInfo(name:String , age: Int , ph:String?): Unit {
        this.userInfos.add(UserInfo(name , age , ph))
        nUserInfos = this.userInfos.size
    }



    /**
     * 전체 정보를 출력
     */
    fun print():Unit{
        for(m in this.userInfos){
            println("name : ${m.toString()}")
        }
    }
}


fun main(args:Array<String>){
    UserManager.setInfo("xfelrog" , 20,null)
    UserManager.setInfo("ccc" , 30,"111122223333")
    UserManager.print()
    var u: UserInfo? = UserManager.getInfo("ccc")
    println("u : ${u.toString()}")
}