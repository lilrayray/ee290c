package Work


import Chisel._
import Node._
import scala.math._
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ArrayOps







class coprime3LUT () extends Module {
val io = new Bundle {
  val in = UInt(INPUT, 4)  
  val out = UInt(OUTPUT, 8)
  }

val coprimes = Vec(Array(UInt(1), UInt(3), UInt(9), UInt(27), UInt(81), UInt(243)))

io.out := coprimes(io.in)

}




class coprime3LUTtest (c: coprime3LUT) extends Tester (c) {

for (k <- 0 until 6) { 
poke(c.io.in, k)

val out = (pow(3,k)).toInt

step(1)

expect(c.io.out, out)
}


}
