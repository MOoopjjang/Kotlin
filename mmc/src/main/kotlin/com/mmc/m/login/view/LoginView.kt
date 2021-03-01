package com.mmc.m.login.view

import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

/**
 * Project : mmc
 * Package :com.mmc.m.view
 * Author :  MOoop
 * Date : 26/02/2021
 * Desc :
 */
class LoginView : Pane(){
    init{
        var a = with(HBox()){
            style = "-fx-background-color: #F0591E;"
            prefWidth = 800.0
            prefHeight = 600.0
            this
        }.also {children.add(it)}

        println("a type : ${a.javaClass.name}")

    }



}