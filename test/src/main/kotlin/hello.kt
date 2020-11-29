package com.mooop.m


fun hello()
{
    println("hello fun");
}



fun main()
{
    val name: String = "cwkim";
    val age: Int = 20;

    println("name : $name , age : $age");


//    val person = Person("kakdlfa" , "ejkim");
//    println("id : "+person.id +" ----- name : "+person.name);

    //StringPool 개념
    var str1: String = "Hello";
    var str2: String = "hi";
    var str3: String = "Hello";

    println("str1 === str2 : ${str1 === str2}");
    println("str1 === str3 : ${str1 === str3}");


    //변수 표현식
    var a1:Int  = 10;
    var strA1: String = "al is $a1";
    println("strA1 is $strA1");

    hello();


    var text = """
        var a: Int = 6;
        var ss: String = "adffa";
    """.trimIndent();
    println("$text");


    var nNum: Int = 10;
    var nNum2: Int? = 10;
    println("nNum == nNum2 : ${nNum == nNum2}");
    println("nNum === nNum2 : ${nNum === nNum2}");
}