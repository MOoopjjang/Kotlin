package com.mooop.m



fun sum(a: Int , b: Int):Int{
    var sum: Int = 0

    /** 함수내에 함수 선언가능 */
    fun callSum(){
        for( i in a..b){
            sum += i
        }
    }

    callSum()
    return sum
}

fun sum2(a:Int , b:Int): Int = a+b;
fun sum3(a:Int , b:Int) = a+b;


/**
 * Default value
 */
fun tfunc(name:String , age:Int = 20):Unit{
    println("name : $name , age : $age");
}


fun tfunc2(vararg ns:Int):Int{
    var sum: Int = 0;
    for(n in ns){
        sum += n;
    }
    return sum;
}

/** 재귀함수 테스트 */
tailrec  fun recursiveFunc(no: Int = 1 , count: Int = 0){
    println("recursiveFunc  :"+count)
    if(count != no){
        return recursiveFunc(no , count+1)
    }

}


/**
 *  함수 in 함수 , class
 */
fun superFun(){
    fun dep1():Unit= println("delp1")
    fun dep2(a: Int , b: Int):Int = a+b

    class Sep constructor(var name: String)


    dep1()
    println("dep2 : ${dep2(10 , 20)}")
    var sep = Sep("xferlog")
}



fun main(){

    var s = sum(10 , 20);
    println("sum is $s");

    println("sum2 : ${sum(20 , 30)}");
    println("sum3 : ${sum(10 , 20)}");

    println("-------------------------------------------------");

    tfunc("xferlog");
    tfunc("cwkim" , 40);

    println("-------------------------------------------------");

    println(tfunc2(1,2,3,4,5,6));
    println(tfunc2(1,20,1));

    println("-------------------------------------------------");
    recursiveFunc(no = 10)
    println("-------------------------------------------------");

    superFun()
}