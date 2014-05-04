module qoutLUT(
    input [5:0] io_ina,
    input [2:0] io_inb,
    output[8:0] io_qout
);

  wire[8:0] T0;
  wire[7:0] T1;
  wire[7:0] T2;
  wire[7:0] T3;
  reg [7:0] T4 [83:0];
  wire[6:0] T5;
  wire[7:0] T6;
  wire[7:0] index;
  wire[7:0] T7;
  wire[6:0] T8;
  wire T9;
  wire T10;


  assign io_qout = T0;
  assign T0 = {1'h0, T1};
  assign T1 = T10 ? T3 : T2;
  assign T2 = T9 ? T7 : T3;
`ifndef SYNTHESIS
  assign T3 = T5 >= 7'h54 ? {1{$random}} : T4[T5];
`else
  assign T3 = T4[T5];
`endif
  always @(*) begin
    T4[0] = 8'h0;
    T4[1] = 8'h2;
    T4[2] = 8'h0;
    T4[3] = 8'h1;
    T4[4] = 8'h0;
    T4[5] = 8'h2;
    T4[6] = 8'h0;
    T4[7] = 8'h2;
    T4[8] = 8'h2;
    T4[9] = 8'h2;
    T4[10] = 8'h0;
    T4[11] = 8'h1;
    T4[12] = 8'h0;
    T4[13] = 8'h1;
    T4[14] = 8'h0;
    T4[15] = 8'h14;
    T4[16] = 8'h1;
    T4[17] = 8'h1;
    T4[18] = 8'h0;
    T4[19] = 8'h5;
    T4[20] = 8'h4;
    T4[21] = 8'h2;
    T4[22] = 8'h0;
    T4[23] = 8'h2;
    T4[24] = 8'h0;
    T4[25] = 8'ha;
    T4[26] = 8'h3;
    T4[27] = 8'h2;
    T4[28] = 8'h0;
    T4[29] = 8'h7;
    T4[30] = 8'h2;
    T4[31] = 8'h2;
    T4[32] = 8'h0;
    T4[33] = 8'h14;
    T4[34] = 8'h2;
    T4[35] = 8'h1;
    T4[36] = 8'h0;
    T4[37] = 8'h1;
    T4[38] = 8'h0;
    T4[39] = 8'h5;
    T4[40] = 8'h4;
    T4[41] = 8'h1;
    T4[42] = 8'h3;
    T4[43] = 8'h14;
    T4[44] = 8'h0;
    T4[45] = 8'h8;
    T4[46] = 8'h1;
    T4[47] = 8'h1;
    T4[48] = 8'h0;
    T4[49] = 8'ha;
    T4[50] = 8'h1;
    T4[51] = 8'h5;
    T4[52] = 8'h0;
    T4[53] = 8'h2;
    T4[54] = 8'h0;
    T4[55] = 8'h10;
    T4[56] = 8'h9;
    T4[57] = 8'h2;
    T4[58] = 8'h2;
    T4[59] = 8'h2;
    T4[60] = 8'h0;
    T4[61] = 8'hb6;
    T4[62] = 8'h4;
    T4[63] = 8'ha;
    T4[64] = 8'h0;
    T4[65] = 8'h4;
    T4[66] = 8'hd;
    T4[67] = 8'h2;
    T4[68] = 8'h0;
    T4[69] = 8'h5;
    T4[70] = 8'h0;
    T4[71] = 8'h1;
    T4[72] = 8'h0;
    T4[73] = 8'h0;
    T4[74] = 8'h0;
    T4[75] = 8'h0;
    T4[76] = 8'h0;
    T4[77] = 8'h0;
    T4[78] = 8'h0;
    T4[79] = 8'h0;
    T4[80] = 8'h0;
    T4[81] = 8'h0;
    T4[82] = 8'h0;
    T4[83] = 8'h0;
  end
  assign T5 = T6[3'h6:1'h0];
  assign T6 = index + 8'h1;
  assign index = io_ina * 2'h2;
`ifndef SYNTHESIS
  assign T7 = T8 >= 7'h54 ? {1{$random}} : T4[T8];
`else
  assign T7 = T4[T8];
`endif
  assign T8 = index[3'h6:1'h0];
  assign T9 = io_inb == 3'h0;
  assign T10 = T9 == 1'h0;
endmodule

