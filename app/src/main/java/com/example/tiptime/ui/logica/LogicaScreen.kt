package com.example.tiptime.ui.logica

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tiptime.R
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TipTimeLayout(viewModel: LogicaViewModel = viewModel()) {
    val logicaUiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding()
            .background(Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            Modifier
                .padding(bottom = 40.dp)
                .fillMaxWidth(),
            logicaUiState.numTextFiel,
            viewModel
        )
        Text(
            text = stringResource(R.string.tip_amount, logicaUiState.numTotal),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(modifier: Modifier = Modifier,num:Double,viewModel: LogicaViewModel) {
    TextField(
        value = num.toString(),
        onValueChange = {viewModel.onChange(it)} ,
        modifier = modifier
    )
}