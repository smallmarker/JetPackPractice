package com.smallmarker.jetpackpractice.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections


/**
 * @author   zl
 * @Date     2023/4/21
 **/
class MainViewModel : ViewModel() {

    private val navigateTo = MutableLiveData<NavDirections>()

    fun getNavigateTo(): LiveData<NavDirections> {
        return navigateTo
    }

    fun setNavigateTo(directions: NavDirections) {
        navigateTo.value = directions
    }

}