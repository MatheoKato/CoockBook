package wsti.marciniuk.mateusz.home.adapter

import androidx.recyclerview.widget.RecyclerView
import wsti.marciniuk.mateusz.databinding.ItemRecipeBinding
import wsti.marciniuk.mateusz.models.Recipe

class RecipesViewHolder(
    private val binding: ItemRecipeBinding
):RecyclerView.ViewHolder(binding.root) {
    fun bind(recipe: Recipe){
        with(recipe){
            binding.title.text = title
        }

    }
}