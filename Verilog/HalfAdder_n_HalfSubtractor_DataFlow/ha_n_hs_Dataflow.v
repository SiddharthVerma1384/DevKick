module combinational_ckt(input a,b, output sum,carry,diff,borrow);
  assign sum = a^b;
  assign diff = a^b;
  assign carry = a&b;
  assign borrow = ~a&b;
endmodule

module combinational_ckt_tb();
reg a,b;
wire sum,carry,diff,borrow;  
combinational_ckt uut(a,b,sum,carry,diff,borrow);
initial 
begin
  a=0;b=0;
  #100
  a=0;b=1;
  #100
  a=1;b=0;
  #100
  a=1;b=1;
end
endmodule