package wsti.marciniuk.mateusz.add

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import wsti.marciniuk.mateusz.core.BaseViewModel
import wsti.marciniuk.mateusz.models.Recipe

class AddViewModel(
    application: Application
) : BaseViewModel(application) {

    fun onSaveClick(recipe: Recipe) {
        viewModelScope.launch {
            repository.add(recipe)
        }
    }
}