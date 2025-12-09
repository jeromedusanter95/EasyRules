package com.jeromedusanter.easyrules.ui.screen.game.filter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.easyrules.domain.GameTagModel
import com.jeromedusanter.easyrules.ui.screen.game.GameTagMapper
import com.jeromedusanter.easyrules.ui.theme.colorDarkBlue
import com.jeromedusanter.easyrules.ui.theme.colorTransparent
import com.jeromedusanter.easyrules.ui.theme.colorWhite
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_filter_tag_list_section_title
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
            text = stringResource(Res.string.game_filter_tag_list_section_title),
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = colorDarkBlue,
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
        label = { Text(text = stringResource(res), fontSize = 16.sp) },
        border = BorderStroke(width = 1.dp, color = colorDarkBlue),
        selected = selected,
        colors = FilterChipDefaults.filterChipColors(
            containerColor = colorTransparent,
            labelColor = colorDarkBlue,
            selectedContainerColor = colorDarkBlue,
            selectedLabelColor = colorWhite,
            selectedLeadingIconColor = colorWhite,
            disabledLabelColor = if (selected) colorWhite else colorDarkBlue
        ),
    )
}