package com.jeromedusanter.youonlyneedcards.ui.screen.game.filter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.youonlyneedcards.domain.GameTagModel
import com.jeromedusanter.youonlyneedcards.ui.screen.game.GameTagMapper
import com.jeromedusanter.youonlyneedcards.ui.theme.colorPurple
import com.jeromedusanter.youonlyneedcards.ui.theme.colorTransparent
import com.jeromedusanter.youonlyneedcards.ui.theme.colorWhite
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GameFilterTagListSection(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    gameTagIdSelected: List<Int> = emptyList(),
    onClickTag: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Types de jeux",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        val list = GameTagModel.entries
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            list.forEach {
                GameFilterChip(
                    id = it.ordinal,
                    res = GameTagMapper().mapDomainModelToUiModel(it).res,
                    selected = gameTagIdSelected.contains(it.ordinal),
                    onClickTag = onClickTag,
                    enabled = enabled
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GameFilterChip(
    id: Int,
    res: StringResource,
    selected: Boolean,
    onClickTag: (Int) -> Unit,
    enabled: Boolean,
) {
    FilterChip(
        enabled = enabled,
        onClick = { onClickTag(id) },
        content = {
            Text(
                text = stringResource(res),
                fontSize = 16.sp,
                color = if (selected) colorPurple else colorWhite
            )
        },
        border = BorderStroke(width = 1.dp, color = colorWhite),
        selected = selected,
        colors = ChipDefaults.filterChipColors(
            selectedLeadingIconColor = colorPurple,
            leadingIconColor = colorTransparent,
            disabledLeadingIconColor = colorTransparent,
        ),
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(ChipDefaults.LeadingIconSize)
                )
            }
        } else {
            null
        },
    )
}