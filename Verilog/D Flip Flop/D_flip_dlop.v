// D Flip-Flop Module
module d_ff (
    input clk,
    input d,
    input reset,
    output reg q,
    output qbar
);

    assign qbar = ~q;

    always @(posedge clk or negedge reset) begin
        if (!reset)
            q <= 1'b0;
        else
            q <= d;
    end
endmodule

// Testbench for D Flip-Flop
module tb_d_ff;

    reg clk;
    reg d;
    reg reset;
    wire q, qbar;

    // Instantiate D Flip-Flop
    d_ff uut (
        .clk(clk),
        .d(d),
        .reset(reset),
        .q(q),
        .qbar(qbar)
    );

    // Clock generation
    initial begin
        clk = 0;
        forever #5 clk = ~clk;
    end

    // Test sequence
    initial begin
        reset = 0; d = 0; #10;
        reset = 1; #10;

        d = 0; #10;
        d = 1; #10;
        d = 0; #10;
        d = 1; #10;
        d = 1; #10;

        reset = 0; #10;
        reset = 1; #10;

        #20;
    end
endmodule
