package Work


import Chisel._
import Node._
import scala.math._






class r5icLUT () extends Module {
val io = new Bundle {
  val ina = UInt(INPUT, 11)
  val inb = UInt(INPUT, 3)  
  val r5IC = UInt(OUTPUT, 3)
  }


val constants = Vec(Array(UInt(0), UInt(0), UInt(1), UInt(0), UInt(2), UInt(0), UInt(3), UInt(0), UInt(4), UInt(0), UInt(0), UInt(1), UInt(1), UInt(1), UInt(2), UInt(1), UInt(3), UInt(1), UInt(4), UInt(1), UInt(0), UInt(2), UInt(1), UInt(2), UInt(2), UInt(2), UInt(3), UInt(2), UInt(4), UInt(2), UInt(0), UInt(3), UInt(1), UInt(3), UInt(2), UInt(3), UInt(3), UInt(3), UInt(4), UInt(3), UInt(0), UInt(4), UInt(1), UInt(4), UInt(2), UInt(4), UInt(3), UInt(4), UInt(4), UInt(4)))

val index = io.ina*UInt(2)

//depending on b input choose a diff column in the row

io.r5IC := constants(index+io.inb)

//stuff here


}


class r5icLUTtest (c: r5icLUT) extends Tester (c) {


poke(c.io.ina, 20)
poke(c.io.inb, 0)

step(1)

expect(c.io.r5IC, 0)



}
