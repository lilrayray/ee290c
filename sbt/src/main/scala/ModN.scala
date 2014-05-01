package Work


import Chisel._
import Node._
import scala.math._


case class modNParams(dwidth : Int) {

  // Your code goes here.

  // Set number of total iterations
  //val iterations = k
  // set number of stages
  //val stages = ceil(k*R)

  // val itspersage = iterations/stages

}



class modN (implicit params : modNParams) extends Module {
val io = new Bundle {
  val address = SInt(INPUT, width = params.dwidth)
  val N = SInt(INPUT, width = params.dwidth)
  val output = SInt(OUTPUT, width = params.dwidth)
}


//stuff
//val params.dwidth = UInt(16)
val sub = io.address - io.N
val topbit = params.dwidth-UInt(1)
//val msb = sub(topbit).toBool


when (sub(topbit) === UInt(0)) {

io.output := io.address

} .otherwise {

io.ouput := sub

}




}


class modNtest (c: modN) extends Tester (c) {

val address = rnd.nextInt(100)
val dwidth = 16
val N = rnd.nextInt(100)


val sub = address - N
if (sub > 0){
 val output = sub;
} else{
 val output = address;
}

poke(c.io.address, address)
poke(c.io.N, N)
//poke(c.io.dwidth, dwidth)



step(1)

//expect(c.d1.real, b1_real)
expect(c.io.output, output)






}
