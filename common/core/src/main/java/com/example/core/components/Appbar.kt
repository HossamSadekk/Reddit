package com.example.core.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.core.theme.theme.DpDimensions

@Composable
fun AppBar(
    title: String
) {
    Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.primary).fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
        )
    }

}

@Composable
fun AppBarWithBackIcon(
    title: String,
    @DrawableRes backIcon: Int,
    onBackClick: () -> Unit = {}
){
    Box(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                vertical = DpDimensions.Small
            )
        ) {

            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = backIcon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Light
                ),
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = DpDimensions.Smallest),
                textAlign = TextAlign.Start,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}