package com.example.travelapp.presentation.mainfeature.hoteldetail.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.travelapp.R
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.yelBackGr
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.resource.Dimens

@Composable
fun PriceAndRating(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimens.pdMedium
            )
    ) {
        Box(
            modifier = Modifier
                .height(Dimens.heightHoltelPrice)
                .clip(RoundedCornerShape(Dimens.radiusNormal))
                .background(yelBackGr)
                .weight(4f),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = Dimens.pdMedium,
                        vertical = Dimens.pdNormal
                    ),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(R.string.price),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = yellowOr,
                        fontSize = Dimens.textSizeBig
                    )
                )
                Spacer(modifier = Modifier.height(Dimens.pdSmaller))
                Text(
                    text = "\$1.432",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = yellowOr,
                        fontSize = Dimens.textSizeBig
                    )
                )
            }
        }

        Spacer(modifier = Modifier.weight(0.5f))

        Box(
            modifier = Modifier
                .height(Dimens.heightHoltelPrice)
                .clip(RoundedCornerShape(Dimens.radiusNormal))
                .border(
                    color = yelBackGr,
                    width = Dimens.borderWidthMedium,
                    shape = RoundedCornerShape(Dimens.radiusNormal)
                )
                .background(Color.White)
                .weight(6f)
                .padding(Dimens.pdNormal),
            contentAlignment = Alignment.Center
        ) {

            Row {
                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.visiter),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = gray,
                            fontSize = Dimens.textSizeBig
                        )
                    )
                    Spacer(modifier = Modifier.height(Dimens.pdSmaller))
                    Text(
                        text = "341",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Black,
                            fontSize = Dimens.textSizeLarge
                        )
                    )
                }

                Spacer(modifier = Modifier.width(Dimens.pdNormal))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(Dimens.radiusNormal))
                        .background(yelBackGr)
                        .weight(1f)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "4.5",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = yellowOr,
                                fontSize = Dimens.textSizeLarge
                            )
                        )
                        Spacer(modifier = Modifier.width(Dimens.pdSmaller))
                        Icon(
                            Icons.Filled.Star,
                            contentDescription = null,
                            tint = yellowOr
                        )
                    }
                }
            }

        }
    }
}