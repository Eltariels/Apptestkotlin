package com.example.apptest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Noir = Color(0xFF050A14)
val Cyan = Color(0xFF00D4FF)
val BleuCard = Color(0xFF0D2137)
val Gris = Color(0xFF8899AA)
val Vert = Color(0xFF00FF88)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CarteUtilisateur() }
    }
}

@Composable
fun CarteUtilisateur() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF0A1628), Noir)))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 1. Titre
        Text("RSI — MON PROFIL", color = Cyan, fontSize = 12.sp, fontWeight = FontWeight.Bold, letterSpacing = 4.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Card
        Card(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = BleuCard),
            modifier = Modifier.fillMaxWidth().border(1.dp, Cyan.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Nom : Théo BORELLA", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("Âge : 22 ans", color = Gris, fontSize = 16.sp)
                Text("Ville : Ambérieu-en-Bugey", color = Gris, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Barre de progression
        Text("PROGRESSION DU COURS : 70%", color = Gris, fontSize = 11.sp, letterSpacing = 2.sp)
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { 0.7f },
            modifier = Modifier.fillMaxWidth().height(5.dp),
            color = Cyan,
            trackColor = BleuCard
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 4. Button
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth().height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Cyan),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text("⚡  VOIR MES COURS", color = Noir, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 5. OutlinedButton
        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth().height(48.dp),
            border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Gris),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text("SE DÉCONNECTER", letterSpacing = 2.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("UEE CERTIFIED  •  ID #THB-2204", color = Color(0xFF334455), fontSize = 8.sp, letterSpacing = 2.sp)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF050A14)
@Composable
fun Apercu() {
    CarteUtilisateur()
}