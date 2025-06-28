package com.example.hiltexample

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestSingletonRepository @Inject constructor(
    val testClass1: TestClass1,
    testClass2Factory: TestClass2.Factory,
) {
    // Add repository logic here
}