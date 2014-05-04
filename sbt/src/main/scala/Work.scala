package Work

import Chisel._
  
object Work {
  def main(args: Array[String]) = {

    // Parse parameters
    //val p = """-params_(.*)_(.*)_(.*)""".r.findFirstMatchIn(args(0))
    //require(p.isDefined, "First argument must be -param_k_l_r where k and l are Int and r is a Double")
    val poo = 1024
    val params = (poo).toInt


    // these two lines are for doing the modN. comment out one or other depening on which you are testing
    //val res = chiselMainTest( args.slice(1, args.length), () => Module ( new modN(params) ) ) {
    //  c => new modNtest(c) }

    //these two lines are for doing the butterfly 
    //val res = chiselMainTest( args.slice(1, args.length), () => Module ( new radix2345 ) ) {
    //  c => new radix2345test(c) }



    //these two are for the twiddle lut want params is the scaling factor!
    //val res = chiselMainTest( args.slice(1, args.length), () => Module ( new twiddleLUT(params) ) ) {
    //  c => new twiddleLUTtest(c) }


    //these two are for lut testing, change name power/r5ic/4/3/qin/qout
    val res = chiselMainTest( args.slice(1, args.length), () => Module ( new GMRCtrl ) ) {
      c => new GMRCtrlTest(c) }



  } 
}   
