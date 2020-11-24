package com.mooop.m.enums

import com.mooop.m.mgr.CategoryManager
import com.mooop.m.mgr.ChangeDirManager

// 작업중...
enum class MANAGER (name: String) {
    CATEGORY (CategoryManager::class.simpleName.toString())
    ,CHGDIR (ChangeDirManager::class.simpleName.toString())

}