package kompote.ui.taskCreator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kompote.domain.task.TaskDraft

class TaskDraftState {
    var draft by mutableStateOf(
        TaskDraft("","","")
    )
        private set

    fun updateName(name: String) {
        draft = draft.copy(name = name)
    }

    fun updateTime(time: String) {
        if(time.isEmpty() || (time.length <= 4 && time.all { it.isDigit() }))
            draft = draft.copy(time = time)
    }

    fun updateDuration(duration: String) {
        if(duration.isEmpty() || duration.all { it.isDigit() })
            draft = draft.copy(duration = duration)
    }

    fun isSubmittable() =
        draft.isSubmittable()

    fun clear() {
        draft = TaskDraft("", "", "")
    }
}