package com.hansheung.mob_2_4_UnitTesting.core.di

import com.hansheung.mob_2_4_UnitTesting.data.repo.TaskRepo
import com.hansheung.mob_2_4_UnitTesting.data.repo.TaskRepoImplTest
import com.hansheung.mob_2_4_UnitTesting.data.repo.UserRepo
import com.hansheung.mob_2_4_UnitTesting.data.repo.UserRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    @Named("msg0")
    fun provideGreetingMsg(): String{
        return "Hello Dagger Hilt 2"
    }

    @Provides
    @Singleton
    fun provideTasksRepo(): TaskRepo {
        return TaskRepoImplTest()
    }

    @Provides
    @Singleton
    fun provideUserRepo(): UserRepo {
        return UserRepoImpl()
    }
}