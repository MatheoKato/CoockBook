package wsti.marciniuk.mateusz.home

import androidx.lifecycle.ViewModel
import wsti.marciniuk.mateusz.models.Ingredient
import wsti.marciniuk.mateusz.models.Recipe

class HomeFragmentViewModel:ViewModel() {


    fun getRecipies(): List<Recipe> {
        val ingredient1 = Ingredient("Mleko", 200.0, "ml")
        val ingredient2 = Ingredient("jajka", 2.0, "szt")
        val recipe1 = Recipe(
            0,
            "jajecznica",
            listOf(ingredient1, ingredient2),
            "Wymieszac jajka z mlekiem i wymieszać"
        )
        return listOf(recipe1)
    }
}