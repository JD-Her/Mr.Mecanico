package com.example.mrmecanico.uis

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RegistrarCampo(
    modifier: Modifier = Modifier,
    entrada: String,
    etiqueta: String,
    onValueChange: (String) -> Unit,
    //leadingIcon: @Composable () -> Unit
) {
    OutlinedTextField(
        value = entrada,
        onValueChange = { onValueChange(it) },
        label = { Text(text = etiqueta) },
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
        maxLines = 1,
        //  leadingIcon = { leadingIcon }
    )
}

@Composable
fun RadioSelection(selected: Boolean, argument: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = { selected != selected })
        Text(text = argument)
    }
}
