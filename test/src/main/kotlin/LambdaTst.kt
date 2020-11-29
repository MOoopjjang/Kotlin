package com.mooop.m




/**
 * case 1 - 함수를 param으로 넘길수 있다
 * case 2 - 함수를 변수에 담을수 있다
 * case 3 - 함수를 반환할수 있다
 */




fun callParamFun2(ef:(vararg :Any)->Unit , vararg v: Any):Unit{
    ef(v);
}


fun callParamFun1(ef: (Int , Int)->Unit , a: Int , b: Int):Unit{
    ef(a , b);
}


fun main(){
    callParamFun1({a,b->println("${a+b}")} , 10 , 20);

//    callParamFun2({a , b , c->println("hi")} , 10 , 20 , 30);

}





