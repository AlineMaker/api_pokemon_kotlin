package com.aline.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.aline.pokedex.iu.DetailScreen
import com.aline.pokedex.iu.PokemonScreen
import com.aline.pokedex.iu.DetailScreen
import com.aline.pokedex.iu.PokemonScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var screen by remember { mutableStateOf("home") }
            var selectedPokemon by remember { mutableStateOf("") }

            if (screen == "home") {
                PokemonScreen {
                    selectedPokemon = it
                    screen = "detail"
                }
            } else {
                DetailScreen(selectedPokemon)
            }
        }
    }
}