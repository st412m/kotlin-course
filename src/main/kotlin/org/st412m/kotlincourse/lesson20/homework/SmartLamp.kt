package org.st412m.kotlincourse.lesson20.homework

 abstract class SmartLamp : Powerable, AutomaticShutdown, Timable, LightEmitting, Programmable {
     override fun powerOn() {
         TODO("Not yet implemented")
     }

     override fun powerOff() {
         TODO("Not yet implemented")
     }

     override val sensorType: String
         get() = TODO("Not yet implemented")
     override val maxSensoredValue: Int
         get() = TODO("Not yet implemented")

     override fun startMonitoring() {
         TODO("Not yet implemented")
     }

     override fun setTimer(time: Int) {
         TODO("Not yet implemented")
     }

     override fun emitLight() {
         TODO("Not yet implemented")
     }

     override fun completeLiteEmission() {
         TODO("Not yet implemented")
     }

     override fun programAction(action: String) {
         TODO("Not yet implemented")
     }

     override fun execute() {
         TODO("Not yet implemented")
     }
 }