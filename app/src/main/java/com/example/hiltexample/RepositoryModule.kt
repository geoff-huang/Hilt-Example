package com.example.hiltexample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTestRepository(
        testClass1: TestClass1,
        testClass2Factory: TestClass2.Factory,
    ): TestSingletonRepository {
        return TestSingletonRepository(testClass1, testClass2Factory)
    }
}