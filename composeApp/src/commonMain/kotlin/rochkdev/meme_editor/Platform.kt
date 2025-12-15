package rochkdev.meme_editor

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform