package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.ui.theme.Assignment2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceApp() {
    ArtSpaceAppButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ArtSpaceAppButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf( 1) }
    val imageResource = when(result) {
        1 -> R.drawable.cat1
        2 -> R.drawable.cat2
        else -> R.drawable.cat3
    }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(imageResource),
            contentDescription = result.toString(),
            modifier = Modifier.size(300.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Button(
                onClick = { result = if (result == 1) 4 else result - 1 },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = stringResource(R.string.Previous), fontSize = 30.sp)
            }
            Button(
                onClick = { result = if (result == 4) 1 else result + 1 },
            ) {
                Text(text = stringResource(R.string.Next), fontSize = 30.sp)
            }
        }

    }
}