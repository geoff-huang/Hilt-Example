package com.example.hiltexample

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    val repository: TestSingletonRepository,
    val testClass1: TestClass1,
) : ViewModel() {
    // Add ViewModel logic here
}