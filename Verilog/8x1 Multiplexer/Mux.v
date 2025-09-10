module Mux(input [0:7]I, input [2:0]S, output reg F);
  always@(S)
  begin
  case (S)
    3'b000 : F = I[0];
    3'b001 : F = I[1];
    3'b010 : F = I[2];
    3'b011 : F = I[3];
    3'b100 : F = I[4];
    3'b101 : F = I[5];
    3'b110 : F = I[6];
    3'b111 : F = I[7];
  endcase
end
endmodule

module Mux_tb();
  reg [0:7]I;
  reg [2:0]S;
  wire F;
  
  Mux uut(I,S,F);
  initial
  begin 
  I = 8'b01010011; S = 3'b001;
  #100
  I = 8'b01010011; S = 3'b010;
  #100
  I = 8'b01010011; S = 3'b110;
  #100
  I = 8'b01010011; S = 3'b111;
  #100
  $finish;
end
endmodule