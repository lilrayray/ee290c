package Work {


import Chisel._
import Node._
import scala.math._
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ArrayOps







class coprime5LUT () extends Module {
val io = new Bundle {
  val in = UInt(INPUT, 3)  
  val out = UInt(OUTPUT, 5)
  }

val coprimes = Vec(Array(UInt(1), UInt(5), UInt(25)))

io.out := coprimes(io.in)

}




class coprime5LUTtest (c: coprime5LUT) extends Tester (c) {

for (k <- 0 until 3) { 
poke(c.io.in, k)

val out = (pow(5,k)).toInt

step(1)

expect(c.io.out, out)
}


}

}
