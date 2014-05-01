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

}


class modNtest (c: modN) extends Tester (c) {

val address = rnd.nextInt(100)
val dwidth = 16
val N = rnd.nextInt(100)
val sub = address - N
var xx = 0

if (sub > 0){
 xx = sub
} else{
 xx = address
}

val output = xx

poke(c.io.address, address)
poke(c.io.N, N)

step(1)

expect(c.io.output, output)


}
