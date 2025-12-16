package rochkdev.meme_editor.meme_editor.presentation

import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class MemeEditorViewModel : ViewModel() {
    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(MemeEditorState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MemeEditorState()
        )


    fun onAction(action: MemeEditorAction) {
        when (action) {
            is MemeEditorAction.OngoBack -> {
                // Handle back navigation
            }
            is MemeEditorAction.OnSaveMemeClick -> {
                // Handle meme saving
            }
            is MemeEditorAction.OnAddTextClick -> {
                // Handle adding new text
            }
            is MemeEditorAction.OnSelectMemeText -> {
                // Handle selecting meme text
            }
            is MemeEditorAction.OnEditMemeText -> {
                // Handle editing meme text
            }
            is MemeEditorAction.OnMemeTextChange -> {
                // Handle meme text change
            }
            is MemeEditorAction.OnDeleteMemeTextClick -> {
                // Handle deleting meme text
            }
            is MemeEditorAction.OnMemeTexTransformChange -> {
                // Handle meme text transformation changes
            }
            is MemeEditorAction.OnContainerSizeChange -> updateContainerSize(action.size)
            is MemeEditorAction.OnTapOutsideSelectedText -> {
                // Handle tap outside selected text
            }
            is MemeEditorAction.OnConfirmLeaveWithoutSaving -> {
                // Handle confirming leave without saving
            }
            is MemeEditorAction.OnDismissLeaveWithoutSaving -> {
                // Handle dismissing leave without saving
            }
        }
    }

    private fun updateContainerSize(size: IntSize) {
        _state.update {
            it.copy(templateSize = size)
        }
    }
}