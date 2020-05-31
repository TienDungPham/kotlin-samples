package decorator

interface Car {
    fun getPrice(): Int
}

class NissanCar : Car {
    private var nissanCarPrice = 1500
    override fun getPrice(): Int {
        return nissanCarPrice
    }
}

open class CarDecorator constructor(val car: Car) : Car {
    override fun getPrice(): Int {
        return car.getPrice()
    }
}

class AutoPilotDecorator constructor(concreteCar: Car) : CarDecorator(concreteCar) {
    override fun getPrice(): Int {
        var basePrice = car.getPrice()
        basePrice += 100
        return basePrice
    }
}

fun main() {
    var nissanCar: Car = NissanCar()
    print("${nissanCar.getPrice()}")
    nissanCar = AutoPilotDecorator(nissanCar)
    print("${nissanCar.getPrice()}")
}