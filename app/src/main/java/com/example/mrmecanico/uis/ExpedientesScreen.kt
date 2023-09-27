package com.example.mrmecanico.uis

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Preview
@Composable
fun ExpedientesScreen() {
    var placa by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(text = "Ingrese la placa de su vehiculo")
        TextField(
            value = placa,
            onValueChange = { placa = it },
            label = { Text(text = "Placa del vehiculo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        //---->
        Button(
            onClick = { /* Lógica para guardar el expediente */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Buscar Expediente")
        }
        TextField(
            value = description,
            onValueChange = {description = it},
            label = { Text(text = "Decripcion del expediente")},
            modifier = Modifier.fillMaxWidth()
            )
        Spacer(modifier = Modifier.height(16.dp))

    }
}