package com.courses.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.courses.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val q1 = QuadrantDTO(
                        Color.Green,
                        stringResource(R.string.text_title),
                        stringResource(R.string.text_description)
                    )
                    val q2 = QuadrantDTO(
                        Color.Yellow,
                        stringResource(R.string.image_title),
                        stringResource(R.string.image_description)
                    )
                    val q3 = QuadrantDTO(
                        Color.Cyan,
                        stringResource(R.string.row_title),
                        stringResource(R.string.row_description)
                    )
                    val q4 = QuadrantDTO(
                        Color.LightGray,
                        stringResource(R.string.column_title),
                        stringResource(R.string.column_description)
                    )
                    MainActivityContent(q1, q2, q3, q4)
                }
            }
        }
    }
}

@Composable
fun Title(title: String) {
    Text(
        title,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )
}

@Composable
fun Description(description: String) {
    Text(description, textAlign = TextAlign.Justify)
}

@Composable
fun Quadrant(quadrantDTO: QuadrantDTO) {
    Column(
        Modifier
            .background(quadrantDTO.color)
            .border(1.dp, color = Color.Black)
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        Title(quadrantDTO.title)
        Description(quadrantDTO.description)
    }
}

@Composable
fun MainActivityContent(q1: QuadrantDTO, q2: QuadrantDTO, q3: QuadrantDTO, q4: QuadrantDTO) {

    Column(
        Modifier.fillMaxSize()
    ) {
        Row(
            Modifier.weight(1f)
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                Quadrant(q1)
            }
            Column(
                Modifier.weight(1f)
            ) {
                Quadrant(q2)
            }
        }
        Row(
            Modifier.weight(1f)
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                Quadrant(q3)
            }
            Column(
                Modifier.weight(1f)
            ) {
                Quadrant(q4)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val q1 = QuadrantDTO(
        Color.Green,
        stringResource(R.string.text_title),
        stringResource(R.string.text_description)
    )
    val q2 = QuadrantDTO(
        Color.Yellow,
        stringResource(R.string.image_title),
        stringResource(R.string.image_description)
    )
    val q3 = QuadrantDTO(
        Color.Cyan,
        stringResource(R.string.row_title),
        stringResource(R.string.row_description)
    )
    val q4 = QuadrantDTO(
        Color.LightGray,
        stringResource(R.string.column_title),
        stringResource(R.string.column_description)
    )

    ComposeQuadrantTheme {
        MainActivityContent(q1, q2, q3, q4)
    }
}