package Work


import Chisel._
import Node._
import scala.math._


class modN (dwidth: Int) extends Module {
val io = new Bundle {
  val address = SInt(INPUT, width = dwidth)
  val N = SInt(INPUT, width = dwidth)
  val output = SInt(OUTPUT, width = dwidth)
}

  val sub = io.address - io.N
  val topbit = dwidth-1

  when (sub(topbit) === UInt(0)) {
       io.output := sub
  } .otherwise {
       io.output := io.address
  }

} //end of modN module


class modNwrap () extends Module {

val io = new Bundle {
  val n1 = UInt(INPUT, 4)
  val n2 = UInt(INPUT, 4)
  val maxradix = UInt(INPUT, 4)
  val bankIa = UInt(OUTPUT, 4)
  
}



val sumn1n2 = UInt(width=4)

sumn1n2 := io.n1+io.n2

val MBA = Module(new modN(4))

MBA.io.address := sumn1n2
MBA.io.N := io.maxradix
io.bankIa := MBA.io.output






} //end of modNwrapmodule


class modNwraptest (c: modNwrap) extends Tester (c) {


poke(c.io.n1, 2)
poke(c.io.n2, 3)
poke(c.io.maxradix, 6)

step(1)

expect(c.io.bankIa, 5)


}
