package com.example.newkotlin

fun main(){
    //Scope and shadowing
    myFunction(5)

    //classes and Initializer
    var Jane = Person("Jane", "Martin", 31)
    Jane.hobby = "to sing"
    Jane.age = 32
    println("Jane is ${Jane.age} years old")
    Jane.hobby = "Hiking"
    Jane.stateHobby()
    var Alice = Person()
    Alice.hobby = "Listening to music"
    Alice.stateHobby()
   var AliceWeyn = Person(lastName = "Weyn")

}
//Scope and shadowing - a is a parameter
fun myFunction(a:Int){
    //a is a variable
    var a = a
    println("a is $a")
}
//Primary constructor
class Person (firstName: String = "Alice", lastName: String = "Walter") {
    //Members variables - properties
    var age : Int? = null
    var hobby : String = "Watching movies"
    var firstName : String? = null

   //Initializer block
    init {
       this.firstName = firstName
        println("Initialized a new Person object with " +
                "firstName = $firstName and lastName = $lastName")
    }
    //Member secondary constructor
    constructor(firstName: String, lastName: String, age: Int)
            : this(firstName, lastName){
                this.age = age
        println("Initialized a new Person object with " +
                "firstName = $firstName and lastName = $lastName and age $age")
            }

    //Member functions - methods
    fun stateHobby(){
        println("$firstName\'s hobby is $hobby")
    }
}