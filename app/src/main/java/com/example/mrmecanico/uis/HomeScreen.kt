package com.example.mrmecanico.uis

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.mrmecanico.R
import com.example.mrmecanico.domain.Expediente
import com.example.mrmecanico.main.interaction.ExpedienteEvent
import com.example.mrmecanico.main.interaction.ExpedienteState

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    expedienteState: ExpedienteState,
    onEvent: (ExpedienteEvent) -> Unit,
) {
//    Box(modifier = Modifier.fillMaxSize()) {
//        Image(
//            painter = painterResource(id = R.drawable.picture_2),
//            contentDescription = "font",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
//    }
    Column(
        modifier = Modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .offset(y = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.photo_2023_05_05_14_09_38),
                contentDescription = "Logo del taller",
                modifier = Modifier.clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(
                text = "BIENVENIDO A MR. MECANICO",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Text(text = "Buscar \n Expediente", textAlign = TextAlign.Center)
            }

            Button(
                onClick = { mainViewModel.onShowDialogClick() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                )
            ) {
                Text(text = "Registrar \n Expediente", textAlign = TextAlign.Center)
            }
        }
        ListaExpediente(expedientes = expedienteState.expediente, mainViewModel = mainViewModel)
        MostrarDialogo(show = mainViewModel.showDialog,
            onDismiss = { mainViewModel.onDialogClose() },
            onEvent = { onEvent(it) }, mainViewModel = mainViewModel
        )
    }
}

@Composable
fun MostrarDialogo(
    show: Boolean,
    onDismiss: () -> Unit,
    onEvent: (ExpedienteEvent) -> Unit,
    mainViewModel: MainViewModel,
    // onExpAdded: (String)->Unit,
    //expediente: Expediente
) {
    var nombre by remember {
        mutableStateOf("")
    }
    var placa by remember {
        mutableStateOf("")
    }
    var fecha by remember {
        mutableStateOf("")
    }
    var mecanico by remember {
        mutableStateOf("")
    }
    var motivo by remember {
        mutableStateOf("")
    }
    var adicional by remember {
        mutableStateOf("")
    }
    var cedula by remember {
        mutableStateOf("")
    }
    var direccion by remember {
        mutableStateOf("")
    }
    var telefono by remember {
        mutableStateOf("")
    }

    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Datos Generales",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                RegistrarCampo(
                    entrada = nombre,
                    etiqueta = "Nombre y Apellido",
                    onValueChange = { nombre = it }
                )
                //{ Icon(imageVector = Icons.Default.Person, contentDescription = null, modifier = Modifier.weight(1f)) }
                Spacer(modifier = Modifier.height(9.dp))

                Row(modifier = Modifier) {
                    RegistrarCampo(
                        entrada = placa,
                        etiqueta = "Placa",
                        onValueChange = { placa = it },
                        modifier = Modifier.weight(1f)
                    )
                    //{ Icon(imageVector = Icons.Default.Edit, contentDescription = null) }
                    Spacer(modifier = Modifier.width(8.dp))

                    RegistrarCampo(
                        entrada = fecha,
                        etiqueta = "Fecha",
                        onValueChange = { fecha = it },
                        modifier = Modifier.weight(1f)
                    )
                    //{ Icon(imageVector = Icons.Default.DateRange, contentDescription = null) }
                }

                Spacer(modifier = Modifier.height(9.dp))
                RegistrarCampo(
                    entrada = mecanico,
                    etiqueta = "Mecanico Encargado",
                    onValueChange = { mecanico = it })
                //{ Icon(imageVector = Icons.Default.Settings, contentDescription = null) }
                Spacer(modifier = Modifier.height(9.dp))

                RegistrarCampo(
                    entrada = motivo,
                    etiqueta = "Motivo de la Visita",
                    onValueChange = { motivo = it })
                //{ Icon(imageVector = Icons.Default.Info, contentDescription = null) }
                Spacer(modifier = Modifier.height(9.dp))

                RegistrarCampo(
                    entrada = adicional,
                    etiqueta = "Informacion Adicional",
                    onValueChange = { adicional = it })
                //{ Icon(imageVector = Icons.Default.Info, contentDescription = null) }
                Spacer(modifier = Modifier.height(9.dp))

                Text(
                    text = "Datos Personales",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Row {
                    RegistrarCampo(
                        entrada = cedula,
                        etiqueta = "Cedula",
                        onValueChange = { cedula = it },
                        modifier = Modifier.weight(1f)
                    )
                    //{ Icon(imageVector = Icons.Default.Person, contentDescription = null) }
                    Spacer(modifier = Modifier.width(8.dp))

                    RegistrarCampo(
                        entrada = telefono,
                        etiqueta = "Telefono",
                        onValueChange = { telefono = it },
                        modifier = Modifier.weight(1f)
                    )
                    //{ Icon(imageVector = Icons.Default.Call, contentDescription = null) }
                    Spacer(modifier = Modifier.height(9.dp))
                }

                RegistrarCampo(
                    entrada = direccion,
                    etiqueta = "Direccion",
                    onValueChange = { direccion = it })
                //{ Icon(imageVector = Icons.Default.Place, contentDescription = null) }
                Spacer(modifier = Modifier.height(9.dp))



                Button(
                    onClick = {
                        onEvent(
                            ExpedienteEvent.AddExpediente(
                                expediente = Expediente(
                                    id = 0,
                                    name = nombre,
                                    placa = placa,
                                    fecha = fecha,
                                    mecanico = mecanico,
                                    motivo = motivo,
                                    adicional = adicional,
                                    cedula = cedula,
                                    direccion = direccion,
                                    telefono = telefono
                                )
                            )
                        )
                        mainViewModel.onRegisterClick()
                    }, modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "REGISTRAR")
                }
            }
        }
    }
}
