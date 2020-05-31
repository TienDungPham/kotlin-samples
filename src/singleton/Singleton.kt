package singleton

object Car {
    private lateinit var car: String
    fun getInstance(): String {
        synchronized(this) {
            if (car == null) {
                car = "Nissan car"
            }
            return car
        }
    }
}