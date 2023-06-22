package com.example.composearticle

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap.Title
import android.media.Image
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleApp(stringResource(R.string.jetpack_compose_tutorial_text))
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp(name: String, modifier: Modifier = Modifier) {
        ArticleCard(
            title = stringResource(R.string.jetpack_compose_tutorial_text),
            shortDescription = stringResource(R.string.compose_short_desc),
            longDescription = stringResource(R.string.compose_long_desc),
            imagePainter = painterResource(R.drawable.bg_compose_background)
        )
}

@Composable
fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
){
    Column(modifier = modifier) {
        Image(painter = imagePainter, contentDescription = null)

        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )

        Text(
            text = shortDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        ComposeArticleApp(stringResource(R.string.jetpack_compose_tutorial_text))
    }
}