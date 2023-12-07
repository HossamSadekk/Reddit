package com.example.articles.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.articles.R
import com.example.models.domainModels.Post

@Composable
fun PostRow(post: Post) {
    OutlinedCard(
        Modifier.fillMaxWidth().padding(5.dp).clickable {

        },
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp),
            verticalArrangement = Arrangement.Center) {
            Text(
                text = post.author,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                text = post.title,
                maxLines = 2,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            ListingItemFooterView(post)

        }
    }

}
@Composable
fun ListingItemFooterView(post:Post){
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(size = 16.dp),
            contentDescription = null,
            painter = painterResource(id = R.drawable.icon_upvote),
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            text = post.score.toString(),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Icon(
            modifier = Modifier.size(size = 16.dp),
            contentDescription = null,
            painter = painterResource(id = R.drawable.icon_downvote),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(32.dp))
        Icon(
            modifier = Modifier.size(size = 16.dp),
            contentDescription = null,
            painter = painterResource(id = R.drawable.icon_comment),
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            text = post.numComments.toString(),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}