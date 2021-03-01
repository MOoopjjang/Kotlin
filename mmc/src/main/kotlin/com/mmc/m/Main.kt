package com.mmc.m

import com.mmc.m.login.LoginMainUI
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage

/**
 * Project : mmc
 * Package :com.mmc.m
 * Author :  MOoop
 * Date : 13/02/2021
 * Desc :
 */
class Main:Application(){
    override fun start(primaryStage: Stage?) {
        LoginMainUI(primaryStage!!).onCreate()
    }
}

fun main(args:Array<String>){
    Application.launch(Main::class.java)
}