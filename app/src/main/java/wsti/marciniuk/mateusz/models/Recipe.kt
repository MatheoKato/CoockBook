package wsti.marciniuk.mateusz.models

data class Recipe(
    val id: Long,
    val title: String,
    val ingredients: List<Ingredient>,
    val description: String,
)