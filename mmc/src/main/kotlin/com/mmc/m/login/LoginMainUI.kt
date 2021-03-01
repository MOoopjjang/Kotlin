package com.mmc.m.login

import com.mmc.m.common.ISubscriber
import com.mmc.m.common.data.OMessage
import com.mmc.m.login.view.LoginView
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Project : mmc
 * Package :com.mmc.m.login
 * Author :  MOoop
 * Date : 26/02/2021
 * Desc :
 */
class LoginMainUI constructor(
    private val primaryStage: Stage
) : ISubscriber {

    fun onCreate(){
        LoginView().run{
            val scene = Scene(this)
            primaryStage.scene = scene
            primaryStage.show()
        }
    }

    override fun onRegistry() {
        TODO("Not yet implemented")
    }

    override fun <T> onSubscriber(message: OMessage<T>) {
        TODO("Not yet implemented")
    }
}