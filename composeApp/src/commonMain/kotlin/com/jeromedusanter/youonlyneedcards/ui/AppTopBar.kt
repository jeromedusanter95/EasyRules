package com.jeromedusanter.youonlyneedcards.ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jeromedusanter.youonlyneedcards.ui.theme.colorDarkBlue
import com.jeromedusanter.youonlyneedcards.ui.theme.colorWhite

@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    showArrowBackButton: Boolean,
    showActionButtons: Boolean,
    title: String,
    showSearchBar: Boolean,
    onClickArrowBackButton: () -> Unit,
    onChangeSearchBarVisibility: () -> Unit,
    searchQuery: String,
    onClearSearchQuery: () -> Unit,
    onSearchQueryChange: (String) -> Unit,
) {
    TopAppBar(
        backgroundColor = colorDarkBlue,
        contentColor = colorWhite,
        title = {
            Text(
                text = title,
                color = colorWhite
            )
        },
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
            if (showActionButtons) {
                SearchTopBar(
                    searchQuery = searchQuery,
                    onClearSearchQuery = onClearSearchQuery,
                    onSearchQueryChange = onSearchQueryChange,
                    showInputField = showSearchBar,
                    onChangeInputFieldVisibility = onChangeSearchBarVisibility
                )
            }
        },
    )
}