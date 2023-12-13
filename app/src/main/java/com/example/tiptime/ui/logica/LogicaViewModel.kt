package com.example.tiptime.ui.logica

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class LogicaViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(LogicaUiState())
    val uiState: StateFlow<LogicaUiState> = _uiState.asStateFlow()

    fun onChange(dato: String){
        var numTextFielAux:Double = dato.toDouble()
        _uiState.update { currentState -> currentState.copy(
            numTotal = calculateTip(numTextFielAux, _uiState.value.porcentaje),
            numTextFiel = numTextFielAux

        ) }
    }


    private fun calculateTip(amount: Double, tipPercent: Double = 15.0): Double {
        val tip = tipPercent / 100 * amount
        return tip
    }

    fun onChangePorcentaje(it: String) {
        _uiState.update { currentState -> currentState.copy(
            numTotal = calculateTip(_uiState.value.numTextFiel, it.toDouble()),
            porcentaje = it.toDouble()

        ) }
    }
}