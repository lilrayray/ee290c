package Work


import Chisel._
import Node._
import scala.math._




class membanks () extends Module {
val io = new Bundle {
  val bank0 = UInt(INPUT, 9)
  val bank1 = UInt(INPUT, 9)
  val bank2 = UInt(INPUT, 9)
  val bank3 = UInt(INPUT, 9)
  val bank4 = UInt(INPUT, 9)
  val phase = UInt(INPUT, 3)
  val addr0 = UInt(INPUT, 9)
  val addr1 = UInt(INPUT, 9)
  val addr2 = UInt(INPUT, 9)
  val addr3 = UInt(INPUT, 9)
  val addr4 = UInt(INPUT, 9)
  val addrIO = UInt(INPUT, 9)
  val bankIO = UInt(INPUT, 9)
  val Din = UInt(INPUT, 9)
  val x0 = UInt (OUTPUT, 9)
  val x1 = UInt (OUTPUT, 9) 
  val x2 = UInt (OUTPUT, 9)  
  val x3 = UInt (OUTPUT, 9)
  val x4 = UInt (OUTPUT, 9)
  val addrBank0a = UInt(OUTPUT, 9)
  val addrBank1a = UInt(OUTPUT, 9)
  val addrBank2a = UInt(OUTPUT, 9)
  val addrBank3a = UInt(OUTPUT, 9)
  val addrBank4a = UInt(OUTPUT, 9)
  val addrBank0b = UInt(OUTPUT, 9)
  val addrBank1b = UInt(OUTPUT, 9)
  val addrBank2b = UInt(OUTPUT, 9)
  val addrBank3b = UInt(OUTPUT, 9)
  val addrBank4b = UInt(OUTPUT, 9)

  }





  val y0 = UInt(44)
  val y1 = UInt(65)
  val y2 = UInt(12)
  val y3 = UInt(9)
  val y4 = UInt(9)
  val x0a = UInt(width=9)
  val x1a = UInt(width=9)
  val x2a = UInt(width=9)
  val x3a = UInt(width=9)
  val x4a = UInt(width=9)
  val x0b = UInt(width=9)
  val x1b = UInt(width=9)
  val x2b = UInt(width=9)
  val x3b = UInt(width=9)
  val x4b = UInt(width=9)
  val y0a = UInt(width = 9)
  val y1a = UInt(width = 9)
  val y2a = UInt(width = 9)
  val y3a = UInt(width = 9)
  val y4a = UInt(width = 9)
  val y0b = UInt(width = 9)
  val y1b = UInt(width = 9)
  val y2b = UInt(width = 9)
  val y3b = UInt(width = 9)
  val y4b = UInt(width = 9)


io.addrBank0a := UInt(5)
io.addrBank1a := UInt(5)
io.addrBank2a := UInt(5)
io.addrBank3a := UInt(5)
io.addrBank4a := UInt(5)
io.addrBank0b := UInt(5)
io.addrBank1b := UInt(5)
io.addrBank2b := UInt(5)
io.addrBank3b := UInt(5)
io.addrBank4b := UInt(5)

io.x0 := UInt(5)
io.x1 := UInt(5)
io.x2 := UInt(5)
io.x3 := UInt(5)
io.x4 := UInt(5)





when (io.phase === UInt(1)){

 when (io.bank0 === UInt(0)) {
     io.addrBank0a := io.addr0
 } .elsewhen (io.bank1 === UInt(0)) {
     io.addrBank0a := io.addr1
 } .elsewhen (io.bank2 === UInt(0)) {
     io.addrBank0a := io.addr2
 } .elsewhen (io.bank3 === UInt(0)) {
     io.addrBank0a := io.addr3
 } .elsewhen (io.bank4 === UInt(0)) {
     io.addrBank0a := io.addr4
 } .otherwise {
     io.addrBank0a := io.addrIO
 }

 when (io.bank0 === UInt(1)) {
     io.addrBank1a := io.addr0
 } .elsewhen (io.bank1 === UInt(1)) {
     io.addrBank1a := io.addr1
 } .elsewhen (io.bank2 === UInt(1)) {
     io.addrBank1a := io.addr2
 } .elsewhen (io.bank3 === UInt(1)) {
     io.addrBank1a := io.addr3
 } .elsewhen (io.bank4 === UInt(1)) {
     io.addrBank1a := io.addr4
 } .otherwise {
     io.addrBank1a := io.addrIO
 }

 when (io.bank0 === UInt(2)) {
     io.addrBank2a := io.addr0
 } .elsewhen (io.bank1 === UInt(2)) {
     io.addrBank2a := io.addr1
 } .elsewhen (io.bank2 === UInt(2)) {
     io.addrBank2a := io.addr2
 } .elsewhen (io.bank3 === UInt(2)) {
     io.addrBank2a := io.addr3
 } .elsewhen (io.bank4 === UInt(2)) {
     io.addrBank2a := io.addr4
 } .otherwise {
     io.addrBank2a := io.addrIO
 }



 when (io.bank0 === UInt(3)) {
     io.addrBank3a := io.addr0
 } .elsewhen (io.bank1 === UInt(3)) {
     io.addrBank3a := io.addr1
 } .elsewhen (io.bank2 === UInt(3)) {
     io.addrBank3a := io.addr2
 } .elsewhen (io.bank3 === UInt(3)) {
     io.addrBank3a := io.addr3
 } .elsewhen (io.bank4 === UInt(3)) {
     io.addrBank3a := io.addr4
 } .otherwise {
     io.addrBank3a := io.addrIO
 }

 when (io.bank0 === UInt(4)) {
     io.addrBank4a := io.addr0
 } .elsewhen (io.bank1 === UInt(4)) {
     io.addrBank4a := io.addr1
 } .elsewhen (io.bank2 === UInt(4)) {
     io.addrBank4a := io.addr2
 } .elsewhen (io.bank3 === UInt(4)) {
     io.addrBank4a := io.addr3
 } .elsewhen (io.bank4 === UInt(4)) {
     io.addrBank4a := io.addr4
 } .otherwise {
     io.addrBank4a := io.addrIO
 }

} .elsewhen (io.phase === UInt(0)) {  

 when (io.bank0 === UInt(0)) {
     io.addrBank0b := io.addr0
 } .elsewhen (io.bank1 === UInt(0)) {
     io.addrBank0b := io.addr1
 } .elsewhen (io.bank2 === UInt(0)) {
     io.addrBank0b := io.addr2
 } .elsewhen (io.bank3 === UInt(0)) {
     io.addrBank0b := io.addr3
 } .elsewhen (io.bank4 === UInt(0)) {
     io.addrBank0b := io.addr4
 } .otherwise {
     io.addrBank0b := io.addrIO
 }

                      
 when (io.bank0 === UInt(1)) {
     io.addrBank1b := io.addr0
 } .elsewhen (io.bank1 === UInt(1)) {
     io.addrBank1b := io.addr1
 } .elsewhen (io.bank2 === UInt(1)) {
     io.addrBank1b := io.addr2
 } .elsewhen (io.bank3 === UInt(1)) {
     io.addrBank1b := io.addr3
 } .elsewhen (io.bank4 === UInt(1)) {
     io.addrBank1b := io.addr4
 } .otherwise {
     io.addrBank1b := io.addrIO
 }

 when (io.bank0 === UInt(2)) {
     io.addrBank2b := io.addr0
 } .elsewhen (io.bank1 === UInt(2)) {
     io.addrBank2b := io.addr1
 } .elsewhen (io.bank2 === UInt(2)) {
     io.addrBank2b := io.addr2
 } .elsewhen (io.bank3 === UInt(2)) {
     io.addrBank2b := io.addr3
 } .elsewhen (io.bank4 === UInt(2)) {
     io.addrBank2b := io.addr4
 } .otherwise {
     io.addrBank2b := io.addrIO
 }

 when (io.bank0 === UInt(3)) {
     io.addrBank3b := io.addr0
 } .elsewhen (io.bank1 === UInt(3)) {
     io.addrBank3b := io.addr1
 } .elsewhen (io.bank2 === UInt(3)) {
     io.addrBank3b := io.addr2
 } .elsewhen (io.bank3 === UInt(3)) {
     io.addrBank3b := io.addr3
 } .elsewhen (io.bank4 === UInt(3)) {
     io.addrBank3b := io.addr4
 } .otherwise {
     io.addrBank3b := io.addrIO
 }

 when (io.bank0 === UInt(4)) {
     io.addrBank4b := io.addr0
 } .elsewhen (io.bank1 === UInt(4)) {
     io.addrBank4b := io.addr1
 } .elsewhen (io.bank2 === UInt(4)) {
     io.addrBank4b := io.addr2
 } .elsewhen (io.bank3 === UInt(4)) {
     io.addrBank4b := io.addr3
 } .elsewhen (io.bank4 === UInt(4)) {
     io.addrBank4b := io.addr4
 } .otherwise {
     io.addrBank4b := io.addrIO
 }
 
}
                   

                           
val memoryFFTa1 = Mem(UInt(width=9), 512, seqRead = true) 
val memoryFFTa2 = Mem(UInt(width=9), 512, seqRead = true)
val memoryFFTa3 = Mem(UInt(width=9), 512, seqRead = true) 
val memoryFFTa4 = Mem(UInt(width=9), 512, seqRead = true) 
val memoryFFTa5 = Mem(UInt(width=9), 512, seqRead = true)  
val memoryFFTb1 = Mem(UInt(width=9), 512, seqRead = true) 
val memoryFFTb2 = Mem(UInt(width=9), 512, seqRead = true)
val memoryFFTb3 = Mem(UInt(width=9), 512, seqRead = true) 
val memoryFFTb4 = Mem(UInt(width=9), 512, seqRead = true) 
val memoryFFTb5 = Mem(UInt(width=9), 512, seqRead = true) 

 
x0a := memoryFFTa1(io.addrBank0a+UInt(1))

x1a := memoryFFTa2(io.addrBank1a+UInt(1))

x2a := memoryFFTa3(io.addrBank2a+UInt(1))

x3a := memoryFFTa4(io.addrBank3a+UInt(1))

x4a := memoryFFTa5(io.addrBank4a+UInt(1))

x0b := memoryFFTb1(io.addrBank0b+UInt(1))
                            
x1b := memoryFFTb2(io.addrBank1b+UInt(1))

x2b := memoryFFTb3(io.addrBank2b+UInt(1))

x3b := memoryFFTb4(io.addrBank3b+UInt(1))

x4b := memoryFFTb5(io.addrBank4b+UInt(1))

 
when (io.phase === UInt(0)) {

 when (io.bank0 === UInt(0)){
     io.x0 := x0b
 } .elsewhen (io.bank0 === UInt(1)){
     io.x0:= x1b
 } .elsewhen (io.bank0 === UInt(2)){
     io.x0:= x2b
 } .elsewhen (io.bank0 === UInt(3)){
     io.x0 := x3b
 } .otherwise {
     io.x0 := x4b
 }

} .elsewhen(io.phase === UInt(1)) {                           

 when (io.bank0 === UInt(0)){
     io.x0 := x0a
 } .elsewhen (io.bank0 === UInt(1)){
     io.x0 := x1a
 } .elsewhen (io.bank0 === UInt(2)){
     io.x0 := x2a
 } .elsewhen (io.bank0 === UInt(3)){
     io.x0 := x3a
 } .otherwise {
     io.x0 := x4a
 }

}

when (io.phase === UInt(0)) {

 when (io.bank1 === UInt(0)){
     io.x1 := x0b
 } .elsewhen (io.bank1 === UInt(1)){
     io.x1 := x1b
 } .elsewhen (io.bank1 === UInt(2)){
     io.x1 := x2b
 } .elsewhen (io.bank1 === UInt(3)){
     io.x1 := x3b
 } .otherwise {
     io.x1 := x4b
 }

} .elsewhen(io.phase === UInt(1))  {                           

 when (io.bank1 === UInt(0)){
     io.x1 := x0a
 } .elsewhen (io.bank1 === UInt(1)){
     io.x1 := x1a
 } .elsewhen (io.bank1 === UInt(2)){
     io.x1 := x2a
 } .elsewhen (io.bank1 === UInt(3)){
     io.x1 := x3a
 } .otherwise {
     io.x1 := x4a
 }

}

when (io.phase === UInt(0)) {

 when (io.bank2 === UInt(0)){
     io.x2 := x0b
 } .elsewhen (io.bank2 === UInt(1)){
     io.x2 := x1b
 } .elsewhen (io.bank2 === UInt(2)){
     io.x2 := x2b
 } .elsewhen (io.bank2 === UInt(3)){
     io.x2 := x3b
 } .otherwise {
     io.x2 := x4b
 }

} .elsewhen(io.phase === UInt(1)) {                            

 when (io.bank2 === UInt(0)){
     io.x2 := x0a
 } .elsewhen (io.bank2 === UInt(1)){
     io.x2 := x1a
 } .elsewhen (io.bank2 === UInt(2)){
     io.x2 := x2a
 } .elsewhen (io.bank2 === UInt(3)){
     io.x2 := x3a
 } .otherwise {
     io.x2 := x4a
 }

}

when (io.phase === UInt(0)) {

 when (io.bank3 === UInt(0)){
     io.x3 := x0b
 } .elsewhen (io.bank3 === UInt(1)){
     io.x3 := x1b
 } .elsewhen (io.bank3 === UInt(2)){
     io.x3 := x2b
 } .elsewhen (io.bank3 === UInt(3)){
     io.x3 := x3b
 } .otherwise {
     io.x3 := x4b
 }

} .elsewhen(io.phase === UInt(1)) {                            

 when (io.bank3 === UInt(0)){
     io.x3 := x0a
 } .elsewhen (io.bank3 === UInt(1)){
     io.x3 := x1a
 } .elsewhen (io.bank3 === UInt(2)){
     io.x3 := x2a
 } .elsewhen (io.bank3 === UInt(3)){
     io.x3 := x3a
 } .otherwise {
     io.x3 := x4a
 }

}

 

when (io.phase === UInt(0)) {

 when (io.bank4 === UInt(0)){
     io.x4 := x0b
 } .elsewhen (io.bank4 === UInt(1)){
     io.x4 := x1b
 } .elsewhen (io.bank4 === UInt(2)){
     io.x4 := x2b
 } .elsewhen (io.bank4 === UInt(3)){
     io.x4 := x3b
 } .otherwise {
     io.x4 := x4b
 }

} .elsewhen(io.phase === UInt(1)) {                            

 when (io.bank4 === UInt(0)){
     io.x4 := x0a
 } .elsewhen (io.bank4 === UInt(1)){
     io.x4 := x1a
 } .elsewhen (io.bank4 === UInt(2)){
     io.x4 := x2a
 } .elsewhen (io.bank4 === UInt(3)){
     io.x4 := x3a
 } .otherwise {
     io.x4 := x4a
 }

}

// [y0,y1,y2,y3,y4] = radix2345(x0,x1,x2,x3,x4,currentRadix,twiddle1,twiddle2,twiddle3,twiddle4)

when (io.bank0 === UInt(0) && io.phase === UInt(1)){     
 y0a := y0
} .elsewhen (io.bank1 === UInt(0)&& io.phase === UInt(1)) {
   y0a := y1
} .elsewhen (io.bank2 === UInt(0)&& io.phase === UInt(1)) {
   y0a := y2
} .elsewhen (io.bank3 === UInt(0)&& io.phase === UInt(1)) {
   y0a := y3
} .elsewhen (io.bank4 === UInt(0)&& io.phase === UInt(1)) {
   y0a := y4
} .elsewhen (io.bankIO === UInt(0)&& io.phase === UInt(0)) {
   y0a := io.Din
} .otherwise {
   y0a := x0a
}




when (io.bank0 === UInt(1) && io.phase === UInt(1)){     
 y1a := y0
} .elsewhen (io.bank1 === UInt(1)&& io.phase === UInt(1)) {
   y1a := y1
} .elsewhen (io.bank2 === UInt(1)&& io.phase === UInt(1)) {
   y1a := y2
} .elsewhen (io.bank3 === UInt(1)&& io.phase === UInt(1)) {
   y1a := y3
} .elsewhen (io.bank4 === UInt(1)&& io.phase === UInt(1)) {
   y1a := y4
} .elsewhen (io.bankIO === UInt(1)&& io.phase === UInt(0)) {
   y1a := io.Din
} .otherwise {
   y1a := x1a
}


when (io.bank0 === UInt(2) && io.phase === UInt(1)){     
 y2a := y0
} .elsewhen (io.bank1 === UInt(2)&& io.phase === UInt(1)) {
   y2a := y1
} .elsewhen (io.bank2 === UInt(2)&& io.phase === UInt(1)) {
   y2a := y2
} .elsewhen (io.bank3 === UInt(2)&& io.phase === UInt(1)) {
   y2a := y3
} .elsewhen (io.bank4 === UInt(2)&& io.phase === UInt(1)) {
   y2a := y4
} .elsewhen (io.bankIO === UInt(2)&& io.phase === UInt(0)) {
   y2a := io.Din
} .otherwise {
   y2a := x2a
}


when (io.bank0 === UInt(3) && io.phase === UInt(1)){     
 y3a := y0
} .elsewhen (io.bank1 === UInt(3)&& io.phase === UInt(1)) {
   y3a := y1
} .elsewhen (io.bank2 === UInt(3)&& io.phase === UInt(1)) {
   y3a := y2
} .elsewhen (io.bank3 === UInt(3)&& io.phase === UInt(1)) {
   y3a := y3
} .elsewhen (io.bank4 === UInt(3)&& io.phase === UInt(1)) {
   y3a := y4
} .elsewhen (io.bankIO === UInt(3)&& io.phase === UInt(0)) {
   y3a := io.Din
} .otherwise {
   y3a := x3a
}

when (io.bank0 === UInt(4) && io.phase === UInt(1)){     
 y4a := y0
} .elsewhen (io.bank1 === UInt(4)&& io.phase === UInt(1)) {
   y4a := y1
} .elsewhen (io.bank2 === UInt(4)&& io.phase === UInt(1)) {
   y4a := y2
} .elsewhen (io.bank3 === UInt(4)&& io.phase === UInt(1)) {
   y4a := y3
} .elsewhen (io.bank4 === UInt(4)&& io.phase === UInt(1)) {
   y4a := y4
} .elsewhen (io.bankIO === UInt(4)&& io.phase === UInt(0)) {
   y4a := io.Din
} .otherwise {
   y4a := x4a
}

when (io.bank0 === UInt(0) && io.phase === UInt(0)){     
 y0b := y0
} .elsewhen (io.bank1 === UInt(0)&& io.phase === UInt(0)) {
   y0b := y1
} .elsewhen (io.bank2 === UInt(0)&& io.phase === UInt(0)) {
   y0b := y2
} .elsewhen (io.bank3 === UInt(0)&& io.phase === UInt(0)) {
   y0b := y3
} .elsewhen (io.bank4 === UInt(0)&& io.phase === UInt(0)) {
   y0b := y4
} .elsewhen (io.bankIO === UInt(0)&& io.phase === UInt(1)) {
   y0b := io.Din
} .otherwise {
   y0b := x0b
}


when (io.bank0 === UInt(1) && io.phase === UInt(0)){     
 y1b := y0
} .elsewhen (io.bank1 === UInt(1)&& io.phase === UInt(0)) {
   y1b := y1
} .elsewhen (io.bank2 === UInt(1)&& io.phase === UInt(0)) {
   y1b := y2
} .elsewhen (io.bank3 === UInt(1)&& io.phase === UInt(0)) {
   y1b := y3
} .elsewhen (io.bank4 === UInt(1)&& io.phase === UInt(0)) {
   y1b := y4
} .elsewhen (io.bankIO === UInt(1)&& io.phase === UInt(1)) {
   y1b := io.Din
} .otherwise {
   y1b := x1b
}

when (io.bank0 === UInt(2) && io.phase === UInt(0)){     
 y2b := y0
} .elsewhen (io.bank1 === UInt(2)&& io.phase === UInt(0)) {
   y2b := y1
} .elsewhen (io.bank2 === UInt(2)&& io.phase === UInt(0)) {
   y2b := y2
} .elsewhen (io.bank3 === UInt(2)&& io.phase === UInt(0)) {
   y2b := y3
} .elsewhen (io.bank4 === UInt(2)&& io.phase === UInt(0)) {
   y2b := y4
} .elsewhen (io.bankIO === UInt(2)&& io.phase === UInt(1)) {
   y2b := io.Din
} .otherwise {
   y2b := x2b
}




when (io.bank0 === UInt(3) && io.phase === UInt(0)){     
 y3b := y0
} .elsewhen (io.bank1 === UInt(3)&& io.phase === UInt(0)) {
   y3b := y1
} .elsewhen (io.bank2 === UInt(3)&& io.phase === UInt(0)) {
   y3b := y2
} .elsewhen (io.bank3 === UInt(3)&& io.phase === UInt(0)) {
   y3b := y3
} .elsewhen (io.bank4 === UInt(3)&& io.phase === UInt(0)) {
   y3b := y4
} .elsewhen (io.bankIO === UInt(3)&& io.phase === UInt(1)) {
   y3b := io.Din
} .otherwise {
   y3b := x3b
}


when (io.bank0 === UInt(4) && io.phase === UInt(0)){     
 y4b := y0
} .elsewhen (io.bank1 === UInt(4)&& io.phase === UInt(0)) {
   y4b := y1
} .elsewhen (io.bank2 === UInt(4)&& io.phase === UInt(0)) {
   y4b := y2
} .elsewhen (io.bank3 === UInt(4)&& io.phase === UInt(0)) {
   y4b := y3
} .elsewhen (io.bank4 === UInt(4)&& io.phase === UInt(0)) {
   y4b := y4
} .elsewhen (io.bankIO === UInt(4)&& io.phase === UInt(1)) {
   y4b := io.Din
} .otherwise {
   y4b := x4b
}






memoryFFTa1(io.addrBank0a+UInt(1)) := y0a
memoryFFTa2(io.addrBank1a+UInt(1)) := y1a
memoryFFTa3(io.addrBank2a+UInt(1)) := y2a
memoryFFTa4(io.addrBank3a+UInt(1)) := y3a
memoryFFTa5(io.addrBank4a+UInt(1)) := y4a
memoryFFTb1(io.addrBank0b+UInt(1)) := y0b
memoryFFTb2(io.addrBank1b+UInt(1)) := y1b
memoryFFTb3(io.addrBank2b+UInt(1)) := y2b
memoryFFTb4(io.addrBank3b+UInt(1)) := y3b
memoryFFTb5(io.addrBank4b+UInt(1)) := y4b






}//end of moduel



class membankstest (c: membanks) extends Tester (c) {

poke(c.io.bank0, 0)
poke(c.io.bank1, 0)
poke(c.io.bank2, 3)
poke(c.io.bank3, 1)
poke(c.io.bank4, 0)
poke(c.io.phase, 1)
poke(c.io.addr0, 12)
poke(c.io.addr1, 4)
poke(c.io.addr2, 3)
poke(c.io.addr3, 5)
poke(c.io.addr4, 2)
poke(c.io.addrIO, 7)
poke(c.io.bankIO, 8)
poke(c.io.Din, 1)

step(1)

expect(c.io.x0, 9)
expect(c.io.x1, 9) 
expect(c.io.x2, 9)  
expect(c.io.x3, 9)
expect(c.io.x4, 9)
expect(c.io.addrBank0a, 9)
expect(c.io.addrBank1a, 9)
expect(c.io.addrBank2a, 9)
expect(c.io.addrBank3a, 9)
expect(c.io.addrBank4a, 9)
expect(c.io.addrBank0b, 9)
expect(c.io.addrBank1b, 9)
expect(c.io.addrBank2b, 9)
expect(c.io.addrBank3b, 9)
expect(c.io.addrBank4b, 9)





}
