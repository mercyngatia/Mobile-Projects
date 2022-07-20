package com.example.newkotlin

import java.time.temporal.TemporalAmount

//Interfaces
interface Drivable{
    val maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("The drivable is braking")
    }
}



//Inheritance
//Class that inherits the features of another
//Class is called the sub class or child class or derived class
//Class whose features are inherited is called the super class or parent class or base class

////Super Class/ Parent Class/ Base Class
//open class Vehicle{
//    //properties, methods
//}


//Sub Class/ Child Class/ Derived Class of Vehicles
//Super Class/ Parent Class/ Base Class of vehicles
open class Cars(override val maxSpeed: Double,
                val name: String, var brand: String): Drivable{
    open var range: Double = 0.0
    fun extendRange(amount: Double){
        if (amount > 0)
            range += amount
    }

    override fun drive(): String {
        return "Driving the interface drive"
    }
    open fun drive(distance: Double){
        println("Drove for $distance KM")
    }
}

//Sub Class/ Child Class or Derived class of cars
class ElectricCar(maxSpeed: Double, name: String,
                  brand: String, batteryLife: Double):
        Cars(maxSpeed, name, brand){

    var chargerType = "pin1"
    override var range = batteryLife * 5

    override fun drive(distance: Double){
        println("Drove for $distance KM on electricity")
    }
    override fun drive(): String{
        return "Drove for $range KM on electricity"
    }

    override fun brake() {
        super.brake()
        println("brake inside of electric car")
    }

}

//Any class inherits from Any class
fun main(){
    var benzA4 = Cars(250.0,"A4", "Benz")
    var teslaS = ElectricCar(260.0,"S-Model", "Tesla", 87.0)

    teslaS.chargerType = "Pin2"
    teslaS.extendRange(250.0)

  //  teslaS.drive()
    teslaS.brake()
    benzA4.brake()

//    //Polymorphism
//    benzA4.drive(250.0)
//    teslaS.drive(250.0)
}


