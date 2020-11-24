package com.mooop.m

class Animal {
    private var kind: String = ""

    constructor(){

    }
    constructor(kind: String){
        this.kind = kind
    }


    public fun getKind():String = this.kind
}