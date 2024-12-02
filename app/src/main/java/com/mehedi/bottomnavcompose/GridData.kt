package com.mehedi.bottomnavcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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

class HomeViewModel : ViewModel() {
    private val _featuredItems = MutableStateFlow<List<FeaturedItem>>(emptyList())
    val featuredItems = _featuredItems.asStateFlow()

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories = _categories.asStateFlow()

    private val _popularItems = MutableStateFlow<List<PopularItem>>(emptyList())
    val popularItems = _popularItems.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true
            // Simulate network delay
            delay(1500)
            try {
                _featuredItems.value = getDummyFeaturedItems()
                _categories.value = getDummyCategories()
                _popularItems.value = getDummyPopularItems()
            } catch (e: Exception) {
                // Handle error
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

