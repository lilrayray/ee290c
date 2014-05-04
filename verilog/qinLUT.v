module qinLUT(
    input [5:0] io_ina,
    input [2:0] io_inb,
    output[8:0] io_qin
);

  wire[8:0] T0;
  wire[8:0] T1;
  wire[8:0] T2;
  reg [8:0] T3 [83:0];
  wire[6:0] T4;
  wire[7:0] T5;
  wire[7:0] index;
  wire[8:0] T6;
  wire[6:0] T7;
  wire T8;
  wire T9;


  assign io_qin = T0;
  assign T0 = T9 ? T2 : T1;
  assign T1 = T8 ? T6 : T2;
`ifndef SYNTHESIS
  assign T2 = T4 >= 7'h54 ? {1{$random}} : T3[T4];
`else
  assign T2 = T3[T4];
`endif
  always @(*) begin
    T3[0] = 9'h1;
    T3[1] = 9'h0;
    T3[2] = 9'h5;
    T3[3] = 9'h0;
    T3[4] = 9'h3;
    T3[5] = 9'h0;
    T3[6] = 9'h5;
    T3[7] = 9'h0;
    T3[8] = 9'h1;
    T3[9] = 9'h1;
    T3[10] = 9'h7;
    T3[11] = 9'h0;
    T3[12] = 9'h15;
    T3[13] = 9'h0;
    T3[14] = 9'h1;
    T3[15] = 9'h0;
    T3[16] = 9'h1;
    T3[17] = 9'h1;
    T3[18] = 9'h7;
    T3[19] = 9'h0;
    T3[20] = 9'h3;
    T3[21] = 9'h7;
    T3[22] = 9'h15;
    T3[23] = 9'h0;
    T3[24] = 9'h5;
    T3[25] = 9'h0;
    T3[26] = 9'h1;
    T3[27] = 9'h1;
    T3[28] = 9'h7;
    T3[29] = 9'h0;
    T3[30] = 9'h1;
    T3[31] = 9'h2;
    T3[32] = 9'h3;
    T3[33] = 9'h0;
    T3[34] = 9'h3;
    T3[35] = 9'h7;
    T3[36] = 9'h55;
    T3[37] = 9'h0;
    T3[38] = 9'hd;
    T3[39] = 9'h0;
    T3[40] = 9'h11;
    T3[41] = 9'h1;
    T3[42] = 9'h1;
    T3[43] = 9'h10;
    T3[44] = 9'h7;
    T3[45] = 9'h0;
    T3[46] = 9'h5;
    T3[47] = 9'h2;
    T3[48] = 9'h7;
    T3[49] = 9'h0;
    T3[50] = 9'hb;
    T3[51] = 9'h7;
    T3[52] = 9'h55;
    T3[53] = 9'h0;
    T3[54] = 9'hd;
    T3[55] = 9'h0;
    T3[56] = 9'h3;
    T3[57] = 9'h5;
    T3[58] = 9'h11;
    T3[59] = 9'h1;
    T3[60] = 9'h1;
    T3[61] = 9'h0;
    T3[62] = 9'h1;
    T3[63] = 9'h10;
    T3[64] = 9'h47;
    T3[65] = 9'h0;
    T3[66] = 9'hd;
    T3[67] = 9'h2;
    T3[68] = 9'hf;
    T3[69] = 9'h0;
    T3[70] = 9'h155;
    T3[71] = 9'h0;
    T3[72] = 9'h0;
    T3[73] = 9'h0;
    T3[74] = 9'h0;
    T3[75] = 9'h0;
    T3[76] = 9'h0;
    T3[77] = 9'h0;
    T3[78] = 9'h0;
    T3[79] = 9'h0;
    T3[80] = 9'h0;
    T3[81] = 9'h0;
    T3[82] = 9'h0;
    T3[83] = 9'h0;
  end
  assign T4 = T5[3'h6:1'h0];
  assign T5 = index + 8'h1;
  assign index = io_ina * 2'h2;
`ifndef SYNTHESIS
  assign T6 = T7 >= 7'h54 ? {1{$random}} : T3[T7];
`else
  assign T6 = T3[T7];
`endif
  assign T7 = index[3'h6:1'h0];
  assign T8 = io_inb == 3'h0;
  assign T9 = T8 == 1'h0;
endmodule

