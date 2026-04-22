package com.aline.pokedex.iu


import com.aline.pokedex.R
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.aline.pokedex.viewmodel.PokemonViewModel
import androidx.compose.ui.text.font.FontWeight

@Composable
fun PokemonScreen(onNavigate: (String) -> Unit) {

    val viewModel: PokemonViewModel = viewModel()
    //val pokemon by viewModel.pokemon.observeAsState()
    val pokemons by viewModel.pokemons.observeAsState(emptyList())

    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(247, 247, 247, 255)),

        ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(199, 74, 64, 255)),

            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center


        ) {
            Row(modifier = Modifier,)
            {
                Spacer(modifier= Modifier.width(20.dp))
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(R.drawable.ic_pokebola),
                    colorFilter = ColorFilter.tint(color = Color.White),
                    contentDescription = "Pokebola"
                )
                Spacer(modifier= Modifier.height(10.dp))
                Spacer(modifier= Modifier.width(16.dp))
                Text(text = "Pokédex",
                    fontWeight = FontWeight.Bold,
                    fontSize = (32.sp),
                    color = Color.White)}

        }

    Column(modifier = Modifier,) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Nome ou ID") },
           // usar um IconButton para envolver o icone a um button e tornalo clicavel

            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = " "

                )

                IconButton(onClick = {
                   // isso que faz buscar pokemon
                    viewModel.buscarPokemon(text)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar"
                    )
                }

                 },

            modifier = Modifier
                .fillMaxWidth(.98f)
                .padding(all = 20.dp)
                .background(Color(247, 247, 247, 253)),
            shape = RoundedCornerShape(20.dp)

            )

       // Spacer(modifier= Modifier.height(10.dp))
       // Button(onClick = {
         //   viewModel.buscarPokemon(text)
       // }) {
          //  Text("Buscar")
      //  }

       // pokemon?.let {

            Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize()
        ) {
            items(pokemons) { pokemon ->

                Column(
                    modifier = Modifier.padding(8.dp)
                ) {

                AsyncImage(
                        // model = it.sprites.front_default,
                     model = pokemon.sprites.front_default,

                         //contentDescription = it.name,
                     contentDescription = pokemon.name,
                         // modifier = Modifier.size(150.dp)
                     modifier = Modifier.size(150.dp)
            )

           Button(onClick = {
               // onNavigate(it.name)
                onNavigate(pokemon.name)

           }) {
               // Text(it.name)
               Text(pokemon.name)
           }

                }
            }
        }
    }
}

}