module hs(input a,b, output diff,borrow);
  assign diff = a^b;
  assign borrow = (~a)&b;
endmodule

module full_subtractor(input a,b,c, output diff1, borrow1);
  wire d1,b1,b2;
  hs hs1(.a(a), .b(b), .diff(d1), .borrow(b1));
  hs hs2(.a(d1), .b(c), .diff(diff1), .borrow(b2));
  assign borrow1 = b1|b2;
endmodule

module full_subtractor_tb();
  reg a,b,c;
  wire diff1,borrow1;
  full_subtractor uut(a,b,c,diff1,borrow1);
  initial 
  begin
    a=0; b=0; c=0; 
    #10
    a=0; b=0; c=1; 
    #10
    a=0; b=1; c=0; 
    #10
    a=0; b=1; c=1; 
    #10
    a=1; b=0; c=0; 
    #10
    a=1; b=0; c=1; 
    #10
    a=1; b=1; c=0; 
    #10
    a=1; b=1; c=1; 
    #10
    $finish;
  end
endmodule