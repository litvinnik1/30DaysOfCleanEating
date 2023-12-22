package com.example.thirty_days_of_clean_eating

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirty_days_of_clean_eating.model.DishRepository
import com.example.thirty_days_of_clean_eating.model.DishRepository.dishes
import com.example.thirty_days_of_clean_eating.ui.theme.DishesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DishesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DishesApp()
                }
            }
        }
    }
}

@Composable
fun DishesApp(){
        val dishes = DishRepository.dishes
    LazyColumn{
        items(dishes) {
            DishesItem(
                dish = it,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DishesTheme {
    }
}