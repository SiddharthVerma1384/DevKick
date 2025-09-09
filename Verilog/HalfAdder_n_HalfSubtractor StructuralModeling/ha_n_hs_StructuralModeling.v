module ha_n_hs_StructuralModeling(input a,b, output sum,carry,diff,borrow);
  wire w1;
  xor(sum,a,b);
  xor(diff,a,b);
  not(w1,a);
  and(carry,a,b);
  and(borrow,w1,b);
endmodule

module ha_n_hs_StructuralModeling_tb();
  reg a,b;
  wire sum,carry,diff,borrow;
  ha_n_hs_StructuralModeling uut(a,b,sum,carry,diff,borrow);
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