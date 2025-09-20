module demux(input F, input [2:0]S, output [7:0]O);
  assign O[0] = F & ~S[2] & ~S[1] & ~S[0];
  assign O[1] = F & ~S[2] & ~S[1] &  S[0];
  assign O[2] = F & ~S[2] &  S[1] & ~S[0];
  assign O[3] = F & ~S[2] &  S[1] &  S[0];
  assign O[4] = F &  S[2] & ~S[1] & ~S[0];
  assign O[5] = F &  S[2] & ~S[1] &  S[0];
  assign O[6] = F &  S[2] &  S[1] & ~S[0];
  assign O[7] = F &  S[2] &  S[1] &  S[0];
endmodule

module demux_tb();
  reg F;
  reg [2:0]S;
  wire [7:0]O;
  demux uut(F,S,O);
  initial
  begin
    F = 1;S = 3'b000;
    #100
    F = 0;S = 3'b001;
    #100
    F = 1;S = 3'b001;
    #100
    F = 0;S = 3'b011;
    #100
    F = 1;S = 3'b101;    
    #100
    $finish;
  end
endmodule