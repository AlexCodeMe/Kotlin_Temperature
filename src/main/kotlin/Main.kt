class Temperature(var temperature: Double, val scale: Scale) {

    enum class Scale {
        FAHRENHEIT, CELSIUS, KELVIN
    }

    fun setTemp(value: Double) {
        temperature = value
    }

    fun getTempInF(): Double {
        return when (scale) {
            Scale.FAHRENHEIT -> temperature
            Scale.CELSIUS -> (temperature * 9 / 5) + 32
            Scale.KELVIN -> (temperature - 273.15) * 9 / 5 + 32
        }
    }

    fun getTempInC(): Double {
        return when (scale) {
            Scale.FAHRENHEIT -> (temperature - 32) * 5 / 9
            Scale.CELSIUS -> temperature
            Scale.KELVIN -> temperature - 273.15
        }
    }

    fun getTempInK(): Double {
        return when (scale) {
            Scale.FAHRENHEIT -> (temperature - 32) * 5 / 9 + 273.15
            Scale.CELSIUS -> temperature + 273.15
            Scale.KELVIN -> temperature
        }
    }
}

fun main() {
    // Example usage:
    val temperature = Temperature(32.0, Temperature.Scale.FAHRENHEIT)
    println("Temperature in Fahrenheit: ${temperature.getTempInF()}")
    println("Temperature in Celsius: ${temperature.getTempInC()}")
    println("Temperature in Kelvin: ${temperature.getTempInK()}")

    // Updating temperature value
    temperature.setTemp(100.0)
    println("Updated Temperature in Fahrenheit: ${temperature.getTempInF()}")
    println("Updated Temperature in Celsius: ${temperature.getTempInC()}")
    println("Updated Temperature in Kelvin: ${temperature.getTempInK()}")
}
