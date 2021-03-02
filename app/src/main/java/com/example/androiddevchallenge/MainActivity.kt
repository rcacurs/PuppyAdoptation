/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.PuppyDB
import com.example.androiddevchallenge.ui.theme.MyTheme
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppies = PuppyDB().puppies
        setContent {
            MyTheme {
                MyApp(puppies)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(puppies: MutableList<Puppy>) {
    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("Adopt Puppy")
                }
            )
        }
    ) {
        PuppyList(puppies)
    }
}

@Composable
fun PuppyList(puppies: MutableList<Puppy>) {
    LazyColumn(modifier = Modifier.background(color = Color(0xe5ffffff))) {
        items(puppies) { puppy ->
            PuppyElement(puppy)
        }
    }
}

@Composable
fun PuppyElement(puppy: Puppy) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .padding(10.dp)
            .clickable(
                onClick = {
                    val intent = Intent(context, DetailsActivity::class.java)
                    intent.putExtra("name", puppy.name)
                    context.startActivity(intent)
                }
            )
    ) {
        Row(
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = puppy.profilePicId),
                contentDescription = "Profile picture of puppy",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .clip(shape = RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = puppy.name,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@Composable
fun MainActivityContent() {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        MainActivityContent()
    }
}
