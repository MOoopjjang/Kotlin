package com.mooop.m.component


/**
 * Collection의 count값을 반환한다
 */
fun getCollectionCount(data: Any):Int{
    return when(data){
        is List<*>-> data.count()
        is Map<*,*>-> data.count()
        is Set<*>-> data.count()
        else-> -1
    }
}