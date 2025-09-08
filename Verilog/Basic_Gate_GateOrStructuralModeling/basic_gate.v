module basic_gate(input a,b , output Y1,Y2,Y3,Y4,Y5,Y6);
  and(Y1,a,b);
  or(Y2,a,b);
  not(Y3,a);
  not(Y4,b);
  nand(Y5,a,b);
  nor(Y6,a,b);
endmodule  