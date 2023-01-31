package wsti.marciniuk.mateusz.core.database


import androidx.lifecycle.LiveData
import androidx.room.*
import wsti.marciniuk.mateusz.models.Recipe


@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAll(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE id = :id")
    fun get(id: Long): LiveData<Recipe?>

    @Insert
    suspend fun addAll(recipes: List<Recipe>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(recipe: Recipe)

    @Update
    suspend fun edit(recipe: Recipe)

    @Query("DELETE FROM recipe WHERE id = :id")
    suspend fun delete(id: Long)
}