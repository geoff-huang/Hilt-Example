package com.example.hiltexample

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hiltexample.ui.theme.HiltExampleTheme

@Composable
fun TestComposable(
    viewModel: TestViewModel = hiltViewModel(),
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TestComposablePreview() {
    HiltExampleTheme {
        TestComposable(name = "Android")
    }
}