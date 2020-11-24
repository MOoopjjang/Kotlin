package com.mooop.m.module

import com.mooop.m.component.getCollectionCount
import com.mooop.m.data.Message
import com.mooop.m.enums.EVENT
import com.mooop.m.mgr.CategoryManager
import com.mooop.m.mgr.ChangeDirManager

/**
 * Manager 간의 메세지 전송 관리하는 Observer Module
 *
 * 진행예정:
 *  - 예외 처리
 *  - EVENT 구조설계
 *  - 단위 테스트 진행중...
 *
 * @ver 0.5
 *
 */
object MObserver{
    private var observerMap: MutableMap<EVENT, List<DataObserver>> = mutableMapOf<EVENT, List<DataObserver>>()

    init{
        /** event map 등록 */
        EVENT.values().forEach {
            observerMap[it] = mutableListOf<DataObserver>()
        }
    }


    /**
     * event 를 등록한다.
     */
    val registry:(evt:EVENT , sub:ISubscribe , eFunc:(msg:Message<*>)->Unit)->MObserver = {e,s,ef->
        try{
            if(observerMap.containsKey(e)){
                ( observerMap[e] as MutableList<DataObserver> ).add(DataObserver(s , ef))
            }
            this
        }catch(exp: Exception){
            exp.printStackTrace()
            this
        }
    }

    /**
     * event에서 subscriber를 해제한다
     */
    val unregistry:(evt:EVENT , sub:ISubscribe)->MObserver = {e,s->
        try{
            if(observerMap.containsKey(e)){
                ( observerMap[e] as MutableList<DataObserver> ).removeIf { it.sub === s }
            }
            this
        }catch(exp: Exception){
            exp.printStackTrace()
            this
        }
    }

    /**
     * 발생된 event를 수신하는 subscriber에게 msg를 전달한다.
     */
    val notify:(evt:EVENT , msg:Message<*> , exclude:ISubscribe)->Boolean = {e,m,exclude->
        ( observerMap[e] as MutableList<DataObserver> ).filter { it.sub !== exclude }
                .forEach {
                    it.sub.notify(m , it.eFunc)
                }.run { true }
    }

    /**
     * event에 등록되 subscriber의 count
     */
    fun count(evt:EVENT):Int = getCollectionCount(observerMap[evt] as MutableList<DataObserver>)



    data class DataObserver(var sub: ISubscribe , var eFunc:(msg:Message<*>)->Unit)

}

//fun main(){
//   println("result : ${MObserver.registry(EVENT.FILE_ADD , CategoryManager)}")
//
//    println("result count : ${MObserver.count(EVENT.FILE_ADD)}")
//    MObserver.unregistry(EVENT.FILE_ADD , CategoryManager)
//    println("result count : ${MObserver.count(EVENT.FILE_ADD)}")
//
//    println("=====================================================")
//    MObserver.registry(EVENT.FILE_ADD , CategoryManager)
//            .registry(EVENT.FILE_ADD , ChangeDirManager)
//
//    MObserver.notify(EVENT.FILE_ADD , Message<String>("A" , "OK" , "HI") , ChangeDirManager)
//    println("=====================================================")
//    MObserver.unregistry(EVENT.FILE_ADD , CategoryManager)
//
//    var ret: Boolean = MObserver.notify(EVENT.FILE_ADD , Message<String>("A" , "OK" , "HI") , ChangeDirManager)
//    println("ret : ${ret}")
//}