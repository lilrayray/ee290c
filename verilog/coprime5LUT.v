module coprime5LUT(
    input [2:0] io_in,
    output[4:0] io_out
);

  wire[4:0] T0;
  reg [4:0] T1 [2:0];
  wire[1:0] T2;


  assign io_out = T0;
`ifndef SYNTHESIS
  assign T0 = T2 >= 2'h3 ? {1{$random}} : T1[T2];
`else
  assign T0 = T1[T2];
`endif
  always @(*) begin
    T1[0] = 5'h1;
    T1[1] = 5'h5;
    T1[2] = 5'h19;
  end
  assign T2 = io_in[1'h1:1'h0];
endmodule

