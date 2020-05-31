package composite

interface Price {
    fun getPrice(): Double
}

class Product constructor(private var productPrice: Double) : Price {
    override fun getPrice(): Double {
        return productPrice
    }
}

class Box : Price {
    private var children = mutableListOf<Price>()

    fun addChild(price: Price) {
        children.add(price)
    }

    override fun getPrice(): Double {
        var result: Double = 0.0
        for (child in children) {
            result += child.getPrice()
        }
        return result
    }
}

fun main() {
    val box: Box = Box()
    box.addChild(Product(1.5))
    val box2: Box = Box()
    box2.addChild(Product(2.5))
    box.addChild(box2)
    box.addChild(Product(3.5))
    print("${box.getPrice()}")
}