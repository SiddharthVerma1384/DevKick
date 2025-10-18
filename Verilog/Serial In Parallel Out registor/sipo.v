module SIPO (
    input clk,
    input rst,
    input Din,
    output [3:0] Dout
);

    reg [3:0] q;

    always @(posedge clk or posedge rst) begin
        if (rst)
            q <= 4'b0000;
        else
            q <= {q[2:0], Din};
    end

    assign Dout = q; // Parallel output

endmodule


// Testbench
module SIPO_tb;
    reg clk, rst, Din;
    wire [3:0] Dout;

    SIPO uut (.clk(clk), .rst(rst), .Din(Din), .Dout(Dout));

    initial begin
        clk = 0;
        forever #10 clk = ~clk;
    end

    initial begin
        rst = 1; Din = 0;
        #20 rst = 0;
        #20 Din = 1;
        #20 Din = 0;
        #20 Din = 1;
        #20 Din = 1;
        #100 $finish;
    end
endmodule
