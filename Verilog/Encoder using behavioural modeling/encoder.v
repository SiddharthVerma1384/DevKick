module encoder(input [7:0]I, output reg [2:0]S);
  always @(I)
  begin
  case (I)
        8'b00000001: S = 3'b000; 
        8'b00000010: S = 3'b001; 
        8'b00000100: S = 3'b010; 
        8'b00001000: S = 3'b011; 
        8'b00010000: S = 3'b100; 
        8'b00100000: S = 3'b101; 
        8'b01000000: S = 3'b110; 
        8'b10000000: S = 3'b111;
      endcase
    end
  endmodule 
  
  module encoder_tb();
    reg [7:0]I;
    wire [2:0]S;
    encoder uut(I,S);
    initial
    begin
        I = 8'b00000001; #10;   
        I = 8'b00000010; #10;   
        I = 8'b00000100; #10;   
        I = 8'b00001000; #10;   
        I = 8'b00010000; #10;   
        I = 8'b00100000; #10;   
        I = 8'b01000000; #10;   
        I = 8'b10000000; #10;
        $finish;
      end
    endmodule   