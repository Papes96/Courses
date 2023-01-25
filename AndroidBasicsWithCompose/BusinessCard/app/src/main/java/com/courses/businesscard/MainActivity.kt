package com.courses.businesscard

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.courses.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("IntentReset")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val developerDTO = DeveloperDTO(
                        painterResource(R.drawable.ic_picture),
                        stringResource(R.string.name),
                        stringResource(R.string.title),
                        listOf(
                            Content(painterResource(R.drawable.ic_email), "javier.papes@gmail.com", Intent(Intent.ACTION_SENDTO).apply {
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                data = Uri.parse("mailto:" + "javier.papes@gmail.com")
                            }),
                            Content(painterResource(R.drawable.ic_phone), "+59 (341) 5313420", Intent(Intent.ACTION_DIAL).apply {
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                data = Uri.parse("tel:" + "+59 (341) 5313420")
                            }),
                            Content(painterResource(R.drawable.ic_linkedin), "LinkedIn", Intent(Intent.ACTION_VIEW).apply {
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                data = Uri.parse("https://www.linkedin.com/in/javier-papes-b0914414a/")
                            }),
                            Content(painterResource(R.drawable.ic_github), "GitHub", Intent(Intent.ACTION_VIEW).apply {
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                data = Uri.parse("https://github.com/Papes96")
                            }),
                            Content(painterResource(R.drawable.ic_person), "Curriculum", Intent(Intent.ACTION_VIEW).apply {
                                type = "application/pdf"
                                data = Uri.parse("https://drive.google.com/file/d/1tCZue7Q3XbkDcO0rQOd2qDuVrMCOntnU/view?usp=share_link")
                                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                            }),
                        )
                    )
                    MainContent(developerDTO)
                }
            }
        }
    }

    private fun onClickContent(intent: Intent) {
        startActivity(intent)
    }


    @Composable
    fun MainContent(developerDTO: DeveloperDTO) {
        Column(
            Modifier
                .fillMaxSize()
                .background(colorResource(R.color.crocodile))
                .verticalScroll(rememberScrollState()),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.weight(1f))
            Profile(developerDTO.picture)
            Spacer(Modifier.weight(0.10f))
            Name(developerDTO.name)
            Title(developerDTO.title)
            Spacer(Modifier.weight(1f))
            developerDTO.content.forEach {
                ContactRow(it)
            }
            Spacer(Modifier.weight(0.20f))
        }
    }

    @Composable
    fun Profile(picture: Painter) {
        Image(
            painter = picture,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
    }

    @Composable
    fun Name(title: String) {
        Text(
            text = title,
            fontWeight = FontWeight.Light,
            color = colorResource(R.color.almond),
            textAlign = TextAlign.Center,
            fontSize = 44.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
        )
    }

    @Composable
    fun Title(subtitle: String) {
        Text(
            text = subtitle,
            color = colorResource(R.color.hampton),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
        )
    }

    @Composable
    fun Link(text: String) {
        Text(
            text = text,
            color = colorResource(R.color.hampton),
            maxLines = 1
        )
    }

    @Composable
    fun ContactRow(content: Content) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 8.dp)
                .clickable { onClickContent(content.intent) }
        ) {
            Icon(
                content.icon,
                null,
                tint = colorResource(R.color.almond),
                modifier = Modifier.padding(16.dp, 0.dp)
            )
            Link(content.text)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        BusinessCardTheme {
            val developerDTO = DeveloperDTO(
                painterResource(R.drawable.ic_picture),
                stringResource(R.string.name),
                stringResource(R.string.title),
                listOf(
                    Content(painterResource(R.drawable.ic_email), "javier.papes@gmail.com", Intent()),
                    Content(painterResource(R.drawable.ic_phone), "+59 (341) 5313420", Intent()),
                    Content(painterResource(R.drawable.ic_linkedin), "LinkedIn", Intent()),
                    Content(painterResource(R.drawable.ic_github), "GitHub", Intent()),
                    Content(painterResource(R.drawable.ic_person), "Curriculum", Intent()),
                )
            )
            MainContent(developerDTO)
        }
    }
}