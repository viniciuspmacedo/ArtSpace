package dev.vinciusmacedo.art_space

import androidx.compose.ui.res.stringResource
import dev.vinciusmacedo.art_space.ui.model.Picture


val picture1 = Picture(
    id = 1,
    title = "Lagoa Bonita - Lençóis Maranhenses",
    artist = "Vinius",
    img = R.drawable.picture1,
    year = 2022
)

val picture2 = Picture(
    id = 2,
    title = "Rancho da Maioridade - Estrada Velha de Santos",
    artist = "Vinicius",
    img = R.drawable.picture2,
    year = 2022
)
val picture3 = Picture(
    id = 3,
    title = "Pedra do Baú - São Bento do Sapucaí",
    artist = "Vinicius",
    img = R.drawable.picture3,
    year = 2017
)

val picturesList = listOf<Picture>(picture1, picture2, picture3)