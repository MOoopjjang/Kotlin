package com.mooop.m

class Person(val name: String ){

    var age: Int = 0
    constructor(name:String , age: Int) : this(name){
        this.age = age
    }


    public override fun toString():String="name : ${name} - age : ${age}";


}