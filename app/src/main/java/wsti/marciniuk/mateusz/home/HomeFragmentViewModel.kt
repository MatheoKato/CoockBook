package wsti.marciniuk.mateusz.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import wsti.marciniuk.mateusz.core.BaseViewModel
import wsti.marciniuk.mateusz.models.Ingredient
import wsti.marciniuk.mateusz.models.Recipe
import java.lang.Appendable

class HomeFragmentViewModel(application: Application):BaseViewModel(application) {

    val recipes = MediatorLiveData<List<Recipe>>()

    fun getRecipes() {
        recipes.addSource(repository.getAll()) {
            recipes.value = it
        }
    }
}