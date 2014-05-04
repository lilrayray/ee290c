package Work


import Chisel._
import Node._
import scala.math._






class powerLUT () extends Module {
val io = new Bundle {
  val fftsize = UInt(INPUT, 6)
  val power = UInt(INPUT, 3)  
  val power4235 = UInt(OUTPUT, 3)
  }

val fftpows = Vec(Array(UInt(1), UInt(0), UInt(1), UInt(0), UInt(1), UInt(1), UInt(1), UInt(0), UInt(1), UInt(0), UInt(2), UInt(0), UInt(2), UInt(0), UInt(1), UInt(0), UInt(1), UInt(0), UInt(1), UInt(1), UInt(1), UInt(1), UInt(2), UInt(0), UInt(2), UInt(1), UInt(1), UInt(0), UInt(1), UInt(0), UInt(3), UInt(0), UInt(1), UInt(1), UInt(1), UInt(1), UInt(2), UInt(0), UInt(2), UInt(0), UInt(1), UInt(0), UInt(2), UInt(1), UInt(3), UInt(0), UInt(1), UInt(0), UInt(1), UInt(1), UInt(3), UInt(0), UInt(2), UInt(0), UInt(1), UInt(1), UInt(2), UInt(1), UInt(2), UInt(0), UInt(1), UInt(0), UInt(1), UInt(2), UInt(1), UInt(0), UInt(4), UInt(0), UInt(1), UInt(1), UInt(2), UInt(1), UInt(3), UInt(1), UInt(1), UInt(0), UInt(2), UInt(0), UInt(3), UInt(0), UInt(2), UInt(1), UInt(1), UInt(1), UInt(1), UInt(0), UInt(3), UInt(1), UInt(3), UInt(0), UInt(2), UInt(0), UInt(1), UInt(1), UInt(1), UInt(2), UInt(1), UInt(1), UInt(4), UInt(0), UInt(2), UInt(0), UInt(2), UInt(1), UInt(4), UInt(0), UInt(1), UInt(0), UInt(2), UInt(1), UInt(3), UInt(0), UInt(1), UInt(0), UInt(2), UInt(2), UInt(3), UInt(0), UInt(1), UInt(1), UInt(1), UInt(0), UInt(5), UInt(0), UInt(1), UInt(1), UInt(3), UInt(1), UInt(3), UInt(1), UInt(2), UInt(0), UInt(2), UInt(0), UInt(1), UInt(2), UInt(2), UInt(0), UInt(4), UInt(0), UInt(4), UInt(1), UInt(1), UInt(0), UInt(3), UInt(0), UInt(0), UInt(0), UInt(3), UInt(1), UInt(0), UInt(0), UInt(4), UInt(0), UInt(0), UInt(0), UInt(4), UInt(1), UInt(0), UInt(0), UInt(5), UInt(0), UInt(0), UInt(0), UInt(5), UInt(1), UInt(0), UInt(0)))

val index = io.fftsize*UInt(4)

//depending on power input choose a diff number in the unit
when (io.power === UInt(4)) {

io.power4235 := fftpows(index)

}.elsewhen (io.power===UInt(2)){

io.power4235 := fftpows(index+UInt(1))

}.elsewhen (io.power===UInt(3)){

io.power4235 := fftpows(index+UInt(2))

}.otherwise {

io.power4235 := fftpows(index+UInt(3))

}

//stuff here


}


class powerLUTtest (c: powerLUT) extends Tester (c) {


poke(c.io.power, 4)
poke(c.io.fftsize, 10)

step(1)

expect(c.io.power4235, 1)



}



