package com.hansheung.mob_2_4_UnitTesting.data.repo

import com.hansheung.mob_2_4_UnitTesting.data.model.Task

class TaskRepoImplTest : TaskRepo {
    private val tasksMap: MutableMap<Int, Task> = mutableMapOf()
    private var k = 0

    override fun getTasks(): List<Task>{
        return tasksMap.values.toList()
    }

    override fun addTask(task: Task){
        tasksMap[k] = task
        k++
    }

    override fun getTask(id: Int): Task?{
        return tasksMap[0]
    }

    override fun update(id:Int, task: Task){
        tasksMap[id] = task
    }

    override fun delete(id: Int){
        tasksMap.remove(id)
    }

    override fun getTasksSize(): Int {
        TODO("Not yet implemented")
    }
}