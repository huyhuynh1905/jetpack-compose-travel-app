package com.example.travelapp.presentation.loginfeature.verifyaccount.support

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.travelapp.utils.resource.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : SupportItemDropdown> DropdownCustom(
    datas: List<T>,
    onItemSelected: (T) -> Unit,
    selectData: T
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        Box(
            modifier = Modifier.menuAnchor()
        ) {
            ItemLayout(selectData)
        }

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .widthIn(min = Dimens.widthFlagDropdown)
                .heightIn(max = Dimens.heightFlagDropdown)
                .background(Color.White)
        ) {
            datas.forEach { selectionOption ->
                DropdownMenuItem(
                    text = {
                        ItemLayout(selectionOption)
                    },
                    onClick = {
                        expanded = false
                        onItemSelected(selectionOption)
                    }
                )
            }
        }
    }
}


@Composable
fun <T : SupportItemDropdown> ItemLayout(
    data: T
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(Dimens.flagSize),
        ) {
            Image(
                painter = painterResource(id = data.getLogo()),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )

        }
        Spacer(modifier = Modifier.width(Dimens.pdSmall))
        Text(
            text = data.getTitle(),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.Black
            )
        )
    }
}