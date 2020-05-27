package factory

interface Car {
    fun drive(): Unit
}

class NissanCar : Car {
    override fun drive() {
        print("Nissan engine start")
    }
}

class MiniCooperCar : Car {
    override fun drive() {
        print("Mini Cooper engine start")
    }
}

abstract class Factory {
    abstract fun create(carType: String): Car
}

class CarFactory : Factory() {
    override fun create(carType: String): Car {
        return if (carType == "nissan") {
            NissanCar()
        } else {
            MiniCooperCar()
        }
    }
}

fun main() {
    val carFactory: CarFactory = CarFactory()
    carFactory.create("nissan").drive()
}
