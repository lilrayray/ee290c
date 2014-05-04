module coprime2LUT(
    input [3:0] io_in,
    output[11:0] io_out
);

  wire[11:0] T0;
  reg [11:0] T1 [11:0];


  assign io_out = T0;
`ifndef SYNTHESIS
  assign T0 = io_in >= 4'hc ? {1{$random}} : T1[io_in];
`else
  assign T0 = T1[io_in];
`endif
  always @(*) begin
    T1[0] = 12'h1;
    T1[1] = 12'h2;
    T1[2] = 12'h4;
    T1[3] = 12'h8;
    T1[4] = 12'h10;
    T1[5] = 12'h20;
    T1[6] = 12'h40;
    T1[7] = 12'h80;
    T1[8] = 12'h100;
    T1[9] = 12'h200;
    T1[10] = 12'h400;
    T1[11] = 12'h800;
  end
endmodule

