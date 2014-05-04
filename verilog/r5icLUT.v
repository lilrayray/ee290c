module r5icLUT(
    input [10:0] io_ina,
    input [2:0] io_inb,
    output[2:0] io_r5IC
);

  wire[2:0] T0;
  reg [2:0] T1 [49:0];
  wire[5:0] T2;
  wire[12:0] T3;
  wire[12:0] T4;
  wire[12:0] index;


  assign io_r5IC = T0;
`ifndef SYNTHESIS
  assign T0 = T2 >= 6'h32 ? {1{$random}} : T1[T2];
`else
  assign T0 = T1[T2];
`endif
  always @(*) begin
    T1[0] = 3'h0;
    T1[1] = 3'h0;
    T1[2] = 3'h1;
    T1[3] = 3'h0;
    T1[4] = 3'h2;
    T1[5] = 3'h0;
    T1[6] = 3'h3;
    T1[7] = 3'h0;
    T1[8] = 3'h4;
    T1[9] = 3'h0;
    T1[10] = 3'h0;
    T1[11] = 3'h1;
    T1[12] = 3'h1;
    T1[13] = 3'h1;
    T1[14] = 3'h2;
    T1[15] = 3'h1;
    T1[16] = 3'h3;
    T1[17] = 3'h1;
    T1[18] = 3'h4;
    T1[19] = 3'h1;
    T1[20] = 3'h0;
    T1[21] = 3'h2;
    T1[22] = 3'h1;
    T1[23] = 3'h2;
    T1[24] = 3'h2;
    T1[25] = 3'h2;
    T1[26] = 3'h3;
    T1[27] = 3'h2;
    T1[28] = 3'h4;
    T1[29] = 3'h2;
    T1[30] = 3'h0;
    T1[31] = 3'h3;
    T1[32] = 3'h1;
    T1[33] = 3'h3;
    T1[34] = 3'h2;
    T1[35] = 3'h3;
    T1[36] = 3'h3;
    T1[37] = 3'h3;
    T1[38] = 3'h4;
    T1[39] = 3'h3;
    T1[40] = 3'h0;
    T1[41] = 3'h4;
    T1[42] = 3'h1;
    T1[43] = 3'h4;
    T1[44] = 3'h2;
    T1[45] = 3'h4;
    T1[46] = 3'h3;
    T1[47] = 3'h4;
    T1[48] = 3'h4;
    T1[49] = 3'h4;
  end
  assign T2 = T3[3'h5:1'h0];
  assign T3 = index + T4;
  assign T4 = {10'h0, io_inb};
  assign index = io_ina * 2'h2;
endmodule

