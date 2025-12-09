package com.jeromedusanter.easyrules.ui.screen.game.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeromedusanter.easyrules.ui.screen.game.GameDifficultyLevelUiModel
import com.jeromedusanter.easyrules.ui.screen.game.GameTagUiModel
import com.jeromedusanter.easyrules.ui.theme.colorWhite
import easyrules.composeapp.generated.resources.Res
import easyrules.composeapp.generated.resources.game_details_end_title
import easyrules.composeapp.generated.resources.game_details_goal_title
import easyrules.composeapp.generated.resources.game_details_material_title
import easyrules.composeapp.generated.resources.game_details_rules_title
import easyrules.composeapp.generated.resources.game_details_tag_list_title
import easyrules.composeapp.generated.resources.game_details_variants_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun GameDetails(
    modifier: Modifier = Modifier,
    title: String,
    goal: String,
    material: String,
    howToPlay: String,
    end: String,
    variants: String?,
    duration: String,
    difficultyLevel: GameDifficultyLevelUiModel,
    gameTagUiModelList: List<GameTagUiModel>,
    minPlayer: Int,
    maxPLayer: Int
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = colorWhite)
            .padding(16.dp)
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = title,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Black,
                fontSize = 32.sp,
                lineHeight = 43.sp,
                letterSpacing = 0.sp,
                color = Color(0xFF6C3BC4),
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        CharacteristicsSection(
            minPlayer = minPlayer,
            maxPlayer = maxPLayer,
            duration = duration,
            gameDifficultyLevelUiModel = difficultyLevel
        )
        Spacer(modifier = Modifier.height(16.dp))
        FoldableSection(title = stringResource(Res.string.game_details_tag_list_title)) {
            TagListSection(gameTagUiModelList = gameTagUiModelList)
        }
        Spacer(modifier = Modifier.height(16.dp))
        FoldableSection(title = stringResource(Res.string.game_details_material_title)) {
            Text(
                text = material,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Left,
                    letterSpacing = 0.sp,
                    color = Color(0xFF1C0652),
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        FoldableSection(title = stringResource(Res.string.game_details_goal_title)) {
            Text(
                text = goal,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Left,
                    letterSpacing = 0.sp,
                    color = Color(0xFF1C0652),
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        FoldableSection(title = stringResource(Res.string.game_details_rules_title)) {
            Text(
                text = howToPlay,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Left,
                    letterSpacing = 0.sp,
                    color = Color(0xFF1C0652),
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        FoldableSection(title = stringResource(Res.string.game_details_end_title)) {
            Text(
                text = end,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Left,
                    letterSpacing = 0.sp,
                    color = Color(0xFF1C0652),
                )
            )
        }
        if (variants?.isNotEmpty() == true) {
            Spacer(modifier = Modifier.height(16.dp))
            FoldableSection(title = stringResource(Res.string.game_details_variants_title)) {
                Text(
                    text = variants,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 19.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Left,
                        letterSpacing = 0.sp,
                        color = Color(0xFF1C0652),
                    )
                )
            }
        }
    }
}