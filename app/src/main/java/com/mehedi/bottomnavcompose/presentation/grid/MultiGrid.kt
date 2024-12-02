package com.mehedi.bottomnavcompose.presentation.grid

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mehedi.bottomnavcompose.presentation.grid.compoments.Category
import com.mehedi.bottomnavcompose.presentation.grid.compoments.CategoryCard
import com.mehedi.bottomnavcompose.presentation.grid.compoments.FeaturedItem
import com.mehedi.bottomnavcompose.presentation.grid.compoments.FeaturedItemCard
import com.mehedi.bottomnavcompose.presentation.grid.compoments.HomeSection
import com.mehedi.bottomnavcompose.presentation.grid.compoments.PopularItem
import com.mehedi.bottomnavcompose.presentation.grid.compoments.PopularItemCard
import com.mehedi.bottomnavcompose.presentation.grid.utils.gridSection

@Composable
fun ScrollableMultipleGrids(
    viewModel: HomeViewModel = viewModel()
) {
    val context = LocalContext.current
    val sections by viewModel.sections.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val showToast: (String) -> Unit = { message ->
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    if (isLoading) {
        LoadingScreen()
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            sections.forEach { section ->
                when (section) {
                    is HomeSection.Featured -> {
                        gridSection(
                            title = "Featured Items",
                            items = section.items,
                            columns = 2,
                            onClick = { showToast("Clicked Featured: ${it.title}") }
                        ) { item, modifier ->
                            FeaturedItemCard(item = item, modifier = modifier)
                        }
                    }

                    is HomeSection.Category -> {
                        gridSection(
                            title = "Categories",
                            items = section.items,
                            columns = 3,
                            onClick = { showToast("Clicked Category: ${it.name}") }
                        ) { category, modifier ->
                            CategoryCard(category = category, modifier = modifier)
                        }
                    }

                    is HomeSection.Popular -> {
                        gridSection(
                            title = "Popular Items",
                            items = section.items,
                            columns = 3,
                            onClick = { showToast("Clicked Popular: ${it.title}") }
                        ) { item, modifier ->
                            PopularItemCard(item = item, modifier = modifier)
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun GridContent(
    featuredItems: List<FeaturedItem>,
    categories: List<Category>,
    popularItems: List<PopularItem>,
    onItemClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Featured Items Section
        if (featuredItems.isNotEmpty()) {
            gridSection(
                title = "Featured Items",
                items = featuredItems,
                columns = 2,
                onClick = { onItemClick("Clicked Featured: ${it.title}") }
            ) { item, modifier ->
                FeaturedItemCard(item = item, modifier = modifier)
            }
        }

        // Categories Section
        if (categories.isNotEmpty()) {
            gridSection(
                title = "Categories",
                items = categories,
                columns = 3,
                onClick = { onItemClick("Clicked Category: ${it.name}") }
            ) { category, modifier ->
                CategoryCard(category = category, modifier = modifier)
            }
        }

        // Popular Items Section
        if (popularItems.isNotEmpty()) {
            gridSection(
                title = "Popular Items",
                items = popularItems,
                columns = 3,
                onClick = { onItemClick("Clicked Popular: ${it.title}") }
            ) { item, modifier ->
                PopularItemCard(item = item, modifier = modifier)
            }
        }
    }
}








