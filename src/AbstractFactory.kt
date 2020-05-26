// https://refactoring.guru/design-patterns/abstract-factory

interface Engine {
    fun start()
}

class ClassicEngine : Engine {
    override fun start() {
        print("Classic engine start")
    }
}

class EnhanceEngine : Engine {
    override fun start() {
        print("Enhance engine start")
    }
}

interface Wheel {
    fun roll()
}

class ClassicWheel : Wheel {
    override fun roll() {
        print("Classic engine roll")
    }
}

class EnhanceWheel : Wheel {
    override fun roll() {
        print("Enhance engine roll")
    }
}

interface AbstractPartFactory {
    fun createEngine(): Engine
    fun createWheel(): Wheel
}

class ClassicPartFactory : AbstractPartFactory {
    override fun createEngine(): Engine {
        return ClassicEngine()
    }

    override fun createWheel(): Wheel {
        return ClassicWheel()
    }
}

class EnhancePartFactory : AbstractPartFactory {
    override fun createEngine(): Engine {
        return EnhanceEngine()
    }

    override fun createWheel(): Wheel {
        return EnhanceWheel()
    }
}

fun getVariant(): String {
    return "classic"
}

fun main() {
    val requestVariant = getVariant()
    var factory: AbstractPartFactory

    factory = if (requestVariant == "classic") {
        ClassicPartFactory()
    } else {
        EnhancePartFactory()
    }

    factory.createEngine().start()
}


