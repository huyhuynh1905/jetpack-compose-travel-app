package com.example.travelapp.presentation.mainfeature.homescreen.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.travelapp.domain.model.PlaceModel
import com.example.travelapp.ui.component.ImageCardView
import com.example.travelapp.ui.themes.redBg
import com.example.travelapp.utils.resource.Dimens


@Composable
fun PerfectForYou(places: List<PlaceModel>) {
    Column(
        modifier = Modifier
            .padding(
                top = Dimens.pdMedium,
                start = Dimens.pdMedium,
                end = Dimens.pdMedium
            )
    ) {
        //Phần title
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Perfect for you",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Filter",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = redBg
                )
            )
        }

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(Dimens.pdNormal),
            verticalItemSpacing = Dimens.pdNormal,
            horizontalArrangement = Arrangement.spacedBy(Dimens.pdNormal),
            userScrollEnabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            items(places.size) { index ->
                ImageCardView(
                    model = places[index].urlImage,
                    contentDescription = places[index].placeName,
                    height = (150..300).random().dp,
                    elevation = Dimens.zero,
                    contentScale = ContentScale.Crop,
                    tag = places[index].tagCategory,
                    distance = places[index].distance
                )
            }
        }
    }
}