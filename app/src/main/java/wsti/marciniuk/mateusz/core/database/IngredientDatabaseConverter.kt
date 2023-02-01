package wsti.marciniuk.mateusz.core.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import wsti.marciniuk.mateusz.models.Ingredient

class IngredientDatabaseConverter {

    @TypeConverter
    fun toIngredientModel(ingredientJson: String): List<Ingredient> {
        if (ingredientJson.isEmpty()) return emptyList()
        val gson = Gson()
        val type = object : TypeToken<List<Ingredient>>() {}.type
        return gson.fromJson(ingredientJson, type)
    }

    @TypeConverter
    fun fromIngredientModel(ingredientModel: List<Ingredient>): String {
        if (ingredientModel.isNullOrEmpty()) return ""
        val gson = Gson()
        val type = object : TypeToken<List<Ingredient>>() {}.type
        return gson.toJson(ingredientModel, type)
    }
}