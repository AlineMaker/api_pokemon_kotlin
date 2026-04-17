package com.aline.pokedex.iu

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
fun DetailScreen(nome: String) {

    val viewModel: PokemonViewModel = viewModel()
    val pokemon by viewModel.pokemon.observeAsState()

    LaunchedEffect(nome) {
        viewModel.buscarPokemon(nome)
    }

    pokemon?.let {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(text = it.name)

            AsyncImage(
                model = it.sprites.front_default,
                contentDescription = it.name,
                modifier = Modifier.size(150.dp)
            )

            Text("Altura: ${it.height}")
            Text("Peso: ${it.weight}")
        }
    }
}