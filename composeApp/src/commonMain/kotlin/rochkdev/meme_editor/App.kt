package rochkdev.meme_editor

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import memeeditor.composeapp.generated.resources.Res
import memeeditor.composeapp.generated.resources.compose_multiplatform
import rochkdev.meme_editor.core.theme.MemeCreatorTheme
import rochkdev.meme_editor.meme_gallery.presentation.MemeGalleryScreen

@Composable
@Preview
fun App() {
    MemeCreatorTheme {
        MemeGalleryScreen(
            onMemeTemplateSelected = { memeTemplate ->
                // Handle meme template selection
            }
        )
    }
}