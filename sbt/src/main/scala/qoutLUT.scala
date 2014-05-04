package Work


import Chisel._
import Node._
import scala.math._






class qoutLUT () extends Module {
val io = new Bundle {
  val ina = UInt(INPUT, 6)
  val inb = UInt(INPUT, 3)  
  val qout = UInt(OUTPUT, 9)
  }


val qout_vec = Vec(Array(UInt(0), UInt(2), UInt(0), UInt(1), UInt(0), UInt(2), UInt(0), UInt(2), UInt(2), UInt(2), UInt(0), UInt(1), UInt(0), UInt(1), UInt(0), UInt(20), UInt(1), UInt(1), UInt(0), UInt(5), UInt(4), UInt(2), UInt(0), UInt(2), UInt(0), UInt(10), UInt(3), UInt(2), UInt(0), UInt(7), UInt(2), UInt(2), UInt(0), UInt(20), UInt(2), UInt(1), UInt(0), UInt(1), UInt(0), UInt(5), UInt(4), UInt(1), UInt(3), UInt(20), UInt(0), UInt(8), UInt(1), UInt(1), UInt(0), UInt(10), UInt(1), UInt(5), UInt(0), UInt(2), UInt(0), UInt(16), UInt(9), UInt(2), UInt(2), UInt(2), UInt(0), UInt(182), UInt(4), UInt(10), UInt(0), UInt(4), UInt(13), UInt(2), UInt(0), UInt(5), UInt(0), UInt(1), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0), UInt(0)))


val index = io.ina*UInt(2)

when (io.inb===UInt(0)){

io.qout := qout_vec(index)

} .otherwise{

io.qout := qout_vec(index+UInt(1))

}


}




class qoutLUTtest (c: qoutLUT) extends Tester (c) {


poke(c.io.ina, 29)
poke(c.io.inb, 0)

step(1)

expect(c.io.qout, 2)



}
