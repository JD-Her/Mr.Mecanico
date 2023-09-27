package com.example.mrmecanico.uis

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MostrarExpediente(
    fecha: String,
    mecanico: String,
    motivo: String,
    adicional: String,
    cedula: String,
    direccion: String,
    telefono: String,
) {
    Column(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth()
    ) {

        Text(
            text = "Datos Generales: ",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            style = androidx.compose.material3.MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.SemiBold))
        Spacer(modifier = Modifier.height(8.dp))

        CampoInformativo("Fecha: ", fecha)
        CampoInformativo(etiqueta = "Mecanico Encargado: ", info = mecanico)
        CampoInformativo(etiqueta = "Motivo de visita: ", info = motivo)
        CampoInformativo(etiqueta = "Inf. Adicional: ", info = adicional)

        Text(text = "Datos Personales: ", fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))

        CampoInformativo(etiqueta = "C.I: ", info = cedula)
        CampoInformativo(etiqueta = "Direccion: ", info = direccion)
        CampoInformativo(etiqueta = "Telefono: ", info = telefono)
    }
}

@Composable
fun CampoInformativo(etiqueta: String, info: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = etiqueta, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
        Text(text = info, fontStyle = FontStyle.Italic, fontSize = 16.sp)
    }
   // Divider(modifier = Modifier.fillMaxWidth())
}