package com.igti.kotlincoroutines.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.igti.kotlincoroutines.R
import java.lang.reflect.Modifier

@Composable
fun MainScreen(viewModel: MainViewModel) {
    CoroutinesBasicsTheme() {
        Scaffold (
            topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
        ) {
            MainUI(viewModel)
        }
    }
}

@Composable
fun MainUI(viewModel: MainViewModel) {
    val scrollStateScope = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MainText(
            leftText = viewModel.leftData.toString(),
            rightText = viewModel.rightData.toString()
        )
        DefaultButton(buttonName = "Launch", onButtonClick = {
            viewModel.onButtonClick(useAsync = false)
        })
        Spacer(modifier = Modifier.height(10.dp))

        DefaultButton(buttonName = "Async", onButtonClick = {
            viewModel.onButtonClick(useAsync = true)
        })
        Spacer(modifier = Modifier.height(10.dp))

        DefaultButton(buttonName = "Cancelar", onButtonClick = viewModel.onCancelButtonClick())
        Spacer(modifier = Modifier.height(10.dp))
    }
}