package com.hansheung.mob_2_4_UnitTesting.data.repo

import com.hansheung.mob_2_4_UnitTesting.data.model.Task

interface TaskRepo {

    fun getTasks(): List<Task>
    fun addTask(task: Task)
    fun getTask(id: Int): Task?
    fun update(id:Int, task: Task)
    fun delete(id: Int)
    fun getTasksSize():Int
}