package io.github.droidkaigi.confsched2020.data.api.response

interface SessionResponse {
    val id: String
    val isServiceSession: Boolean
    val title: String
    val englishTitle: String?
    val speakers: List<String>
    val description: String
    val startsAtWithTZ: String
    val endsAtWithTZ: String
    val roomId: Int
    val categoryItems: List<Int>
    val questionAnswers: List<QuestionAnswerResponse>
    val message: SessionMessageResponse?
    val isPlenumSession: Boolean
    val sessionType: String?
    val forBeginners: Boolean
    val videoUrl: String?
    val slideUrl: String?
    val interpretationTarget: Boolean
}
