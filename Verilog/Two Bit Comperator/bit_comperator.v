module bit_comperator(input [1:0]A, input [1:0]B, output W,X,Y);
  wire t1,t2,t3,t4;
  assign t1 = ~(B[1]);
  assign t2 = ~(A[1]);
  assign t3 = ~(B[0]);
  assign t4 = ~(A[0]);
  assign W = ((A[1] & t1) | (~(A[1] ^ B[1])&(A[0] & t3))) ;
  assign X = (~(A[1] ^ B[1]) & ~(A[0] ^ B[0]));
  assign Y = ((t2 & B[1]) | (~(A[1] ^ B[1])&(t4 & B[0]))) ;
endmodule

module bit_comperator_tb();
  reg [1:0]A,B;
  wire W,X,Y;
  bit_comperator uut(A,B,W,X,Y);
  initial
  begin
    A=2'b00; B=2'b00; 
    #10
    A=2'b00; B=2'b01; 
    #10
    A=2'b00; B=2'b10; 
    #10
    A=2'b00; B=2'b11; 
    #10

    A=2'b01; B=2'b00; 
    #10
    A=2'b01; B=2'b01; 
    #10
    A=2'b01; B=2'b10; 
    #10
    A=2'b01; B=2'b11; 
    #10

    A=2'b10; B=2'b00; 
    #10
    A=2'b10; B=2'b01; 
    #10
    A=2'b10; B=2'b10; 
    #10
    A=2'b10; B=2'b11; 
    #10

    A=2'b11; B=2'b00; 
    #10
    A=2'b11; B=2'b01; 
    #10
    A=2'b11; B=2'b10; 
    #10
    A=2'b11; B=2'b11; 
    #10
    $finish;
    end 
  endmodule