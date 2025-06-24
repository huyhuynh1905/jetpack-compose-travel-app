package com.example.travelapp.presentation.mainfeature.homescreen.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.example.travelapp.presentation.mainfeature.homescreen.support.ItemTagFilter
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.extension.customClickable
import com.example.travelapp.utils.resource.Dimens


@Composable
fun TagFilter(tagList: List<ItemTagFilter>, onClick: (ItemTagFilter) -> Unit) {
    LazyRow {
        items(tagList.size+1){ index ->
            when(index){
                0 -> ItemTagFilterView(
                    item = tagList[index],
                    onClick = {
                        onClick(tagList[index])
                    }
                )
                in 1..tagList.size-1 -> Row {
                    Spacer(modifier = Modifier.width(Dimens.pdMedium))
                    ItemTagFilterView(
                        item = tagList[index],
                        onClick = {
                            onClick(tagList[index])
                        }
                    )
                }
                else -> Spacer(modifier = Modifier.width(Dimens.pdMedium))
            }
        }
    }
}

@Composable
fun ItemTagFilterView(item: ItemTagFilter, onClick: () -> Unit){
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .customClickable(
                rippleColor = yellowOr,
                onClick = {
                    onClick()
                }
            ), // Khoảng cách xung quanh Card
        shape = RoundedCornerShape(Dimens.circleRadius),
        elevation = CardDefaults.cardElevation(defaultElevation = Dimens.elevationMedium),
        colors = CardDefaults.cardColors(containerColor = if(item.isSelected) yellowOr else Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = Dimens.pdMedium,
                    end = Dimens.pdMedium,
                    top = Dimens.pdNormal,
                    bottom = Dimens.pdNormal,
                ), // Khoảng cách bên trong Card
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = item.icon),
                contentDescription = item.name,
                modifier = Modifier.size(Dimens.sizeIconTag), // Kích thước icon
                colorFilter = ColorFilter.tint(if(item.isSelected) Color.White else gray)
            )
            Spacer(modifier = Modifier.size(Dimens.pdNormal)) // Khoảng cách giữa icon và tiêu đề
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = if(item.isSelected) Color.White else gray,
                    fontSize = Dimens.textSizeNormal
                )
            )
        }
    }
}