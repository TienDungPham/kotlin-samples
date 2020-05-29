package prototype

interface Prototype {
    fun clone(): Car
}

open class Car : Prototype {
    private var wheelNumber = 4

    constructor() {}

    constructor(car: Car) {
        wheelNumber = car.wheelNumber
    }

    override fun clone(): Car {
        return Car(this)
    }
}

class NissanCar : Car, Prototype {
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