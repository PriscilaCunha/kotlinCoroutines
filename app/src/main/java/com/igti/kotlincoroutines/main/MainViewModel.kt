package com.igti.kotlincoroutines.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(private val dispatcher: CoroutineDispatcher = Dispatchers.Default) : ViewModel() {
    companion object {
        private const val TAG = "ViewModel"
        private const val INVALID_DATA = -1
        private const val DONE_LEFT_DATA = 10
        private const val DONE_RIGHT_DATA = 20
    }

    private val _leftData = mutableStateOf(INVALID_DATA)
    val leftData : Int get() = _leftData.value

    private val _rightData = mutableStateOf(INVALID_DATA)
    val rightData : Int get() = _rightData.value

    private var currentJob : Job? = null

    fun onButtonClick(useAsync : Boolean) {
        if (currentJob != null) return

        currentJob = viewModelScope.launch {
            Utils.log(TAG, "==== Corroutine criada no launch do botão ====")
        }
    }
}