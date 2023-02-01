package wsti.marciniuk.mateusz.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import wsti.marciniuk.mateusz.databinding.ItemRecipeBinding
import wsti.marciniuk.mateusz.models.Recipe

class RecipesAdapter(
    private val recipes: MutableList<Recipe>,
    private val listener: OnRecipeClickListener
): RecyclerView.Adapter<RecipesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.bind(recipes[position], listener)
    }

    override fun getItemCount() = recipes.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(recipes: List<Recipe>){
        this.recipes.clear()
        this.recipes.addAll(recipes)
        notifyDataSetChanged()
    }
}