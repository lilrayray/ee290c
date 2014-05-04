package Work


import Chisel._
import Node._
import scala.math._






class qinLUT () extends Module {
val io = new Bundle {
  val ina = UInt(INPUT, 6)
  val inb = UInt(INPUT, 3)  
  val qin = UInt(OUTPUT, 9)
  }


val qin_vec = Vec(Array(UInt(1), UInt(0), UInt(5), UInt(0), UInt(3), UInt(0), UInt(5), UInt(0), UInt(1), UInt(1), UInt(7), UInt(0), UInt(21), UInt(0), UInt(1), UInt(0), UInt(1), UInt(1), UInt(7), UInt(0), UInt(3), UInt(7), UInt(21), UInt(0), UInt(5), UInt(0), UInt(1), UInt(1), UInt(7), UInt(0), UInt(1), UInt(2), UInt(3), UInt(0), UInt(3), UInt(7), UInt(85), UInt(0), UInt(13), UInt(0), UInt(17), UInt(1), UInt(1), UInt(16), UInt(7), UInt(0), UInt(5), UInt(2), UInt(7), UInt(0), UInt(11), UInt(7), UInt(85), UInt(0), UInt(13), UInt(0), UInt(3), UInt(5), UInt(17), UInt(1), UInt(1), UInt(0), UInt(1), UInt(16), UInt(71), UInt(0), UInt(13), UInt(2), UInt(15), UInt(0), UInt(341), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0)))


val index = io.ina*UInt(2)

when (io.inb===UInt(0){

io.qin := qin_vec(index)

} .otherwise{

io.qin := qin_vec(index+UInt(1))

}


}




class qinLUTtest (c: qinLUT) extends Tester (c) {


poke(c.io.ina, 29)
poke(c.io.inb, 0)

step(1)

expect(c.io.qin, 17)



}

