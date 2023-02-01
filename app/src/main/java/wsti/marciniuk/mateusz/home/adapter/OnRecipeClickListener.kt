package wsti.marciniuk.mateusz.home.adapter

import wsti.marciniuk.mateusz.models.Recipe

interface OnRecipeClickListener {

    fun onItemClick(item: Recipe)
}