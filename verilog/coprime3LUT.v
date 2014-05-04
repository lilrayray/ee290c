module coprime3LUT(
    input [3:0] io_in,
    output[7:0] io_out
);

  wire[7:0] T0;
  reg [7:0] T1 [5:0];
  wire[2:0] T2;


  assign io_out = T0;
`ifndef SYNTHESIS
  assign T0 = T2 >= 3'h6 ? {1{$random}} : T1[T2];
`else
  assign T0 = T1[T2];
`endif
  always @(*) begin
    T1[0] = 8'h1;
    T1[1] = 8'h3;
    T1[2] = 8'h9;
    T1[3] = 8'h1b;
    T1[4] = 8'h51;
    T1[5] = 8'hf3;
  end
  assign T2 = io_in[2'h2:1'h0];
endmodule

