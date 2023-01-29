package wsti.marciniuk.mateusz.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import wsti.marciniuk.mateusz.databinding.ItemRecipeBinding
import wsti.marciniuk.mateusz.models.Recipe

class RecipesAdapter(
    private val recipes: List<Recipe>
): RecyclerView.Adapter<RecipesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount() = recipes.size
}