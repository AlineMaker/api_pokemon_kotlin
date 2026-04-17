package com.aline.pokedex.iu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.aline.pokedex.viewmodel.PokemonViewModel

@Composable
fun PokemonScreen(onNavigate: (String) -> Unit) {

    val viewModel: PokemonViewModel = viewModel()
    val pokemon by viewModel.pokemon.observeAsState()

    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Nome ou ID") }
        )

        Button(onClick = {
            viewModel.buscarPokemon(text)
        }) {
            Text("Buscar")
        }

        pokemon?.let {

            Spacer(modifier = Modifier.height(20.dp))

            AsyncImage(
                model = it.sprites.front_default,
                contentDescription = it.name,
                modifier = Modifier.size(150.dp)
            )

            Button(onClick = {
                onNavigate(it.name)
            }) {
                Text(it.name)
            }
        }
    }
}