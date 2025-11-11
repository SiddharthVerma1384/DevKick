module jk_FF(input clk, j, k, reset, output reg q, output qbar);
  assign qbar = ~q;
  always @(posedge clk or negedge reset)
  begin
    if(~reset)
      begin
        q <= 1'b0;
      end
    else
      begin
        case({j,k})
          2'b00 : q <= q;
          2'b01 : q <= 1'b0;
          2'b10 : q <= 1'b1;
          2'b11 : q <= ~q;
          default : q <= q;
        endcase
      end
    end
  endmodule
  
  module jk_FF_tb;
    reg clk,j,k,reset;
    wire q;
    wire qbar;
    jk_FF uut(.clk(clk), .j(j), .k(k), .reset(reset), .q(q), .qbar(qbar));
    initial begin
      clk = 0;
      forever #10 clk = ~clk;
    end
    initial begin
      j = 0; k = 0; reset = 1'b0; #20;
      reset = 1'b1; 
      j = 1'b0; k = 1'b0; #20;
      j = 1'b0; k = 1'b1; #20;
      j = 1'b1; k = 1'b0; #20;
      j = 1'b1; k = 1'b1; #20;
      $finish;
    end
  endmodule    