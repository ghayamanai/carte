package com.example.carte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carte.ui.theme.carteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            carteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StudentBusinessCard()
                }
            }
        }
    }
}

@Composable
fun StudentBusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        val logoPainter = painterResource(id = R.drawable.ic_task_completed)
        Box(
            modifier = Modifier
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            LogoSection(
                logoPainter = logoPainter,
                name = "Étudiante Ghaya Manai",
                role = "Étudiante en Design"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        ContactInfoSection(
            phoneNumber = "+216 55 000 000",
            email = "ghaya@gmail.com",
            website = "ghaya.com"
        )
    }
}

@Composable
fun LogoSection(logoPainter: Painter, name: String, role: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = logoPainter,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            color = Color.Black
        )
        Text(
            text = role,
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ContactInfoSection(phoneNumber: String, email: String, website: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Phone",
                tint = Color(0xFF3DDC84)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = phoneNumber)
        }
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email",
                tint = Color(0xFF3DDC84)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = email)
        }
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Website",
                tint = Color(0xFF3DDC84)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = website)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    carteTheme {
        StudentBusinessCard()
    }
}
