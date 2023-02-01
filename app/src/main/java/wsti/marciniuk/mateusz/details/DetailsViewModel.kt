package wsti.marciniuk.mateusz.details

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import wsti.marciniuk.mateusz.core.BaseViewModel
import wsti.marciniuk.mateusz.models.Recipe

class DetailsViewModel(application: Application): BaseViewModel(application) {
    val recipe = MediatorLiveData<Recipe?>()

    fun onRecipeIdObtained(recipeId: Long){
        recipe.addSource(repository.get(recipeId)){
            recipe.value = it
        }
    }

    fun onDeleteClick(){
        viewModelScope.launch {
            recipe.value?.let {
                repository.delete(it.id)
            }
        }
    }
}