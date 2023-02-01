package wsti.marciniuk.mateusz.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import wsti.marciniuk.mateusz.databinding.FragmentDetailsBinding
import wsti.marciniuk.mateusz.databinding.ItemIngredientsDetailsBinding
import wsti.marciniuk.mateusz.models.Ingredient
import wsti.marciniuk.mateusz.models.Recipe

class DetailsFragment : Fragment(){

    private var _binding: FragmentDetailsBinding? = null

    val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModels()
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
        initClickListeners()
        initObservables()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchData(){
        val recipeId = args.recipeId
        viewModel.onRecipeIdObtained(recipeId)
    }

    private fun initClickListeners(){
        binding.delete.setOnClickListener{
            viewModel.onDeleteClick()
            findNavController().popBackStack()
        }
    }

    private fun initObservables(){
        viewModel.recipe.observe(viewLifecycleOwner, {recipe ->
        recipe?.let { setRecipeData(it) }
        })
    }

    private fun setRecipeData(recipe: Recipe) = with(binding){
        title.text  = recipe.title
        description.text = recipe.description

        for(ingredient in recipe.ingredients){
            val ingredientItem = ItemIngredientsDetailsBinding.inflate(layoutInflater, ingredientsContainer,false)
            val ingredientRoot = ingredientItem.root
            ingredientRoot.text = getFormattedIngredient(ingredient)
            ingredientsContainer.addView(ingredientRoot)
        }
    }

    private fun getFormattedIngredient(ingredient: Ingredient) = with(ingredient){
        "$title $amount".plus(measureType?: "")
    }

}