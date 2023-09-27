package com.example.mrmecanico.uis

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mrmecanico.domain.Expediente
import com.example.mrmecanico.ui.theme.MrMecanicoTheme

@Composable
fun CardContent(
    name: String,
    placa: String,
    fecha: String,
    mecanico: String,
    motivo: String,
    adicional: String,
    cedula: String,
    direccion: String,
    telefono: String,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .padding(4.dp)
            .animateContentSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)

        ) {
            Text(text = name)
            Text(
                text = placa.uppercase(),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )

            if (expanded) {
                MostrarExpediente(
                    fecha = fecha,
                    mecanico = mecanico,
                    motivo = motivo,
                    adicional = adicional,
                    cedula = cedula,
                    direccion = direccion,
                    telefono = telefono
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription =
                if (expanded) {
                    "show less"
                } else {
                    "show more"
                }
            )
        }
    }
}

//CardExpediente
@Composable
fun CardElement(
    expediente: Expediente,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 4.dp)
            .clickable { /*onSelectedExp*/ }
//            .pointerInput(Unit) {
//                detectTapGestures(onLongPress = {
//                    mainViewModel.onItemRemove(expediente)
//                })
//            }
    ) {
        CardContent(
            name = expediente.name,
            placa = expediente.placa,
            fecha = expediente.fecha,
            mecanico = expediente.mecanico,
            motivo = expediente.motivo,
            adicional = expediente.adicional,
            cedula = expediente.cedula,
            direccion = expediente.direccion,
            telefono = expediente.telefono,

            )
    }
}

@Composable
fun ListaExpediente(
    modifier: Modifier = Modifier,
    expedientes: List<Expediente>,
    mainViewModel: MainViewModel,
    //names: List<String> = List(10) { "$it" },
) {

  //  val myExp: List<Expediente> = mainViewModel.exp

    LazyColumn(modifier = modifier.padding(4.dp)) {
        items(items = expedientes, key = { it.id }
        ) { expediente ->
            CardElement(
                modifier = Modifier.padding(10.dp),
                expediente = expediente,
                mainViewModel = mainViewModel
            )
        }
    }
}


@Composable
fun FakeExpeDiente(mainViewModel: MainViewModel) {
    MrMecanicoTheme() {
        CardElement(
            expediente = Expediente(
                id = 0,
                name = "Jesus Hernandez",
                placa = "AB678SD",
                fecha = "22 sep",
                mecanico = "Josep",
                motivo = "Caja",
                adicional = "Se rompio",
                cedula = "23554984",
                direccion = "La carlota",
                telefono = "654462"
            ), mainViewModel = mainViewModel
        )
    }
}

//@Preview
//@Composable
//fun FakeList() {
//    MrMecanicoTheme() {
//        val expedientes = Constants.expedientess
//        ListaExpediente(expedientes = expedientes, onSelectedExp = {})
//    }
//}