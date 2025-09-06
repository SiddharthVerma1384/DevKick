module ha(input a,b, output sum,carry);
  assign sum = a^b;
  assign carry = a&b;
endmodule

module full_adder(input a,b,c, output sum1,carry1);
  wire s1,c1,c2;
  ha ha_1(.a(a), .b(b), .sum(s1), .carry(c1));
  ha ha_2(.a(s1), .b(c), .sum(sum1), .carry(c2));
  assign carry1 = c1 | c2;
endmodule

module full_adder_tb();
  reg a,b,c;
  wire sum1,carry1;
  full_adder uut(a,b,c,sum1,carry1);
  initial
  begin
    a=0;b=0;c=0;
    #10
    a=0;b=0;c=1;
    #10
    a=0;b=1;c=0;
    #10
    a=0;b=1;c=1;
    #10
    a=1;b=0;c=0;
    #10
    a=1;b=0;c=1;
    #10
    a=1;b=1;c=0;
    #10
    a=1;b=1;c=1;
    #10
    $finish;
  end
endmodule    