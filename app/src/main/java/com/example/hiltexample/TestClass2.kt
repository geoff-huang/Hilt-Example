package com.example.hiltexample

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class TestClass2 @AssistedInject constructor(
    val testClass1: TestClass1,
    @Assisted val pretendThisIsRuntimeDependency: String,
) {

    @AssistedFactory
    interface Factory {
        fun create(pretendThisIsRuntimeDependency: String): TestClass2
    }

    // Add TestClass2 logic here
}