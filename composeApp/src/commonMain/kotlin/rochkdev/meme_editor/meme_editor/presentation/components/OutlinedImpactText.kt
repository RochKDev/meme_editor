package rochkdev.meme_editor.meme_editor.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import rochkdev.meme_editor.meme_editor.presentation.util.rememberFillTextStyle
import rochkdev.meme_editor.meme_editor.presentation.util.rememberStrokeTextStyle

@Composable
fun OutlinedImpactText(
    text: String,
    strokeTextStyle: TextStyle = rememberStrokeTextStyle(),
    fillTextStyle: TextStyle = rememberFillTextStyle(),
    modifier : Modifier = Modifier
){
    Box(
        modifier = modifier
    ){
        Text(
            text = text,
            style = strokeTextStyle
        )
        Text(
            text = text,
            style = fillTextStyle
        )
    }
}