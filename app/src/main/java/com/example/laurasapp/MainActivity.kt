package com.example.laurasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laurasapp.ui.theme.LaurasAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaurasAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        MyCountWindow()
                    }
                }
            }
        }
    }
}

/** https://developer.android.com/develop/ui/compose/state#stateful-vs-stateless*/
/** Stateful composable */
@Composable
fun MyCountWindow() {
    val model = viewModel<MyCountViewModel>()
    MyCountWindow(
        countText = model.uiState.count,
        onCounterTapped = {
            model.incrementCount()
        }
    )
}

/** Stateless */
@Composable
fun MyCountWindow(countText: String, onCounterTapped: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.padding(8.dp), horizontalArrangement = spacedBy(24.dp)) {
            Text(
                text = countText,
                fontSize = 30.sp,
                modifier = Modifier.width(80.dp),
                textAlign = TextAlign.Center
            )
            Button(onClick = onCounterTapped) {
                Text("Count")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCountWindowPreview() {
    MyCountWindow(
        countText = "0",
        onCounterTapped = {}
    )
}