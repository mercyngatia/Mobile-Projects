package com.example.newkotlin

fun main(){
    //Nullable
    //Nullable - Elvis operator
    var  nullableGirl : String? = "Ann"
    var len3 = nullableGirl?.length

    nullableGirl?.let { println(it.length) }

    val namey = nullableGirl ?: "Guest"
    println("Name is $namey")
    println(nullableGirl!!.toLowerCase())

    //operator in a chain
   // val wifesAges: String? = user?.wife?.age ?: 0

   var name : String = "Ann"
    //name = null - Compilation ERROR
    var  nullableName : String? = "Ann"
   // nullableName = null

    var len = name.length

    var len2 = nullableName?.length
    nullableName?.let { println(it.length) }


   // println(nullableName?.toLowerCase())

   /* if (nullableName != null){
        var len2 = nullableName.length
    }else{
        null
    }*/


    //Functions -  adds functionality to the program
    //We are using Arguments
    var  averg = averg(5.21, 12.0)
    print("result is $averg")

    var  results = addUp(5, 3)
    print("result is $results")
}
fun averg(x: Double, y: Double): Double{
    return (x+y)/2
}

//functions
//Methods - function within a class
//Parameter(input)
fun addUp(a: Int, b: Int) : Int{
    //output
    return a + b
}
fun myFunction(){
    print("Call from myFunction")
}
