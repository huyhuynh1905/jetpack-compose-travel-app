package com.example.travelapp.presentation.mainfeature.hoteldetail.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.travelapp.R
import com.example.travelapp.presentation.mainfeature.hoteldetail.widget.PriceAndRating
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.utils.resource.Dimens

@Composable
fun HotelDetail() {
    Column {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Spacer(modifier = Modifier.height(Dimens.pdNormal))

            PriceAndRating()
        }

        ButtonComponent(
            text = stringResource(R.string.start_booking),
            onClick = {

            }
        )
    }
}