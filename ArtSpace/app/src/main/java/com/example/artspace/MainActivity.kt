package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceApp()
        }
    }
}
val artworks = listOf(
    Artwork(R.drawable.art1, "The Starry Night", "Vincent van Gogh (1889)"),
    Artwork(R.drawable.art2, "Title 2", "Artist 2 (year)"),
    Artwork(R.drawable.art3, "Title 3", "Artist 3 (year)"),
    Artwork(R.drawable.art4, "Title 4", "Artist 4 (year)"),
    Artwork(R.drawable.art5, "Title 5", "Artist 5 (year)")
)
@Composable
fun ArtSpaceApp(modifier: Modifier= Modifier){
    var currentArtwork by remember{mutableStateOf(0)}
    val artwork = artworks[currentArtwork]

    Column(
        modifier=modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(artwork.imageRes),
            contentDescription = artwork.title,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(300.dp)
        )
        Text(text = artwork.title)
        Text(text = artwork.artist)
        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Button(onClick = {  currentArtwork = (currentArtwork - 1 + artworks.size) % artworks.size}) {
                Text("Previous")
            }
            Button(onClick = {currentArtwork = (currentArtwork + 1) % artworks.size}) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}