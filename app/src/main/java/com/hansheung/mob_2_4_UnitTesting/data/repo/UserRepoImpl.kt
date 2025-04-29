package com.hansheung.mob_2_4_UnitTesting.data.repo

class UserRepoImpl:UserRepo {
    override fun getUser(): String? {
        return "Real User"
    }
}