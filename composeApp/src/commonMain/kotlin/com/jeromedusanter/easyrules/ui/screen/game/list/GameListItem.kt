package com.jeromedusanter.easyrules.ui.screen.game.list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.easyrules.ui.theme.colorGrayLight
import com.jeromedusanter.easyrules.ui.theme.colorWhite
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GameListItem(
    modifier: Modifier = Modifier,
    uiModel: GameListItemUiModel,
    onClick: (Int) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick(uiModel.id)
            },
        backgroundColor = colorWhite,
        elevation = 4.dp,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = uiModel.name, style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    color = Color(0xFF6C3BC4)
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = uiModel.overview,
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    color = Color(0xFF1C0652),
                    fontStyle = FontStyle.Italic
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            ) {
                uiModel.tagUiModelList.forEach {
                    Text(
                        text = stringResource(it.res),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2B0980),
                        ),
                        modifier = Modifier
                            .border(
                                width = 2.dp,
                                color = colorGrayLight,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = colorGrayLight,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}