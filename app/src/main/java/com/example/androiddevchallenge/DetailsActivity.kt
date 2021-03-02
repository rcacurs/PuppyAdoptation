package com.example.androiddevchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.data.PuppyDB
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra("name")
        val puppies = PuppyDB().puppies

        val puppy = puppies.find {it.name == name}

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Puppy Details")
                        }
                    )
                }
            ) {
                MyTheme {
                    // A surface container using the 'background' color from the theme
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                            ) {
                        Image(
                            painterResource(id = puppy?.profilePicId ?: R.drawable.puppy0),
                            contentDescription = "Profile picture of puppy",
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.FillWidth
                        )

                        Text(text= " ${puppy?.name}",
                             style = MaterialTheme.typography.h4,
                             textAlign = TextAlign.Center
                        )
                        Text(text = puppy?.bio ?: "",
                             modifier = Modifier.padding(20.dp),
                             style = MaterialTheme.typography.body1,
                             textAlign = TextAlign.Justify
                        )

                    }

                }
            }
        }
    }
}