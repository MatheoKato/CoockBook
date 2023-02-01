package wsti.marciniuk.mateusz.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import wsti.marciniuk.mateusz.core.database.RecipeDatabase
import wsti.marciniuk.mateusz.core.database.RecipeRepository


abstract class BaseViewModel(
    application: Application
) : AndroidViewModel(application) {

    val database by lazy { RecipeDatabase.getInstance(application) }
    val repository by lazy { RecipeRepository(database.recipeDao()) }
}