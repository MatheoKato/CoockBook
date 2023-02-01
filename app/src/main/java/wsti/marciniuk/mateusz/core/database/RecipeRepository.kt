package wsti.marciniuk.mateusz.core.database

import wsti.marciniuk.mateusz.models.Recipe

class RecipeRepository(
    private val recipeDao: RecipeDao
) {

    fun getAll() = recipeDao.getAll()

    fun get(id: Long) = recipeDao.get(id)

    suspend fun addAll(recipes: List<Recipe>) = recipeDao.addAll(recipes)

    suspend fun add(recipe: Recipe) = recipeDao.add(recipe)

    suspend fun edit(recipe: Recipe) = recipeDao.edit(recipe)

    suspend fun delete(id: Long) = recipeDao.delete(id)
}