package Work


import Chisel._
import Node._
import scala.math._




object Complex {
  var use_four_mults = false

  def apply(dwidth: Int = -1) = {
    if(dwidth > 0) new Complex(SInt(width=dwidth), SInt(width=dwidth)) else new Complex(SInt(),SInt())
  }
}
class Complex(val real: SInt, val imag: SInt) extends Bundle {
  override def clone() = new Complex(real.clone, imag.clone).asInstanceOf[this.type]

  def * (r: Complex): Complex =
  {
    val a = real; val b = imag; val c = r.real; val d = r.imag;

    if(Complex.use_four_mults)
    {
      val ac = a*c; val bd = b*d; val ad = a*d; val bc = b*c;
      new Complex(ac - bd, ad + bc)
    }
    else //use three mults
    {
      val ac_p_ad = a * (c + d)
      val ad_p_bd = (a + b) * d
      val bc_m_ac = (b - a) * c

      new Complex(ac_p_ad - ad_p_bd, ac_p_ad + bc_m_ac)
    }
  }


  //making a new multiplication complex * a double
  def * (r: Double): Complex =
  {
    val a = real; val b = imag;
    val temp = SInt((r*math.pow(2,20)).toInt); val bignum = SInt((math.pow(2,20)).toInt);
    new Complex((temp*real)/bignum, (temp*imag)/bignum)

  }
  def + (r: Complex): Complex =
  {
    new Complex(real + r.real, imag + r.imag)
  }
  def - (r: Complex): Complex = 
  {
    new Complex(real - r.real, imag - r.imag)
  }

  def apply(sp: Int, ep: Int) = 
  {
    new Complex(real(sp, ep).toSInt, imag(sp, ep).toSInt)
  }
} // Complex class



//old def of complex, now trying to use Stephen's
//class complex  extends Bundle () {
// val re = SInt(width = 16)
// val im = SInt(width = 16)
//
//}

class radix2345 extends Module {
val io = new Bundle {
  val radix = UInt(INPUT, 4)

  val x0 = new Complex(SInt(width = 16),SInt(width = 16)).asInput
  val x1 = new Complex(SInt(width = 16),SInt(width = 16)).asInput
  val x2 = new Complex(SInt(width = 16),SInt(width = 16)).asInput
  val x3 = new Complex(SInt(width = 16),SInt(width = 16)).asInput
  val x4 = new Complex(SInt(width = 16),SInt(width = 16)).asInput

  val twiddle1 = new Complex(SInt(width = 16),SInt(width = 16)).asInput
  val twiddle2 = new Complex(SInt(width = 16),SInt(width = 16)).asInput
  val twiddle3 = new Complex(SInt(width = 16),SInt(width = 16)).asInput
  val twiddle4 = new Complex(SInt(width = 16),SInt(width = 16)).asInput

  val y0 = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val y1 = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val y2 = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val y3 = new Complex(SInt(width = 16),SInt(width = 16)).asOutput
  val y4 = new Complex(SInt(width = 16),SInt(width = 16)).asOutput

  

}


// initialize intermediate values

val j = new Complex(SInt(0, width=16),SInt(1, width=16))


val c4 = new Complex(SInt(width = 16), SInt(width = 16))




val yy1 = new Complex(SInt(width = 16), SInt(width = 16))
val yy2 = new Complex(SInt(width = 16), SInt(width = 16))
val yy3 = new Complex(SInt(width = 16), SInt(width = 16))

val a12 = new Complex(SInt(width = 16), SInt(width = 16))
val d12 = new Complex(SInt(width = 16), SInt(width = 16))
val c22 = new Complex(SInt(width = 16), SInt(width = 16))
val d42 = new Complex(SInt(width = 16), SInt(width = 16))
val a42 = new Complex(SInt(width = 16), SInt(width = 16))
val d02 = new Complex(SInt(width = 16), SInt(width = 16))
val a32 = new Complex(SInt(width = 16), SInt(width = 16))
val a31 = new Complex(SInt(width = 16), SInt(width = 16))
val a22 = new Complex(SInt(width = 16), SInt(width = 16))
val b51 = new Complex(SInt(width = 16), SInt(width = 16))
val b52 = new Complex(SInt(width = 16), SInt(width = 16))

val yz21 = new Complex(SInt(width = 16), SInt(width = 16))
val yz22 = new Complex(SInt(width = 16), SInt(width = 16))

val zro = new Complex(SInt(0,width = 16), SInt(0,width = 16))



//these are the values that are always the same, independent of radix
  



val p5 = 0.5  
val k0 = cos(4*Pi/5)  
val k10 = -sin(4*Pi/5)    
val k11 = sin(2*Pi/5)+sin(4*Pi/5)  
val k12 = -sin(2*Pi/5)+sin(4*Pi/5) 
val k123 = -sin(2*Pi/3) 

val a0 = io.x0
val a1 = io.x1+a12 
val a2 = io.x2+a22      
val a3 = a31-a32   
val a4 = io.x1-a42
  
val b0 = a0
val b1 = a1
val b2 = a2
val b3 = a3
val b4 = a4
val b5 = b51-b52 
val b6 = a3+a4

val c0 = b0
val c1 = b0- b1*p5
val c2 = b0-c22
val c3 = b3*k11
     


val c5 = b5*k0

//print (c5.getWidth+"\n\n\n\n")

val c6 = b6*k10
val c7 = b1+b2  
  
val d0 = c0+d02
val d1 = c1-d12
val d2 = c2+c5
val d3 = c3+c6
val d4 = c4+d42

val yz0 = d0
val yz1 = d1+j*d4
val yz2 = yz21+j*yz22
val yz3 = yz21-j*yz22
val yz4 = d1-j*d4    
 
val yy4 = yz4
  
 
io.y1 := yy1*io.twiddle1
val yx2 = yy2*io.twiddle2
val yx3 = yy3*io.twiddle3
val yx4 = yy4*io.twiddle4




//when for 2 or otherwise

when (io.radix ===UInt(2)) {

 c22 := io.x1
 
//what it's basically doing are the below operations, with more intermediate steps
//io.y1.re := io.x1.re + io.x2.re
//io.y1.im := io.x1.im + io.x2.im 

//io.y2.re := io.x1.re - io.x2.re
//io.y2.im := io.x1.im - io.x2.im 

} .otherwise {

 c22 := b2*p5
}


// when for 3 or otherwise
when (io.radix === UInt(3)) {
 
 d02 := a1
 d12 := zro
 d42 := zro
 c4 := b4*k123 

} .otherwise {

 d02 := c7
 d12 := c5
 d42 := c6
 c4 := b4*k12 
 
}

//when for 2,3,4,or otherwise
when (io.radix === UInt(2)) {

 a12 := io.x0
 io.y0 := a1
 yy1 := c2

} .elsewhen (io.radix === UInt(3)){

 a12 := io.x2
 io.y0 := d0
 yy1 := yz1


} .elsewhen (io.radix === UInt(4)) {

 a12 := io.x3
 io.y0 := c7
 yy1 := yz3

} .otherwise {

 a12 := io.x4
 io.y0 := yz0
 yy1 := yz1

}


//when for 3,4, or otherwise
when (io.radix === UInt(3)) {

 a42 := io.x2
 yy2 := yz4

} .elsewhen (io.radix === UInt(4)) {

 a42 := io.x3
 yy2 := b5
 

} .otherwise {

 a42 := io.x4
 yy2 := yz2

}


// when for 4 or otherwise
when (io.radix === UInt(4)) {

 a22 := io.x0
 a31 := io.x0
 a32 := io.x2

 b51 := a2
 b52 := a1
 yz21 := a3
 yz22 := a4
 yy3 := yz2

} .otherwise {

 a22 := io.x3
 a31 := io.x2
 a32 := io.x3

 b51 := a1
 b52 := a2
 yz21 := d2
 yz22 := d3
 yy3 := yz3

}




when (io.radix > UInt(2)) {
io.y2 := yx2
} .otherwise {
io.y2 := io.x2
}
when (io.radix > UInt(3)) {
io.y3 := yx3
} .otherwise {
io.y3 := io.x3
}
when (io.radix > UInt(4)) {
io.y4 := yx4
} .otherwise {
io.y4 := io.x4
}







}


class radix2345test (c: radix2345) extends Tester (c) {

val x0_real = rnd.nextInt(100)
val x0_imag = rnd.nextInt(100)
val x1_real = rnd.nextInt(100)
val x1_imag = rnd.nextInt(100)
val x2_real = rnd.nextInt(100)
val x2_imag = rnd.nextInt(100)
val x3_real = rnd.nextInt(100)
val x3_imag = rnd.nextInt(100)
val x4_real = rnd.nextInt(100)
val x4_imag = rnd.nextInt(100)

val radix = 2
val y0_real = ((x0_real + x1_real) & 0xFFFF)
val y0_imag = ((x0_imag + x1_imag) & 0xFFFF)
val y1_real = ((x0_real - x1_real) & 0xFFFF)
val y1_imag = ((x0_imag - x1_imag) & 0xFFFF)
val y2_real = x2_real
val y2_imag = x2_imag

val y3_real = x3_real
val y3_imag = x3_imag
val y4_real = x4_real
val y4_imag = x4_imag



//val radix = 3
//val k = -sin(2*Pi/3)
//val a0_real = x0_real
//val a0_imag = x0_imag  
//val a1_real = x1_real + x2_real
//val a1_imag = x1_imag + x2_imag
//val a2_real = x1_real - x2_real
//val a2_imag = x1_imag - x2_imag
//val b1_real = a0_real - (a1_real/2).toInt
//val b1_imag = a0_imag - (a1_imag/2).toInt
//val b2_real = (k*a2_real).toInt
//val b2_imag = (k*a2_imag).toInt
//val jd2_real = (-1.0*b2_imag).toInt
//val jd2_imag = b2_real
//val y0_real = ((a0_real + a1_real) & 0xFFFF)
//val y0_imag = ((a0_imag + a1_imag) & 0xFFFF)
//val y1_real = ((b1_real + jd2_real) & 0xFFFF)
//val y1_imag = ((b1_imag + jd2_imag) & 0xFFFF)
//val y2_real = ((b1_real - jd2_real) & 0xFFFF)
//val y2_imag = ((b1_imag - jd2_imag) & 0xFFFF)
//val y3_real = x3_real
//val y3_imag = x3_imag
//val y4_real = x4_real
//val y4_imag = x4_imag


//val radix = 5
//val k0 = cos(4*Pi/5)
//val k10 = -sin(4*Pi/5)
//val k11 = sin(2*Pi/5) + sin(4*Pi/5)
//val k12 = -sin(2*Pi/5) + sin(4*Pi/5)

//val b0_real = x0_real
//val b1_real = x1_real + x4_real
//val b2_real = x2_real + x3_real
//val b3_real = x2_real - x3_real
//val b4_real = x1_real - x4_real
//val b5_real = b1_real - b2_real
//val b6_real = b3_real + b4_real
//val b0_imag = x0_imag
//val b1_imag = x1_imag + x4_imag
//val b2_imag = x2_imag + x3_imag
//val b3_imag = x2_imag - x3_imag
//val b4_imag = x1_imag - x4_imag
//val b5_imag = b1_imag - b2_imag
//val b6_imag = b3_imag + b4_imag




//val c0_real = b0_real
//val c1_real = b0_real - (b1_real/2).toInt
//val c2_real = b0_real - (b2_real/2).toInt
//val c3_real = (k11*b3_real).toInt
//val c4_real = (k12*b4_real).toInt
//val c5_real = (k0*b5_real).toInt
//val c6_real = (k10*b6_real).toInt
//val c7_real = b1_real + b2_real
//val c0_imag = b0_imag
//val c1_imag = b0_imag - (b1_imag/2).toInt
//val c2_imag = b0_imag - (b2_imag/2).toInt
//val c3_imag = (k11*b3_imag).toInt
//val c4_imag = (k12*b4_imag).toInt
//val c5_imag = (k0*b5_imag).toInt
//val c6_imag = (k10*b6_imag).toInt
//val c7_imag = b1_imag + b2_imag



//val d0_real = c0_real + c7_real
//val d1_real = c1_real - c5_real
//val d2_real = c2_real + c5_real
//val d3_real = c3_real + c6_real
//val d4_real = c4_real + c6_real

//val d0_imag = c0_imag + c7_imag
//val d1_imag = c1_imag - c5_imag
//val d2_imag = c2_imag + c5_imag
//val d3_imag = c3_imag + c6_imag
//val d4_imag = c4_imag + c6_imag
//
//val jd3_real = (-1.0*d3_imag).toInt
//val jd3_imag = d3_real
//val jd4_real = (-1.0*d4_imag).toInt
//val jd4_imag = d4_real
//
//val y0_real = ((d0_real) & 0xFFFF)
//val y0_imag = ((d0_imag) & 0xFFFF)
//val y1_real = ((d0_real + jd4_real) & 0xFFFF)
//val y1_imag = ((d0_imag + jd4_imag) & 0xFFFF)
//val y2_real = ((d2_real + jd3_real) & 0xFFFF)
//val y2_imag = ((d2_imag + jd3_imag) & 0xFFFF)
//val y3_real = ((d2_real - jd3_real) & 0xFFFF)
//val y3_imag = ((d2_imag - jd3_imag) & 0xFFFF)
//val y4_real = ((d0_real - jd4_real) & 0xFFFF)
//val y4_imag = ((d0_imag - jd4_imag) & 0xFFFF)











val twid1_re  = 1 
val twid1_im = 0
val twid2_re  = 1 
val twid2_im = 0 
val twid3_re  = 1 
val twid3_im = 0 
val twid4_re  = 1 
val twid4_im = 0 
 

poke(c.io.radix, radix)
poke(c.io.twiddle1.real, twid1_re)
poke(c.io.twiddle1.imag, twid1_im)
poke(c.io.twiddle2.real, twid2_re)
poke(c.io.twiddle2.imag, twid2_im)
poke(c.io.twiddle3.real, twid3_re)
poke(c.io.twiddle3.imag, twid3_im)
poke(c.io.twiddle4.real, twid4_re)
poke(c.io.twiddle4.imag, twid4_im)
poke(c.io.x0.real, x0_real)
poke(c.io.x0.imag, x0_imag)
poke(c.io.x1.real, x1_real)
poke(c.io.x1.imag, x1_imag)
poke(c.io.x2.real, x2_real)
poke(c.io.x2.imag, x2_imag)
poke(c.io.x3.real, x3_real)
poke(c.io.x3.imag, x3_imag)
poke(c.io.x4.real, x4_real)
poke(c.io.x4.imag, x4_imag)



step(2)

//expect(c.d1.real, b1_real)
expect(c.io.y0.real, y0_real)
expect(c.io.y0.imag, y0_imag)
expect(c.io.y1.real, y1_real)
expect(c.io.y1.imag, y1_imag)
expect(c.io.y2.real, y2_real)
expect(c.io.y2.imag, y2_imag)
expect(c.io.y3.real, y3_real)
expect(c.io.y3.imag, y3_imag)
expect(c.io.y4.real, y4_real)
expect(c.io.y4.imag, y4_imag)

}
