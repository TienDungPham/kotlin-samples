package singleton

object Car {
    private lateinit var car: String
    fun getInstance(): String {
        if (car == null) {
            car = "Nissan car"
        }
        return car
    }
}