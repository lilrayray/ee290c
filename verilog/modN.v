module modN(
    input [15:0] io_address,
    input [15:0] io_N,
    output[15:0] io_output
);

  wire[15:0] T0;
  wire[15:0] T1;
  wire[15:0] sub;
  wire T2;
  wire T3;
  wire T4;


  assign io_output = T0;
  assign T0 = T4 ? io_address : T1;
  assign T1 = T2 ? sub : io_address;
  assign sub = io_address - io_N;
  assign T2 = T3 == 1'h0;
  assign T3 = sub[4'hf:4'hf];
  assign T4 = T2 == 1'h0;
endmodule

