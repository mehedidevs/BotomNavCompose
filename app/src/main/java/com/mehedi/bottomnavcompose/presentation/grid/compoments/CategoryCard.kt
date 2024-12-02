package com.mehedi.bottomnavcompose.presentation.grid.compoments

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CategoryCard(
    category: Category,
    modifier: Modifier = Modifier
) {
    ItemCard(
        text = category.name,
        height = 100.dp,
        elevation = 2.dp,
        modifier = modifier
    )
}