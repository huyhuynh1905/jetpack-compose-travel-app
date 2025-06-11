package com.example.travelapp.presentation.loginfeature.addaccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.presentation.loginfeature.addaccount.support.TypeAddAccountEntity
import com.example.travelapp.ui.component.AppBarComponent
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.component.ChangeStatusBarColor
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.navigation.LocalNavController
import com.example.travelapp.ui.navigation.ScreenNames
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.extension.customClickable
import com.example.travelapp.utils.resource.Dimens

@Composable
fun AddAccountScreen() {
    ChangeStatusBarColor(isAppearanceLightStatusBars = true)

    BaseScreen(viewModel = hiltViewModel<AddAccountViewModel>(), isSafeArea = false) { viewModel ->
        val navController = LocalNavController.current
        val listType = viewModel.listTypeState.collectAsState()
        val typeSelect = viewModel.selectTypeAddState.collectAsState()

        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            AppBarComponent(
                title = "",
                navController = navController!!
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        vertical = Dimens.pdNormal,
                        horizontal = Dimens.pdLarge
                    )
            ) {
                //phần hiển thị thông tin
                Spacer(modifier = Modifier.height(Dimens.pdBig))
                Image(
                    painter = painterResource(id = R.drawable.ic_vali),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(id = R.string.add_account),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = yellowOr,
                        fontSize = Dimens.textSizeSpecialLarge
                    )
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(id = R.string.des_add_account),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = gray
                    )
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))
                //nội dung
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    items(listType.value.size) { index ->
                        TypeLoginItem(
                            model = listType.value[index],
                            typeSelect = typeSelect.value,
                            click = { item ->
                                viewModel.showLog("SelectAccountItem click: ${item.title}")
                                viewModel.onChangeSelectedTypeAcc(item)
                            }
                        )
                    }
                }

                //Phần button ở dưới
                ButtonComponent(
                    text = "Next",
                    onClick = {
                        navController?.navigate(ScreenNames.CREATE_ACC_SCREEN)
                    }
                )
                Spacer(modifier = Modifier.height(Dimens.pdSmaller + Dimens.navSysBarHeight))
            }
        }
    }
}

@Composable
fun TypeLoginItem(
    model: TypeAddAccountEntity,
    click: (TypeAddAccountEntity) -> Unit,
    typeSelect: TypeAddAccountEntity?,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = Dimens.pdSmaller
            )
            .customClickable(
                rippleColor = Color.Red,
                onClick = {
                    click(model)
                }
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = model.logo?:R.drawable.ic_vali),
                    contentDescription = null,
                    modifier = Modifier
                        .size(Dimens.sizeAvatarLogin)
                        .clip(RoundedCornerShape(Dimens.radiusMedium))
                        .background(model.bgkColor ?: Color.White)
                        .padding(Dimens.pdNormal),
                )
                Spacer(modifier = Modifier.width(Dimens.pdNormal))
                Text(
                    text = model.title?:"",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            //icon
            if (typeSelect?.logo != null && typeSelect.logo == model.logo) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = yellowOr
                )
            }
        }
    }
}



@Pixel6APreview
@Composable
fun AddAccountScreenPreview() {
    AddAccountScreen()
}