package rochkdev.meme_editor.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import rochkdev.meme_editor.meme_editor.presentation.MemeEditorViewModel

val appModule = module {
    viewModelOf(::MemeEditorViewModel)
}