package com.jeromedusanter.youonlyneedcards.ui.screen.game.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jeromedusanter.youonlyneedcards.ui.theme.colorDarkBlue

@Composable
fun GameList(
    modifier: Modifier = Modifier,
    list: List<GameListItemUiModel>,
    onClick: (Int) -> Unit = {}
) {
    LazyColumn(modifier = modifier.fillMaxSize().background(color = colorDarkBlue)) {
        items(list) {
            GameListItem(uiModel = it, onClick = onClick)
        }
    }
}