package proxy

interface Video {
    fun getVideo(): String
}

class YoutubeVideo(private val url: String) : Video {
    override fun getVideo(): String {
        return url
    }
}

class VideoCacheProxy : Video {
    private lateinit var cachedVideo: Video
    override fun getVideo(): String {
        return if (::cachedVideo.isInitialized) {
            cachedVideo.getVideo()
        } else {
            cachedVideo = YoutubeVideo("")
            cachedVideo.getVideo()
        }
    }
}