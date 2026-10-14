package com.example.moviebuzz.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ContactMail
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Polyline
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import androidx.room.util.TableInfo

private val Background = Color(0xFF071522)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground=true)
@Composable
fun AboutScreen(
    onBackClick: () -> Unit = {},
){
    Scaffold(
        containerColor = Background,
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Background)
                    .statusBarsPadding()
            ){
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .background(Background)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Text(text = "About", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    ) {innerPadding ->
        Column(
            modifier =  Modifier.fillMaxWidth()
                .background(Background)
                .statusBarsPadding()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "🎬", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 54.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = "Movie", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(text = "Buzz", color = Color.Red, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
            Text(text = "Version 1.0.0", color = Color.LightGray, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(24.dp))

            AboutDetail(
                title = "Rate Us",
                description = "Tell us what you think",
                icon = Icons.Default.StarRate,
                onBackClick = onBackClick
            )
            HorizontalDivider(
                color = Color.Gray,
                modifier = Modifier.padding(end = .01.dp)
            )

            Spacer(modifier = Modifier.height(14.dp))
            AboutDetail(
                title = "Privacy Policy",
                description = "your data is safe with us",
                icon = Icons.Default.PrivacyTip,
                onBackClick = onBackClick
            )
            HorizontalDivider(
                color = Color.Gray,
                modifier = Modifier.padding(end = .01.dp)
            )

            Spacer(modifier = Modifier.height(14.dp))
            AboutDetail(
                title = "Terms of Service",
                description = "Read our terms of service",
                icon = Icons.Default.Polyline,
                onBackClick = onBackClick
            )
            HorizontalDivider(
                color = Color.Gray,
                modifier = Modifier.padding(end = .01.dp)
            )

            Spacer(modifier = Modifier.height(14.dp))
            AboutDetail(
                title = "Contact Us",
                description = "contact@moviebuzz.com",
                icon = Icons.Default.ContactMail,
                onBackClick = onBackClick
            )
            HorizontalDivider(
                color = Color.Gray,
                modifier = Modifier.padding(end = .01.dp)
            )
        }
    }
}

@Composable
fun AboutDetail(
    title: String,
    description: String,
    onBackClick: () -> Unit = {},
    icon: ImageVector,
    ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
            .statusBarsPadding()
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .background(Background)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Back",
                tint = Color.White
            )

        }
        Column(
            modifier = Modifier.padding(5.dp)
                .weight(1f),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = description,
                color = Color.LightGray,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .background(Background)
                .padding(end = 10.dp),
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.padding(end = 10.dp)
            )
        }
    }
}