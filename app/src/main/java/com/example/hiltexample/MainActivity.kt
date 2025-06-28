package com.example.hiltexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.hiltexample.ui.theme.HiltExampleTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var testClass1: TestClass1

    @Inject
    lateinit var testClass2Factory: TestClass2.Factory
    lateinit var testClass2: TestClass2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("MainActivity", "testClass1: $testClass1")

        testClass2 = testClass2Factory.create("pretendThisIsRuntimeDependency")
        Log.i("MainActivity", "testClass2: $testClass2")

        enableEdgeToEdge()
        setContent {
            HiltExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TestComposable(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    fun testFunction() {
        // If you're unsure about whether this function will be called before onCreate (when
        // testClass2 is initialized), we can check if it's initialized like this.
        if (::testClass2.isInitialized) {
            Log.i("MainActivity", "testClass2: $testClass2")
        }
    }
}
