package com.mmc.m.common.data

/**
 * Project : mmc
 * Package :com.mmc.m.common.data
 * Author :  MOoop
 * Date : 26/02/2021
 * Desc : publisher --> Subscriber 에게 전달되는 data
 */
data class OMessage<T>(
//    private val eType:String,
    private val eAction: String,
    private val reason:String?=null,
    private val body:T? = null
){

    fun create(eAction:String, body:T) =
        OMessage(eAction, null , body)


    fun error(eAction:String ,reason:String) =
        OMessage(eAction , reason , null)
}
