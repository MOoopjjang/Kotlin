package com.mmc.m.common

import com.mmc.m.common.data.OMessage

/**
 * Project : mmc
 * Package :com.mmc.m.common
 * Author :  MOoop
 * Date : 26/02/2021
 * Desc :
 */
interface ISubscriber {

    fun onRegistry()

    fun<T> onSubscriber(message:OMessage<T>);
}