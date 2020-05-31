package bridge

class Remote(private val device: Device) {
    fun volumeUp() {
        device.volumeUp()
    }

    fun volumeDown() {
        device.volumeDown()
    }
}

interface Device {
    fun volumeUp()
    fun volumeDown()
}

class Radio : Device {
    override fun volumeUp() {
        print("Radio volume up")
    }

    override fun volumeDown() {
        print("Radio volume down")
    }
}

class TV : Device {
    override fun volumeUp() {
        print("TV volume up")
    }

    override fun volumeDown() {
        print("TV volume down")
    }
}

fun main() {
    val tv = TV()
    val remote = Remote(tv)
    remote.volumeDown()
}