package com.mehedi.bottomnavcompose.presentation.grid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.bottomnavcompose.presentation.grid.compoments.Category
import com.mehedi.bottomnavcompose.presentation.grid.compoments.FeaturedItem
import com.mehedi.bottomnavcompose.presentation.grid.compoments.HomeSection
import com.mehedi.bottomnavcompose.presentation.grid.compoments.PopularItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {
    private val _sections = MutableStateFlow<List<HomeSection>>(emptyList())
    val sections = _sections.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(1500)
            try {
                // Get your data
                val featuredItems = getDummyFeaturedItems()
                val categories = getDummyCategories()
                val popularItems = getDummyPopularItems()

                // Create sections based on available data
                val sections = buildList {
                    if (featuredItems.isNotEmpty()) add(HomeSection.Featured(featuredItems))
                    if (categories.isNotEmpty()) add(HomeSection.Category(categories))
                    if (popularItems.isNotEmpty()) add(HomeSection.Popular(popularItems))
                }

                _sections.value = sections
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun getDummyFeaturedItems(): List<FeaturedItem> = listOf(
        FeaturedItem("1", "New iPhone 14"),
        FeaturedItem("2", "Samsung Galaxy S23"),
        FeaturedItem("3", "MacBook Pro M2"),
        FeaturedItem("4", "AirPods Pro"),
        FeaturedItem("5", "iPad Air")
    )

    private fun getDummyCategories(): List<Category> = listOf(
        Category("1", "Phones"),
        Category("2", "Laptops"),
        Category("3", "Tablets"),
        Category("4", "Accessories"),
        Category("5", "Audio"),
        Category("6", "Gaming"),
        Category("7", "Wearables"),
        Category("8", "Smart Home")
    )

    private fun getDummyPopularItems(): List<PopularItem> = listOf(
        PopularItem("1", "iPhone 13"),
        PopularItem("2", "Galaxy Buds"),
        PopularItem("3", "Apple Watch"),
        PopularItem("4", "iPad Mini"),
        PopularItem("5", "MacBook Air"),
        PopularItem("6", "AirPods Max"),
        PopularItem("7", "Galaxy Tab"),
        PopularItem("8", "Pixel 7"),
        PopularItem("9", "Nintendo Switch"),
        PopularItem("10", "PS5"),
        PopularItem("11", "Xbox Series X"),
        PopularItem("12", "Steam Deck"),
        PopularItem("1", "iPhone 13"),
        PopularItem("2", "Galaxy Buds"),
        PopularItem("3", "Apple Watch"),
        PopularItem("4", "iPad Mini"),
        PopularItem("5", "MacBook Air"),
        PopularItem("6", "AirPods Max"),
        PopularItem("7", "Galaxy Tab"),
        PopularItem("8", "Pixel 7"),
        PopularItem("9", "Nintendo Switch"),
        PopularItem("10", "PS5"),
        PopularItem("11", "Xbox Series X"),
        PopularItem("12", "Steam Deck"),
    )

    fun refresh() {
        loadData()
    }
}

