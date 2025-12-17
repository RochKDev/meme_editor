package rochkdev.meme_editor.meme_editor.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import rochkdev.meme_editor.meme_editor.presentation.MemeText
import rochkdev.meme_editor.meme_editor.presentation.TextBoxInteractionState
import rochkdev.meme_editor.meme_editor.presentation.util.rememberFillTextStyle
import rochkdev.meme_editor.meme_editor.presentation.util.rememberStrokeTextStyle

@Composable
fun MemeTextBox(
    memeText: MemeText,
    textBoxInteractionState: TextBoxInteractionState,
    maxWidth: Dp,
    maxHeight: Dp,
    onClick: () -> Unit,
    onDoubleClick: () -> Unit,
    onTextChange: (String) -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val memeTextFocusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(textBoxInteractionState){
        if (textBoxInteractionState is TextBoxInteractionState.Editing){
            memeTextFocusRequester.requestFocus()
            delay(100)
            keyboardController?.show()
        }
    }

    LaunchedEffect(textBoxInteractionState, memeText.id){
        if (textBoxInteractionState is TextBoxInteractionState.Selected){
            focusManager.clearFocus()
        }
    }

    Box(modifier) {
        Box(
            modifier = Modifier
                .sizeIn(maxWidth = maxWidth, maxHeight = maxHeight)
                .border(
                    width = 2.dp,
                    color = if (textBoxInteractionState is TextBoxInteractionState.Selected ||
                        textBoxInteractionState is TextBoxInteractionState.Editing
                    ) {
                        Color.White
                    } else {
                        Color.Transparent
                    },
                    shape = RoundedCornerShape(4.dp)
                )
                .background(
                    color = if (textBoxInteractionState is TextBoxInteractionState.Editing) {
                        Color.Black.copy(alpha = 0.15f)
                    } else Color.Transparent,
                    shape = RoundedCornerShape(4.dp)
                )
                .combinedClickable(
                    onClick = onClick,
                    onDoubleClick = onDoubleClick
                )
        ) {
            val strokeTextStyle = rememberStrokeTextStyle()
            val fillTextStyle = rememberFillTextStyle()
            val textPadding = 8.dp
            if (textBoxInteractionState is TextBoxInteractionState.Editing) {
                OutlinedImpactTextField(
                    text = memeText.text,
                    onTextChange = onTextChange,
                    strokeTextStyle = strokeTextStyle,
                    fillTextStyle = fillTextStyle,
                    maxWidth = maxWidth - (textPadding * 2),
                    maxHeight = maxHeight - (textPadding * 2),
                    modifier = Modifier
                        .focusRequester(memeTextFocusRequester)
                        .padding(textPadding)
                )
            } else {
                OutlinedImpactText(
                    text = memeText.text,
                    strokeTextStyle = strokeTextStyle,
                    fillTextStyle = fillTextStyle,
                    modifier = Modifier
                        .padding(textPadding)
                )
            }
        }

        if (textBoxInteractionState is TextBoxInteractionState.Selected ||
            textBoxInteractionState is TextBoxInteractionState.Editing
        ) {
            Box(
                modifier = Modifier
                    .offset(x = (-8).dp, y = (-8).dp)
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.7f))
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .clickable {
                        onDeleteClick()
                    }
                    .align(Alignment.TopEnd),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Delete Text Box",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}