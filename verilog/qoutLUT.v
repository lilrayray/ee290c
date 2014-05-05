module qoutLUT(
    input [5:0] io_ina,
    output[8:0] io_qout_0,
    output[8:0] io_qout_1
);

  wire[8:0] T0;
  wire[7:0] T1;
  reg [7:0] T2 [83:0];
  wire[6:0] T3;
  wire[7:0] T4;
  wire[7:0] index;
  wire[8:0] T5;
  wire[7:0] T6;
  wire[6:0] T7;


  assign io_qout_1 = T0;
  assign T0 = {1'h0, T1};
`ifndef SYNTHESIS
  assign T1 = T3 >= 7'h54 ? {1{$random}} : T2[T3];
`else
  assign T1 = T2[T3];
`endif
  always @(*) begin
    T2[0] = 8'h0;
    T2[1] = 8'h2;
    T2[2] = 8'h0;
    T2[3] = 8'h1;
    T2[4] = 8'h0;
    T2[5] = 8'h2;
    T2[6] = 8'h0;
    T2[7] = 8'h2;
    T2[8] = 8'h2;
    T2[9] = 8'h2;
    T2[10] = 8'h0;
    T2[11] = 8'h1;
    T2[12] = 8'h0;
    T2[13] = 8'h1;
    T2[14] = 8'h0;
    T2[15] = 8'h14;
    T2[16] = 8'h1;
    T2[17] = 8'h1;
    T2[18] = 8'h0;
    T2[19] = 8'h5;
    T2[20] = 8'h4;
    T2[21] = 8'h2;
    T2[22] = 8'h0;
    T2[23] = 8'h2;
    T2[24] = 8'h0;
    T2[25] = 8'ha;
    T2[26] = 8'h3;
    T2[27] = 8'h2;
    T2[28] = 8'h0;
    T2[29] = 8'h7;
    T2[30] = 8'h2;
    T2[31] = 8'h2;
    T2[32] = 8'h0;
    T2[33] = 8'h14;
    T2[34] = 8'h2;
    T2[35] = 8'h1;
    T2[36] = 8'h0;
    T2[37] = 8'h1;
    T2[38] = 8'h0;
    T2[39] = 8'h5;
    T2[40] = 8'h4;
    T2[41] = 8'h1;
    T2[42] = 8'h3;
    T2[43] = 8'h14;
    T2[44] = 8'h0;
    T2[45] = 8'h8;
    T2[46] = 8'h1;
    T2[47] = 8'h1;
    T2[48] = 8'h0;
    T2[49] = 8'ha;
    T2[50] = 8'h1;
    T2[51] = 8'h5;
    T2[52] = 8'h0;
    T2[53] = 8'h2;
    T2[54] = 8'h0;
    T2[55] = 8'h10;
    T2[56] = 8'h9;
    T2[57] = 8'h2;
    T2[58] = 8'h2;
    T2[59] = 8'h2;
    T2[60] = 8'h0;
    T2[61] = 8'hb6;
    T2[62] = 8'h4;
    T2[63] = 8'ha;
    T2[64] = 8'h0;
    T2[65] = 8'h4;
    T2[66] = 8'hd;
    T2[67] = 8'h2;
    T2[68] = 8'h0;
    T2[69] = 8'h5;
    T2[70] = 8'h0;
    T2[71] = 8'h1;
    T2[72] = 8'h0;
    T2[73] = 8'h0;
    T2[74] = 8'h0;
    T2[75] = 8'h0;
    T2[76] = 8'h0;
    T2[77] = 8'h0;
    T2[78] = 8'h0;
    T2[79] = 8'h0;
    T2[80] = 8'h0;
    T2[81] = 8'h0;
    T2[82] = 8'h0;
    T2[83] = 8'h0;
  end
  assign T3 = T4[3'h6:1'h0];
  assign T4 = index + 8'h1;
  assign index = io_ina * 2'h2;
  assign io_qout_0 = T5;
  assign T5 = {1'h0, T6};
`ifndef SYNTHESIS
  assign T6 = T7 >= 7'h54 ? {1{$random}} : T2[T7];
`else
  assign T6 = T2[T7];
`endif
  assign T7 = index[3'h6:1'h0];
endmodule

