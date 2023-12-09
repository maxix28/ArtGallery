package com.example.artgallery

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myApp()
                }
            }
        }
    }
}

@Composable
fun myApp(){
    var item by rememberSaveable {
        mutableStateOf(0)
    }
Column(modifier= Modifier.fillMaxSize()){
    ImagePoster(ArtList[item ])
    Title(ArtList[item ])
    Spacer(modifier = Modifier.height(40.dp))
Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.SpaceAround){
    Button(onClick = {
        item--
        if(item<0) item = ArtList.size-1

                     }, modifier = Modifier.width(130.dp)) {
        Text("Previous")
    }
    Button(onClick = {item++
        if(item> ArtList.size-1)item =0
                     }, modifier = Modifier.width(130.dp)) {
        Text("Next")
    }

}
}
}
@Composable
fun Title(art: example){

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clip(shape = RoundedCornerShape(15.dp))
        .drawBehind {
            drawRect(Color.LightGray)
        }, contentAlignment = Alignment.Center,) {
        Column {
            Text(text = art.Title.toString(), fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Row() {
                Text(text = art.Artist.toString(), fontWeight = FontWeight.Light, fontSize = 20.sp)
                Text(
                    text = "(${art.Year.toString()})",
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp
                )

            }
        }
    }
}
@Composable
fun ImagePoster(art: example){
    Box( modifier = Modifier,
        contentAlignment = Alignment.Center,

        )
    {
            Surface( shadowElevation = 12.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)) {


                Image(
                    painter = painterResource(id = art.photo),
                    contentDescription = "Photo",
                    modifier = Modifier
                        .width(300.dp)
                        .height(500.dp)
                        .padding(40.dp)
                )

            }


}
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        myApp()
    }
}