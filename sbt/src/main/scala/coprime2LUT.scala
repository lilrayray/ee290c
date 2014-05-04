package Work


import Chisel._
import Node._
import scala.math._
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ArrayOps







class coprime2LUT () extends Module {
val io = new Bundle {
  val in = UInt(INPUT, 4)  
  val out = UInt(OUTPUT, 12)
  }

val coprimes = Vec(Array(UInt(1), UInt(2), UInt(4), UInt(8), UInt(16), UInt(32), UInt(64), UInt(128), UInt(256), UInt(512), UInt(1024), UInt(2048)))
io.out := coprimes(io.in)

}




class coprime2LUTtest (c: coprime2LUT) extends Tester (c) {

for (k <- 0 until 12) { 
poke(c.io.in, k)

val out = (pow(2,k)).toInt

step(1)

expect(c.io.out, out)
}


}
