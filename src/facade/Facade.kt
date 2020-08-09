package facade

object ComplexSystem {
    fun complexOperation() {
        // Do some very complex operation here
    }
}

class Facade {
    fun doOperation() {
        ComplexSystem.complexOperation()
    }
}

fun main() {
    val facade = Facade()
    // Client work with abstraction from Facade class instead ComplexSystem
    facade.doOperation()
}