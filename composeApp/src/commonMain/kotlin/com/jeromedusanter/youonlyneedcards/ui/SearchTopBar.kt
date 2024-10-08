package com.jeromedusanter.youonlyneedcards.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.jeromedusanter.youonlyneedcards.ui.theme.colorDarkBlue
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_list_search_bar_placeholder
import org.jetbrains.compose.resources.stringResource

@Composable
fun SearchTopBar(
    modifier: Modifier = Modifier,
    showInputField: Boolean = false,
    searchQuery: String = "",
    onClearSearchQuery: () -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {},
    onChangeInputFieldVisibility: () -> Unit = {}
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(showInputField) {
        if (showInputField) {
            focusRequester.requestFocus() // Request focus when the input field is shown
        } else {
            focusManager.clearFocus() // Clear focus when input field is hidden
        }
    }
    if (showInputField) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onChangeInputFieldVisibility) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            TextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                placeholder = {
                    Text(
                        text = stringResource(Res.string.game_list_search_bar_placeholder),
                        color = Color.White
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Transparent)
                    .focusRequester(focusRequester),
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    textColor = Color.White,
                    backgroundColor = colorDarkBlue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
            )
            IconButton(onClick = onClearSearchQuery) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    } else {
        IconButton(onClick = onChangeInputFieldVisibility) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}