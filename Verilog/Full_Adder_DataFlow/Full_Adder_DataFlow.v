module full_adder(input a,b,c, output sum,carry);
  assign sum = a ^ b ^ c;
  assign carry = (a & b) | (b & c) | (c & a);
endmodule 

module full_adder_tb();
  reg a,b,c;
  wire sum,carry;
  full_adder uut(a,b,c,sum,carry);
  initial
  begin
  a = 0;b = 0;c = 0;
  #10
  a = 0;b = 0;c = 1;
  #10
  a = 0;b = 1;c = 0;
  #10
  a = 0;b = 1;c = 1;
  #10
  a = 1;b = 0;c = 0;
  #10
  a = 1;b = 0;c = 1;
  #10
  a = 1;b = 1;c = 0;
  #10
  a = 1;b = 1;c = 1;
  
end
endmodule