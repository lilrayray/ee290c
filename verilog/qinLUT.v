module qinLUT(
    input [5:0] io_ina,
    output[8:0] io_qin_0,
    output[8:0] io_qin_1
);

  wire[8:0] T0;
  reg [8:0] T1 [83:0];
  wire[6:0] T2;
  wire[7:0] T3;
  wire[7:0] index;
  wire[8:0] T4;
  wire[6:0] T5;


  assign io_qin_1 = T0;
`ifndef SYNTHESIS
  assign T0 = T2 >= 7'h54 ? {1{$random}} : T1[T2];
`else
  assign T0 = T1[T2];
`endif
  always @(*) begin
    T1[0] = 9'h1;
    T1[1] = 9'h0;
    T1[2] = 9'h5;
    T1[3] = 9'h0;
    T1[4] = 9'h3;
    T1[5] = 9'h0;
    T1[6] = 9'h5;
    T1[7] = 9'h0;
    T1[8] = 9'h1;
    T1[9] = 9'h1;
    T1[10] = 9'h7;
    T1[11] = 9'h0;
    T1[12] = 9'h15;
    T1[13] = 9'h0;
    T1[14] = 9'h1;
    T1[15] = 9'h0;
    T1[16] = 9'h1;
    T1[17] = 9'h1;
    T1[18] = 9'h7;
    T1[19] = 9'h0;
    T1[20] = 9'h3;
    T1[21] = 9'h7;
    T1[22] = 9'h15;
    T1[23] = 9'h0;
    T1[24] = 9'h5;
    T1[25] = 9'h0;
    T1[26] = 9'h1;
    T1[27] = 9'h1;
    T1[28] = 9'h7;
    T1[29] = 9'h0;
    T1[30] = 9'h1;
    T1[31] = 9'h2;
    T1[32] = 9'h3;
    T1[33] = 9'h0;
    T1[34] = 9'h3;
    T1[35] = 9'h7;
    T1[36] = 9'h55;
    T1[37] = 9'h0;
    T1[38] = 9'hd;
    T1[39] = 9'h0;
    T1[40] = 9'h11;
    T1[41] = 9'h1;
    T1[42] = 9'h1;
    T1[43] = 9'h10;
    T1[44] = 9'h7;
    T1[45] = 9'h0;
    T1[46] = 9'h5;
    T1[47] = 9'h2;
    T1[48] = 9'h7;
    T1[49] = 9'h0;
    T1[50] = 9'hb;
    T1[51] = 9'h7;
    T1[52] = 9'h55;
    T1[53] = 9'h0;
    T1[54] = 9'hd;
    T1[55] = 9'h0;
    T1[56] = 9'h3;
    T1[57] = 9'h5;
    T1[58] = 9'h11;
    T1[59] = 9'h1;
    T1[60] = 9'h1;
    T1[61] = 9'h0;
    T1[62] = 9'h1;
    T1[63] = 9'h10;
    T1[64] = 9'h47;
    T1[65] = 9'h0;
    T1[66] = 9'hd;
    T1[67] = 9'h2;
    T1[68] = 9'hf;
    T1[69] = 9'h0;
    T1[70] = 9'h155;
    T1[71] = 9'h0;
    T1[72] = 9'h0;
    T1[73] = 9'h0;
    T1[74] = 9'h0;
    T1[75] = 9'h0;
    T1[76] = 9'h0;
    T1[77] = 9'h0;
    T1[78] = 9'h0;
    T1[79] = 9'h0;
    T1[80] = 9'h0;
    T1[81] = 9'h0;
    T1[82] = 9'h0;
    T1[83] = 9'h0;
  end
  assign T2 = T3[3'h6:1'h0];
  assign T3 = index + 8'h1;
  assign index = io_ina * 2'h2;
  assign io_qin_0 = T4;
`ifndef SYNTHESIS
  assign T4 = T5 >= 7'h54 ? {1{$random}} : T1[T5];
`else
  assign T4 = T1[T5];
`endif
  assign T5 = index[3'h6:1'h0];
endmodule

