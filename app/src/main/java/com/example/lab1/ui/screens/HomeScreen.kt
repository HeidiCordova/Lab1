package com.example.lab1.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.R
@Composable
fun HomeScreen(
    onEdificacionesClick: () -> Unit,
    onMapClick: () -> Unit
) {
    // Definir colores según el XML original
    val backgroundColor = Color(0xFFFFF9C4) // Fondo amarillo claro
    val accentColor = Color(0xFF9D7705) // Color dorado/marrón para el título
    val scrollBackgroundColor = Color(0xFFE9C46A) // Color para el ScrollView

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF78878C)) // Color de fondo del FrameLayout
    ) {
        // Equivalente al ScrollView
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(scrollBackgroundColor)
                .verticalScroll(rememberScrollState())
        ) {
            // Contenido principal (LinearLayout)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Header con imagen y título (ConstraintLayout en XML)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Imagen del icono
                    Image(
                        painter = painterResource(id = R.drawable.icono),
                        contentDescription = null,
                        modifier = Modifier
                            .height(83.dp)
                            .padding(bottom = 8.dp),
                        contentScale = ContentScale.Crop
                    )

                    // Texto de bienvenida
                    Text(
                        text = "Bienvenido",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(accentColor)
                            .padding(8.dp),
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }

                // Sección de Edificaciones
                FeatureSection(
                    imageResId = R.drawable.arequipa_bground,
                    description = "Lista de Edificaciones: Explora y conoce más sobre las edificaciones turísticas de Arequipa.",
                    buttonText = "Explorar",
                    onClick = onEdificacionesClick
                )

                // Sección de Mapa
                FeatureSection(
                    imageResId = R.drawable.mpa,
                    description = "Mapa: Encuentra los lugares turísticos y ediciones en Arequipa de forma interactiva.",
                    buttonText = "Ver Mapa",
                    onClick = onMapClick
                )
            }
        }
    }
}

@Composable
fun FeatureSection(
    imageResId: Int,
    description: String,
    buttonText: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Imagen de la característica
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )

        // Descripción
        Text(
            text = description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            color = Color.Black,
            fontSize = 16.sp
        )

        // Botón
        Button(
            onClick = onClick,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
            )
        ) {
            Text(text = buttonText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        Surface {
            HomeScreen(
                onEdificacionesClick = {},
                onMapClick = {}
            )
        }
    }
}