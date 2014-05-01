package Work

import Chisel._
  
object Work {
  def main(args: Array[String]) = {

    // Parse parameters
    //val p = """-params_(.*)_(.*)_(.*)""".r.findFirstMatchIn(args(0))
    //require(p.isDefined, "First argument must be -param_k_l_r where k and l are Int and r is a Double")
    val poo = 16
    val params = (poo).toInt

    val res = chiselMainTest( args.slice(1, args.length), () => Module ( new modN(params) ) ) {
      c => new modNtest(c) }
  } 
}   
