package Work

import Chisel._
import Node._

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
