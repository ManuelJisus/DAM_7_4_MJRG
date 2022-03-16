// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.jetbrains.skia.Image
import org.w3c.dom.Text
import javax.swing.Painter

@Composable
@Preview

fun MySquare(texto: String, imagen: androidx.compose.ui.graphics.painter.Painter) {
    Surface(
        color = Color.LightGray,
        modifier = Modifier.size(200.dp)
    ) {
        Image(
            painter = imagen,
            contentDescription = "Gusano",
            modifier = Modifier.fillMaxSize()
        )
    }
    Surface(
        color = Color.LightGray,
        modifier = Modifier.size(200.dp)
    )
    {
        Text(
            text = texto,
            style = MaterialTheme.typography.h5,
            fontSize = 15.sp,
            color = Color.Red,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline


        )
    }
}


@Composable
@Preview
fun App() {
    //Fotos
    val fondo = painterResource("fondo.jpg")
    val gusanoF = painterResource("gusano.jpg")
    val gusanoaF = painterResource("gusanoa.jpg")
    val crisalidaF = painterResource("crisalida.png")
    val mariposaF = painterResource("mariposa.jpg")


    var text by remember { mutableStateOf("Al principio la mariposa es un gusano") }
    var text1 by remember { mutableStateOf("el gusano se forma su crisalida") }
    var text2 by remember { mutableStateOf("la crisalida dura sus meses") }
    var text3 by remember { mutableStateOf("Y FINALMENTE AQUÍ nace !") }
    var text4 by remember { mutableStateOf("EY") }
    var gusano by remember { mutableStateOf(false) }
    var gusanoA by remember { mutableStateOf(false) }
    var crisalida by remember { mutableStateOf(false) }
    var mariposa by remember { mutableStateOf(false) }
    Image(
        painter = fondo,
        contentDescription = "Gusano",
        modifier = Modifier.fillMaxSize()
    )


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(1f)
            .width(150.dp)

    ) {
        Row(
        ) {

            Text(
                text = "Como nace una mariposa",
                modifier = Modifier
                    .width(150.dp)
                    .height(75.dp),

                color = Color.Red,
                textAlign = TextAlign.Center,


                )
        }
        Spacer(Modifier.size(25.dp))
        Row {
            Button(


                onClick = {
                    gusano = !gusano
                }) {
                Text(text)
            }



            if (gusano == true) {
                MySquare(
                    "Los huevos permanecen aparentemente inactivos durante el verano, otoño e invierno, hasta que en primavera eclosionan las larvas, coincidiendo con el despertar del árbol de cuyas hojas se alimentan, la morera,",
                    gusanoF
                )
            }


        }

        Row {

            Button(onClick = {
                gusanoA = !gusanoA
            }) {
                Text(text1)
            }
            if (gusanoA == true) {
                MySquare(
                    "Al cabo de alrededor de un mes, la oruga busca un lugar seco y aislado, en donde fabricará el capullo para la fase de crisálida (también conocida como pupa); este puede ser de color blanco, amarillo, naranja o rosado.",
                    gusanoaF
                )
            }
        }
        Row {
            Button(onClick = {
                crisalida = !crisalida
            }) {
                Text(text2)
            }
            if (crisalida == true) {
                MySquare(
                    "El capullo está hecho de un hilo de seda cruda de 300 a aproximadamente 900 m (1000 a 3000 pies) de largo. Las fibras son muy finas y brillantes, de aproximadamente 10 μm (0,0004 in) de diámetro",
                    crisalidaF
                )
            }
        }
        Row {
            Button(onClick = {
                mariposa = !mariposa
            }) {
                Text(text3)
            }
            if (mariposa == true) {
                MySquare(
                    "Al eclosionar de la crisálida, la mariposa rompe el capullo con una secreción ácida que separa los hilos de seda y sale al exterior, durante los tres a quince días que suele vivir no se alimentará,",
                    mariposaF
                )
            }


        }
    }
}


