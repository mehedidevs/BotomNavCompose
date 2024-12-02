package com.mehedi.bottomnavcompose.presentation.grid.compoments

sealed class HomeSection {
    data class Featured(val items: List<FeaturedItem>) : HomeSection()
    data class Category(val items: List<com.mehedi.bottomnavcompose.presentation.grid.compoments.Category>) : HomeSection()
    data class Popular(val items: List<PopularItem>) : HomeSection()
}
// Data classes
data class FeaturedItem(
    val id: String,
    val title: String
)

data class Category(
    val id: String,
    val name: String
)

data class PopularItem(
    val id: String,
    val title: String
)