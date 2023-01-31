package wsti.marciniuk.mateusz.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import wsti.marciniuk.mateusz.R
import wsti.marciniuk.mateusz.databinding.FragmentHomeBinding
import wsti.marciniuk.mateusz.home.adapter.RecipesAdapter

class HomeFragment:Fragment() {

    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!! //zmienna która napewno nie jest nullem

    private val viewModel: HomeFragmentViewModel by viewModels()

    private var recipesAdapter: RecipesAdapter = RecipesAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initClickListener()
        initObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initRecycler(){
        binding.recipesRecycler.layoutManager = LinearLayoutManager(context)
        binding.recipesRecycler.adapter = recipesAdapter

    }

    private fun initClickListener(){
        binding.addButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }
    }

    private fun initObservers(){
        viewModel.recipes.observe(viewLifecycleOwner, { recipes ->  //this (viewLifecycleOwner)
            recipesAdapter.setItems(recipes)
        })
    }

}