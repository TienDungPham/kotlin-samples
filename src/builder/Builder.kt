package builder

class Car {
    var gpsName: String? = null
    var engineName: String? = null
}

interface Builder {
    fun setGPS(gpsName: String)
    fun setEngine(engineName: String)
    fun getProduct(): Car
}

class CarBuilder : Builder {
    private var car: Car = Car()

    override fun setGPS(gpsName: String) {
        car.gpsName = gpsName
    }

    override fun setEngine(engineName: String) {
        car.engineName = engineName
    }

    override fun getProduct(): Car {
        return car
    }
}

class Director(private val builder: Builder) {
    fun buildSportCar(): Car {
        builder.setEngine("V8")
        builder.setGPS("1")
        return builder.getProduct()
    }

    fun buildSUVCar(): Car {
        builder.setEngine("Classic")
        builder.setGPS("2")
        return builder.getProduct()
    }
}

fun main() {
    val builder = CarBuilder()
    val director = Director(builder)
    print("${director.buildSUVCar().gpsName}")
}