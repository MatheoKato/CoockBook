package wsti.marciniuk.mateusz.core.database

import android.content.Context
import androidx.room.*
import wsti.marciniuk.mateusz.models.Recipe

@Database(
    entities = [
        Recipe::class
    ],
    version = 1,
    exportSchema = false

)

@TypeConverters(
    IngredientDatabaseConverter::class
)


abstract class RecipeDatabase : RoomDatabase() {

    companion object{
        private const val DATABASE_NAME = "task.db"
        private const val DATABASE_DIR = "database/base_recipies.db"

        fun getInstance(applicationContext: Context) = Room.databaseBuilder(applicationContext, RecipeDatabase::class.java, DATABASE_NAME).createFromAsset(
            DATABASE_DIR).build()
    }

    abstract fun recipeDao(): RecipeDao
}