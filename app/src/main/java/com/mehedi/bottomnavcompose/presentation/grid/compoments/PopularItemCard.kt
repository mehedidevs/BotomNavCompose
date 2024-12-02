package com.mehedi.bottomnavcompose.presentation.grid.compoments

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun PopularItemCard(
    item: PopularItem,
    modifier: Modifier = Modifier
) {
    ItemCard(
        text = item.title,
        height = 150.dp,
        elevation = 3.dp,
        modifier = modifier
    )
}
