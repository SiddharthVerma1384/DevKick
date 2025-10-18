module t_ff(clk, rst, t, q);
    input clk, rst, t;
    output reg q;

    always @(posedge clk or posedge rst)
    begin
        if (rst)
            q <= 0;
        else if (t == 0)
            q <= q;
        else
            q <= ~q;
    end
endmodule
module tb_tff();
    reg clk, rst, t;
    wire q;

    // Instantiate the T Flip-Flop
    t_ff uut (.clk(clk), .rst(rst), .t(t), .q(q));

    // Clock generation
    initial begin
        clk = 0; // Initialize clk to 0
        forever #10 clk = ~clk; // Toggle clock every 10 time units
    end

    // Test sequence
    initial begin
        // Initialize inputs
        rst = 1; t = 0;
        #10 rst = 0; // Release reset

        // Now apply test cases
        #10 t = 1;
        #20 t = 0;
        #20 t = 1;
        #10 rst = 1; // Apply reset again
        #10 rst = 0; t = 1;
        #30 $stop;
    end
endmodule