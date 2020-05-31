package prototype

interface Prototype<out T> {
    fun clone(): T
}

open class Car : Prototype<Car> {
    private var wheelNumber = 4

    constructor() {}

    constructor(car: Car) {
        wheelNumber = car.wheelNumber
    }

    override fun clone(): Car {
        return Car(this)
    }
}

class NissanCar : Car, Prototype<Car> {
    private var engineVersion = 1

    constructor() {}

    constructor(nissanCar: NissanCar) : super(nissanCar) {
        engineVersion = nissanCar.engineVersion
    }

    override fun clone(): Car {
        return NissanCar(this)
    }
}

fun main() {
    val nissanCar = NissanCar()
    val secondNissanCar = nissanCar.clone()
    print("$nissanCar - $secondNissanCar")
}