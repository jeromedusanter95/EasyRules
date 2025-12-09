package com.jeromedusanter.easyrules.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jeromedusanter.easyrules.ui.theme.colorDarkBlue
import com.jeromedusanter.easyrules.ui.theme.colorWhite
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_filter_switch_apply_filter
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    showArrowBackButton: Boolean,
    showSearchActionButton: Boolean,
    showApplyFilterActionButton: Boolean,
    shouldApplyFilters: Boolean,
    onToggleApplyFilter: (Boolean) -> Unit,
    title: String,
    showSearchBar: Boolean,
    onClickArrowBackButton: () -> Unit,
    onChangeSearchBarVisibility: () -> Unit,
    searchQuery: String,
    onClearSearchQuery: () -> Unit,
    onSearchQueryChange: (String) -> Unit,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorDarkBlue,
            scrolledContainerColor = colorWhite,
            navigationIconContentColor = colorWhite,
            titleContentColor = colorWhite,
            actionIconContentColor = colorWhite
        ),
        title = { Text(text = title) },
        navigationIcon = {
            if (showArrowBackButton) {
                IconButton(onClick = onClickArrowBackButton) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        actions = {
            if (showSearchActionButton) {
                SearchTopBar(
                    searchQuery = searchQuery,
                    onClearSearchQuery = onClearSearchQuery,
                    onSearchQueryChange = onSearchQueryChange,
                    showInputField = showSearchBar,
                    onChangeInputFieldVisibility = onChangeSearchBarVisibility
                )
            } else if (showApplyFilterActionButton) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(Res.string.game_filter_switch_apply_filter),
                        color = colorWhite
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Switch(
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = colorWhite,
                            checkedTrackColor = colorWhite,
                            uncheckedThumbColor = colorWhite,
                            uncheckedTrackColor = colorWhite
                        ),
                        checked = shouldApplyFilters,
                        onCheckedChange = onToggleApplyFilter,
                    )
                }
            }
        },
    )
}