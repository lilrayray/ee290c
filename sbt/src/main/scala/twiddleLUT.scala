package Work


import Chisel._
import Node._
import scala.math._






class twiddleLUT (tscale: Int) extends Module {
val io = new Bundle {
  val in4 = UInt(INPUT, 10)
  val in5 = UInt(INPUT, 10)
  val in3 = UInt(INPUT, 10)
  val t4_1out = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val t4_2out = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val t4_3out = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val t3_1out = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val t3_2out = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val t5_1out = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val t5_2out = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val t5_3out = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val t5_4out = new Complex(SInt(width = 16),SInt(width = 16)).asOutput

}


val max2power = 2048
val max3power = 243
val max5power = 25

val t4length = max2power/4
val t3length = max3power/3
val t5length = max5power/5



val one = new Complex(SInt(1,width = 16),SInt(0,width = 16))
val negone = new Complex(SInt(0,width = 16),SInt(-1,width = 16))  

val lutarray41 = new Array [Complex] (t4length)  
val lutarray42 = new Array [Complex] (t4length)  
val lutarray43 = new Array [Complex] (t4length)  

val lutarray51 = new Array [Complex] (t5length)  
val lutarray52 = new Array [Complex] (t5length)  
val lutarray53 = new Array [Complex] (t5length)  
val lutarray54 = new Array [Complex] (t5length)  

val lutarray31 = new Array [Complex] (t3length)  
val lutarray32 = new Array [Complex] (t3length)  


for (k <- 0 until t4length) {  

  val exp = k*2*Pi/max2power
  val coe1 = tscale*cos(exp)
  val soe1 = tscale*sin(exp)
  val coe2 = tscale*cos(2*exp)
  val soe2 = tscale*sin(2*exp)
  val coe3 = tscale*cos(3*exp)
  val soe3 = tscale*sin(3*exp)

  
 
  val t41r = one*coe1
  val t41i = negone*soe1
  val t42r = one*coe2
  val t42i = negone*soe2
  val t43r = one*coe3
  val t43i = negone*soe3

  

  lutarray41(k) = t41r + t41i
  lutarray42(k) = t42r + t42i
  lutarray43(k) = t43r + t43i


}

val twiddle4_1 = Vec( (0 until t4length).map(x => lutarray41(x)))  
val twiddle4_2 = Vec( (0 until t4length).map(x => lutarray42(x)))  
val twiddle4_3 = Vec( (0 until t4length).map(x => lutarray43(x)))  

for (k <- 0 until t3length) {

  val exp = k*2*Pi/max3power
  val coe1 = tscale*cos(exp)
  val soe1 = tscale*sin(exp)
  val coe2 = tscale*cos(2*exp)
  val soe2 = tscale*sin(2*exp)


  val t31r = one*coe1
  val t31i = negone*soe1
  val t32r = one*coe2
  val t32i = negone*soe2



  lutarray31(k) = t31r + t31i
  lutarray32(k) = t32r + t32i


}


val twiddle3_1 = Vec( (0 until t3length).map(x => lutarray31(x)))  
val twiddle3_2 = Vec( (0 until t3length).map(x => lutarray32(x)))  


for (k <- 0 until t5length) {   

  val exp = k*2*Pi/max5power
  val coe1 = tscale*cos(exp)
  val soe1 = tscale*sin(exp)
  val coe2 = tscale*cos(2*exp)
  val soe2 = tscale*sin(2*exp)
  val coe3 = tscale*cos(3*exp)
  val soe3 = tscale*sin(3*exp)  
  val coe4 = tscale*cos(4*exp)
  val soe4 = tscale*sin(4*exp)


  val t51r = one*coe1
  val t51i = negone*soe1
  val t52r = one*coe2
  val t52i = negone*soe2
  val t53r = one*coe3
  val t53i = negone*soe3
  val t54r = one*coe4
  val t54i = negone*soe4



  lutarray51(k) = t51r + t51i
  lutarray52(k) = t52r + t52i
  lutarray53(k) = t53r + t53i
  lutarray54(k) = t54r + t54i


}

val twiddle5_1 = Vec( (0 until t5length).map(x => lutarray51(x)))  
val twiddle5_2 = Vec( (0 until t5length).map(x => lutarray52(x)))  
val twiddle5_3 = Vec( (0 until t5length).map(x => lutarray53(x)))  
val twiddle5_4 = Vec( (0 until t5length).map(x => lutarray54(x)))  



io.t4_1out := twiddle4_1(io.in4)
io.t4_2out := twiddle4_2(io.in4)
io.t4_3out := twiddle4_3(io.in4)
io.t3_1out := twiddle3_1(io.in3)
io.t3_2out := twiddle3_2(io.in3)
io.t5_1out := twiddle5_1(io.in5)
io.t5_2out := twiddle5_2(io.in5)
io.t5_3out := twiddle5_3(io.in5)
io.t5_4out := twiddle5_4(io.in5)




}







class twiddleLUTtest (c: twiddleLUT) extends Tester (c) {


poke(c.io.in4, 2)

poke(c.io.in5, 2)

poke(c.io.in3, 2)

//poke(c.io.x4.imag, x4_imag)



step(1)

//expect(c.d1.real, b1_real)
expect(c.io.t4_1out.real, 1)
expect(c.io.t4_1out.imag, 0)
expect(c.io.t3_1out.real, 1)
expect(c.io.t3_1out.imag, 0)
expect(c.io.t5_1out.real, 1)
expect(c.io.t5_1out.imag, 0)



}

