package dev.vinciusmacedo.art_space

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vinciusmacedo.art_space.ui.model.Picture
import dev.vinciusmacedo.art_space.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {

                ArtSpaceApp()

            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    androidx.compose.material.Surface() {

        var imageId by rememberSaveable { mutableStateOf(1) }

        val showedPicture = picturesList[imageId - 1]
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            ShowPicture(showedPicture)
            PictureDescription(showedPicture)
            ButtonsNavigate(onNextClick = {
                if (imageId == picturesList.size) {
                    imageId = 1
                } else {
                    imageId += 1
                }
            },
                onPreviousClick = {
                    if(imageId==1){
                        imageId = picturesList.size
                    }else{
                        imageId--
                    }
                })
        }
    }

}

@Composable
fun ShowPicture(picture: Picture, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(0.90f),
        elevation = 20.dp,
        border = BorderStroke(width = 3.dp, color = Color.Gray),
    ) {
        Image(
            modifier = Modifier.padding(30.dp),
            painter = painterResource(id = picture.img),
            contentDescription = null
        )
    }
}

@Composable
fun PictureDescription(picture: Picture, modifier: Modifier = Modifier) {


    Surface(
        modifier = modifier,
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)
        ) {
            Text(
                text = picture.title,
                fontSize = 28.sp,
            )
            Text(
                text = buildAnnotatedString {
                    append("${picture.artist} ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("(${picture.year})")
                    }
                },
                fontSize = 18.sp
            )


        }
    }
}

@Composable
fun ButtonsNavigate(
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { onPreviousClick() },
            modifier = Modifier.widthIn(150.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = { onNextClick() },
            modifier = Modifier.widthIn(150.dp)
        ) {
            Text(text = "Next")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun ArtScreenAppPreview() {
    ArtSpaceApp()
}