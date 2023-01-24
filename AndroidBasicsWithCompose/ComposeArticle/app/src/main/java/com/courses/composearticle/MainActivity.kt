package com.courses.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.courses.composearticle.ui.theme.ComposeArticleTheme

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
                    Article(
                        painterResource(R.drawable.bg_compose_background),
                        stringResource(R.string.default_title),
                        arrayOf(
                            stringResource(R.string.default_paragraph_1),
                            stringResource(R.string.default_paragraph_2)
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun HeaderImage(image: Painter) {
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Paragraph(paragraph: String) {
    Text(
        text = paragraph,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Article(image: Painter, title: String, paragraphs: Array<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderImage(image)
        Title(title)
        paragraphs.forEach {
            Paragraph(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        Article(
            painterResource(R.drawable.bg_compose_background),
            stringResource(R.string.default_title),
            arrayOf(
                stringResource(R.string.default_paragraph_1),
                stringResource(R.string.default_paragraph_2)
            )
        )
    }
}