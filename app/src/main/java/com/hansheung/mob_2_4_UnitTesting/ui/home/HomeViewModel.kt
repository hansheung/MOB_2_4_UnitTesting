package com.hansheung.mob_2_4_UnitTesting.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hansheung.mob_2_4_UnitTesting.data.model.Task
import com.hansheung.mob_2_4_UnitTesting.data.repo.TaskRepo
import com.hansheung.mob_2_4_UnitTesting.data.repo.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val repo: TaskRepo,
    private val userRepo: UserRepo
) : ViewModel() {
    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    fun getUser(): String? {
        return userRepo.getUser()
    }

    fun addTask(title: String, desc:String){
        viewModelScope.launch {
            try{
                validateTasks(title, desc)
                val task = Task(title = title, desc = desc)
                repo.addTask(task)
            }catch(e: Exception){
                _error.emit(e.message.toString())
            }
        }
    }

    fun validateTasks(title: String, desc: String){
        require(title.isNotEmpty()){"Title cannot be empty"}
        require(desc.isNotEmpty()){"Description cannot be empty"}
        require(Regex("^[A-Za-z0-9 ]+$").containsMatchIn(title)){"Should not contain special chars"}
    }

}