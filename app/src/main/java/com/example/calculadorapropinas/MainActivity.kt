package com.example.calculadorapropinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalculadoraPropinas()
        }
    }
}

@Composable
fun CalculadoraPropinas() {

    var montoCuenta by remember { mutableStateOf("") }
    var porcentajePropina by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Calculadora de Propinas",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = montoCuenta,
            onValueChange = {
                montoCuenta = it
            },
            label = {
                Text("Monto de la cuenta")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = porcentajePropina,
            onValueChange = {
                porcentajePropina = it
            },
            label = {
                Text("Porcentaje de propina")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val monto = montoCuenta.toDoubleOrNull() ?: 0.0
                val porcentaje = porcentajePropina.toDoubleOrNull() ?: 0.0

                resultado = monto * porcentaje / 100
            }
        ) {

            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Propina: $${String.format("%.2f", resultado)}",
            fontSize = 24.sp
        )
    }
}