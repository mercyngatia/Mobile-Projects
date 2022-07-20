package com.example.todoappk.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todoappk.data.ToDoDatabase
import com.example.todoappk.data.models.ToDoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.todoappk.data.repository.ToDoRepository

class ToDoViewModel (application: Application): AndroidViewModel(application){

    private val toDoDao = ToDoDatabase.getDatabase(
        application
    ).todoDao()
    private val repository: ToDoRepository = ToDoRepository(toDoDao)

    val getAllData: LiveData<List<ToDoData>> = repository.getAllData
    val sortByHighPriority: LiveData<List<ToDoData>> = repository.sortByHighPriority
    val sortByLowPriority: LiveData<List<ToDoData>> = repository.sortByLowPriority

//    init {
//        repository = ToDoRepository(toDoDao)
//        getAllData = repository.getAllData
//        sortByHighPriority = repository.sortByHighPriority
//        sortByLowPriority = repository.sortByLowPriority
//    }

    fun insertData(toDoData: ToDoData){
        viewModelScope.launch (Dispatchers.IO)  {
            repository.insertData(toDoData)
        }
    }
    fun updateData(toDoData: ToDoData){
        viewModelScope.launch (Dispatchers.IO)  {
            repository.updateData(toDoData)
        }
    }
    fun deleteItem(toDoData: ToDoData){
        viewModelScope.launch (Dispatchers.IO)  {
            repository.deleteItem((toDoData))
        }
    }
    fun deleteAll(){
        viewModelScope.launch (Dispatchers.IO)  {
            repository.deleteAll()
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<ToDoData>>{
        return repository.searchDatabase(searchQuery)
    }

}