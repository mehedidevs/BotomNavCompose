package com.mehedi.bottomnavcompose.presentation.grid.compoments

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun FeaturedItemCard(
    item: FeaturedItem,
    modifier: Modifier = Modifier
) {
    ItemCard(
        text = item.title,
        height = 120.dp,
        elevation = 4.dp,
        modifier = modifier
    )
}
