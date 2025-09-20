module decoder(input E, input [2:0]S, output [7:0]Y);
  assign Y[0] = E & ~S[2] & ~S[1] & ~S[0];
  assign Y[1] = E & ~S[2] & ~S[1] &  S[0];
  assign Y[2] = E & ~S[2] &  S[1] & ~S[0];
  assign Y[3] = E & ~S[2] &  S[1] &  S[0];
  assign Y[4] = E &  S[2] & ~S[1] & ~S[0];
  assign Y[5] = E &  S[2] & ~S[1] &  S[0];
  assign Y[6] = E &  S[2] &  S[1] & ~S[0];
  assign Y[7] = E &  S[2] &  S[1] &  S[0];
endmodule

module decoder_tb();
  reg E;
  reg [2:0]S;
  wire [7:0]Y;
  decoder uut(E,S,Y);
  initial
  begin
  E = 0;S= 3'b000;
  #100
  E = 1;S= 3'b000;
  #100
  E = 1;S= 3'b011;
  #100
  E = 1;S= 3'b101;
  #100
  E = 1;S= 3'b111;
  #100
  $finish;
end
endmodule