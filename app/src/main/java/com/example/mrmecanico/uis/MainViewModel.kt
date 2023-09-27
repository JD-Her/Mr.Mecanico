package com.example.mrmecanico.uis

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mrmecanico.domain.AddExpediente
import com.example.mrmecanico.domain.Expediente
import com.example.mrmecanico.domain.GetExpediente
import com.example.mrmecanico.main.interaction.ExpedienteEvent
import com.example.mrmecanico.main.interaction.ExpedienteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

//Se agregan los casos de uso from domain.
    private val getExpediente: GetExpediente,
    private val addExpediente: AddExpediente

) : ViewModel() {

    private var _state: MutableState<ExpedienteState> = mutableStateOf(ExpedienteState())
    val state: State<ExpedienteState> get() = _state

//    private val _exp = mutableListOf<Expediente>()
//    val exp:List<Expediente> = _exp

    init {
        collectExpedientes()
    }

    fun onEvent(expedienteEvent: ExpedienteEvent){
        when (expedienteEvent){
            is ExpedienteEvent.AddExpediente -> {
                onInsertExpediente(expediente = expedienteEvent.expediente)
            }
        }
    }

    private fun collectExpedientes(){
        viewModelScope.launch(Dispatchers.IO){
            val fetchExpediente = getExpediente()
            withContext(Dispatchers.Main){
                _state.value = _state.value.copy(expediente = fetchExpediente)
            }
        }
    }

    private fun onInsertExpediente(expediente: Expediente){
        viewModelScope.launch(Dispatchers.IO){
            addExpediente(expediente = expediente)
            collectExpedientes()
        }
    }



    var showDialog by mutableStateOf(false)
        private set

    fun onDialogClose() {
        showDialog = false
    }

    fun onExpCreated(exp: String) {
        showDialog = false
        Log.i("Aris", exp)

    }

    fun onShowDialogClick() {
        showDialog = true
    }

    fun onRegisterClick(){
        showDialog = false
    }

//    fun onItemRemove(expediente: Expediente) {
//        val exps = _exp.find { it.id == expediente.id }
//        _exp.remove(exps)
//    }
}