package com.mehedi.bottomnavcompose.presentation.grid.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun <T> LazyListScope.gridSection(
    title: String,
    items: List<T>,
    columns: Int,
    onClick: (T) -> Unit,
    content: @Composable (T, Modifier) -> Unit
) {
    item {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }

    val rows = (items.size + (columns - 1)) / columns
    items(rows) { row ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(columns) { column ->
                val index = row * columns + column
                if (index < items.size) {
                    Box(modifier = Modifier.weight(1f)) {
                        content(
                            items[index],
                            Modifier
                                .fillMaxWidth()
                                .clickable { onClick(items[index]) }
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}