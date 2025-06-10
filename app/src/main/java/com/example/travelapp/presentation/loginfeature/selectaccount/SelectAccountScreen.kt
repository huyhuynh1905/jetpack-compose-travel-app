package com.example.travelapp.presentation.loginfeature.selectaccount

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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.domain.model.SelectAccountModel
import com.example.travelapp.ui.component.AppBarComponent
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.component.ChangeStatusBarColor
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.navigation.ScreenNames
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.redBg
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.extension.customClickable
import com.example.travelapp.utils.resource.Dimens

@Composable
fun SelectAccountScreen(navController: NavController) {
    ChangeStatusBarColor(isAppearanceLightStatusBars = true)
    BaseScreen(
        viewModel = hiltViewModel<SelectAccountViewModel>(),
        background = Color.White,
        isSafeArea = false
    ) { viewModel ->
        val listAccountState = viewModel.listAccountState.collectAsState()
        val selectedAcc = viewModel.selectedAccountState.collectAsState()

        Column {
            AppBarComponent(
                title = "",
                navController = navController
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
                    painter = painterResource(id = R.drawable.ic_plane),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(id = R.string.hello_there),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = yellowOr,
                        fontSize = Dimens.textSizeSpecialLarge
                    )
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(id = R.string.des_select_account),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = gray
                    )
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))

                //phần hiển thị list item
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    items(listAccountState.value.size) { index ->
                        SelectAccountItem(
                            selectAccountModel = listAccountState.value[index],
                            selectedAcc = selectedAcc.value,
                            click = { item ->
                                viewModel.showLog("SelectAccountItem click: ${item.name}")
                                viewModel.onChangeSelectedAcc(item)
                            }
                        )
                    }

                    // Bọc AddAccountItem trong một item block
                    item(key = "add_account_button") { // Cung cấp một key cố định cho item này
                        AddAccountItem(
                            click = {
                                viewModel.showLog("AddAccountItem click")
                                navController.navigate(ScreenNames.ADD_ACC_SCREEN)
                            }
                        )
                    }

                }

                //Phần button ở dưới
                ButtonComponent(
                    text = "Next",
                    onClick = {
                        navController.navigate(ScreenNames.ADD_ACC_SCREEN)
                    }
                )
                Spacer(modifier = Modifier.height(Dimens.pdSmaller))
            }
        }
    }
}

@Composable
fun SelectAccountItem(
    selectAccountModel: SelectAccountModel,
    click: (SelectAccountModel) -> Unit,
    selectedAcc: SelectAccountModel?,
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
                    click(selectAccountModel)
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
                AsyncImage(
                    model = selectAccountModel.avatarUrl,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_plane),
                    error = painterResource(id = R.drawable.ic_plane),
                    modifier = Modifier
                        .size(Dimens.sizeAvatarLogin)
                        .clip(RoundedCornerShape(Dimens.radiusMedium))
                        .background(Color.White),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(Dimens.pdNormal))
                Text(
                    text = selectAccountModel.name,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            //icon
            if (selectedAcc != null && selectedAcc.id == selectAccountModel.id) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = yellowOr
                )
            }
        }
    }
}

@Composable
fun AddAccountItem(
    click: () -> Unit,
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
                    click()
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
                Surface(
                    shape = RoundedCornerShape(Dimens.radiusMedium),
                    color = Color.White,
                    modifier = Modifier
                        .size(Dimens.sizeAvatarLogin)
                        .shadow( // Áp dụng shadow cho Box
                            elevation = Dimens.elevationMedium,
                            shape = RoundedCornerShape(Dimens.radiusMedium), // Hình dạng của shadow, nên khớp với hình dạng bạn muốn cho Icon
                            clip = false // Nếu true, Box sẽ bị clip theo shape, shadow vẫn vẽ bên ngoài,
                        )
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(Dimens.radiusMedium),
                        )
                        .padding(Dimens.pdSmaller)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = redBg,
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(Dimens.pdNormal))
                Text(
                    text = stringResource(R.string.use_another_account),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = gray
                    )
                )
            }
        }
    }
}


@Pixel6APreview
@Composable
fun SelectAccountScreenPreview() {
    SelectAccountScreen(navController = NavController(LocalContext.current))
}