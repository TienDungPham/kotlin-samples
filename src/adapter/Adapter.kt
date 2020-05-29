package adapter

interface IPhone {
    fun useLightning()
}

interface Android {
    fun useMicroUSB()
}

class IPhone7 : IPhone {
    override fun useLightning() {
    }
}

class Pixel3 : Android {
    override fun useMicroUSB() {
    }
}

class LightningToMicroUSBAdapter(private val iPhone7: IPhone7) : Android {
    override fun useMicroUSB() {
        iPhone7.useLightning()
    }
}