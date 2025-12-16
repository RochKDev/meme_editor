package rochkdev.meme_editor.core.presentation

import memeeditor.composeapp.generated.resources.Res
import memeeditor.composeapp.generated.resources.allDrawableResources
import org.jetbrains.compose.resources.DrawableResource

data class MemeTemplate(
    val id: String,
    val drawable: DrawableResource
)

// A list of all available meme templates loaded from drawable resources
val memeTemplates = Res
    .allDrawableResources
    .filterKeys {
        it.startsWith("meme_template_")
    }
    .map {
        MemeTemplate(
            id = it.key,
            drawable = it.value
        )
    }