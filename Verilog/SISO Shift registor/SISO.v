module SISO(input clk, reset,Din, output Dout);
  reg [3:0]q;
  always @(posedge clk or posedge reset)
  begin
    if (reset)
      q <= 4'b0000;
    else
      q <= {q[2:0],Din};
    end
    assign Dout = q[3];
  endmodule
  
  module SISO_tb;
  reg clk,reset,Din;
  wire Dout;
  SISO uut(.clk(clk), .reset(reset), .Din(Din), .Dout(Dout));
  initial begin
  clk = 0;
  forever #5 clk = ~clk;
end
initial begin
reset = 1; Din = 0; #10
reset = 0;
Din = 1; #10;
Din = 0; #10;
Din = 1; #10;
Din = 1; #10;
#50
$finish;
end
endmodule        