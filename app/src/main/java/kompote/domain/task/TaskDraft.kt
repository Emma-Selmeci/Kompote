package kompote.domain.task

data class TaskDraft(
    val name: String,
    val time: String,
    val duration: String
) {
    fun isSubmittable() =
                name.isNotBlank()
                && time.length in 3..4
                && duration.isNotBlank()
}