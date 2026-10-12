package com.example.moviebuzz.ui.screen

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.moviebuzz.domain.movie.CurrentMovie
import com.example.moviebuzz.domain.movie.Movie

private val Background = Color(0xFF071522)
@Preview(showBackground = true)
@Composable
fun MovieDetail(
    onBackClick: () -> Unit = {},
    movie: CurrentMovie,
    movieList: List<CurrentMovie> = emptyList()
) {
    val imageBaseUrl = "https://image.tmdb.org/t/p/w780"
    Scaffold(
        containerColor = Background,
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
            ){
                AsyncImage(
                    model = movie.backdropPath?.let {
                        imageBaseUrl+it
                    },
                    contentDescription = movie.originalTitle,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color(0xFF06111A)
                                ),
                                startY = 200f
                            )

                        )
                )
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(42.dp)
                        .background(
                            Color.Black.copy(alpha = 0.35f),
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                        .size(42.dp)
                        .background(
                            Color.Black.copy(alpha = 0.35f),
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                ){
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.White
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(text = movie.originalTitle, color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    movie.releaseDate?.let { Text(text = it, color = Color.LightGray, fontSize = 14.sp) }

                    Text(text = " • ", color = Color.LightGray, fontSize = 14.sp)

                    Text("Action", color = Color.LightGray, fontSize = 14.sp)

                    Text(text = " • ", color = Color.LightGray, fontSize = 14.sp)

                    Text("IMDB 9.5", color = Color.LightGray, fontSize = 14.sp)

                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.StarRate,
                        contentDescription = "Rating",
                        tint = Color.Yellow,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(text = "8.5", color = Color.LightGray, fontSize = 14.sp, fontWeight = FontWeight.Bold)

                    Text(text = "(452k)", color = Color.LightGray, fontSize = 14.sp)
                }

                Text(text = movie.overview.toString(), color = Color.LightGray, fontSize = 14.sp)

                Spacer(modifier = Modifier.height(18.dp))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF3153)
                    )
                )
                {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        tint = Color.White,
                        contentDescription = "Play",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Watch Trailer", color = Color.White, fontSize = 14.sp)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    MovieItemInfo(
                        icon = Icons.Default.AccessTime,
                        text = "120 min"
                    )

                    MovieItemInfo(
                        icon = Icons.Default.Movie,
                        text = "PG-13"
                    )

                    MovieItemInfo(
                        icon = Icons.Default.Language,
                        text = "English"
                    )

                }
                Spacer(modifier = Modifier.height(25.dp))

                //cast
                Text(text = "Cast", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(12.dp))

                Row(
//                    modifier = Modifier.horizontalScroll(
//                        rememberScrollState()
//                    ),
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {

                    CastItem(
                        name = "Tom Holland",
                        character = "Peter Parker",
                        image = ""
                    )

                    CastItem(
                        name = "Zendaya\nChani",
                        character = "Chani",
                        image = ""
                    )

                    CastItem(
                        name = "Rebecca\nFerguson",
                        character = "Lady Jessica",
                        image = ""
                    )

                    CastItem(
                        name = "Javier\nBardem",
                        character = "Stilgar",
                        image = ""
                    )

                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(text = "Similar Movies", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(12.dp))

                SimilarMovies(movieList)

            }
        }
    }
}

@Composable
fun MovieItemInfo(
    icon: ImageVector,
    text : String
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = text,
            color = Color.LightGray,
            fontSize = 14.sp
        )
    }
}

@Composable
fun CastItem(
    name : String,
    character : String,
    image : String
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(75.dp)
    ){
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .background(Color(0xFF263441)),
            contentAlignment = Alignment.Center

        ){
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = name,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            text = character,
            color = Color.LightGray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun SimilarMovies(
    movieList: List<CurrentMovie> = emptyList()
){
    val imageBaseUrl = "https://image.tmdb.org/t/p/w342"
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(
            items = movieList,
            key = {it.id}
        ){movie->
            Column(
                modifier = Modifier
                    .width(125.dp)
            ){
                AsyncImage(
                    model = movie.posterPath?.let {
                        imageBaseUrl+it
                    },
                    contentDescription = movie.originalTitle,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(175.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = movie.originalTitle,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))

            }
        }

    }
}
