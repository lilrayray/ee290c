package Work


import Chisel._
import Node._
import scala.math._






class powerLUT () extends Module {
val io = new Bundle {
  val fftindex = UInt(INPUT, 6)
  //val power = UInt(INPUT, 3)  
  val power4235 = Vec.fill(4){UInt(OUTPUT, 3)}
  }

val fftpows = Vec(Array(UInt(1), UInt(0), UInt(1), UInt(0), UInt(1), UInt(1), UInt(1), UInt(0), UInt(1), UInt(0), UInt(2), UInt(0), UInt(2), UInt(0), UInt(1), UInt(0), UInt(1), UInt(0), UInt(1), UInt(1), UInt(1), UInt(1), UInt(2), UInt(0), UInt(2), UInt(1), UInt(1), UInt(0), UInt(1), UInt(0), UInt(3), UInt(0), UInt(1), UInt(1), UInt(1), UInt(1), UInt(2), UInt(0), UInt(2), UInt(0), UInt(1), UInt(0), UInt(2), UInt(1), UInt(3), UInt(0), UInt(1), UInt(0), UInt(1), UInt(1), UInt(3), UInt(0), UInt(2), UInt(0), UInt(1), UInt(1), UInt(2), UInt(1), UInt(2), UInt(0), UInt(1), UInt(0), UInt(1), UInt(2), UInt(1), UInt(0), UInt(4), UInt(0), UInt(1), UInt(1), UInt(2), UInt(1), UInt(3), UInt(1), UInt(1), UInt(0), UInt(2), UInt(0), UInt(3), UInt(0), UInt(2), UInt(1), UInt(1), UInt(1), UInt(1), UInt(0), UInt(3), UInt(1), UInt(3), UInt(0), UInt(2), UInt(0), UInt(1), UInt(1), UInt(1), UInt(2), UInt(1), UInt(1), UInt(4), UInt(0), UInt(2), UInt(0), UInt(2), UInt(1), UInt(4), UInt(0), UInt(1), UInt(0), UInt(2), UInt(1), UInt(3), UInt(0), UInt(1), UInt(0), UInt(2), UInt(2), UInt(3), UInt(0), UInt(1), UInt(1), UInt(1), UInt(0), UInt(5), UInt(0), UInt(1), UInt(1), UInt(3), UInt(1), UInt(3), UInt(1), UInt(2), UInt(0), UInt(2), UInt(0), UInt(1), UInt(2), UInt(2), UInt(0), UInt(4), UInt(0), UInt(4), UInt(1), UInt(1), UInt(0), UInt(3), UInt(0), UInt(0), UInt(0), UInt(3), UInt(1), UInt(0), UInt(0), UInt(4), UInt(0), UInt(0), UInt(0), UInt(4), UInt(1), UInt(0), UInt(0), UInt(5), UInt(0), UInt(0), UInt(0), UInt(5), UInt(1), UInt(0), UInt(0)))

val index = io.fftindex*UInt(4)

io.power4235 := Vec(fftpows(index), fftpows(index+UInt(1)), fftpows(index+UInt(2)), fftpows(index+UInt(3)))

}


class powerLUTtest (c: powerLUT) extends Tester (c) {


//poke(c.io.power, 4)
poke(c.io.fftindex, 34)

step(1)

expect(c.io.power4235(0), 2)
expect(c.io.power4235(1), 0)
expect(c.io.power4235(2), 4)
expect(c.io.power4235(3), 0)




}



