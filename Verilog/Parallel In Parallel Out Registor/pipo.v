module PIPO (
    input clk,
    input rst,
    input [3:0] Din,
    output reg [3:0] Dout
);

    always @(posedge clk or posedge rst) begin
        if (rst)
            Dout <= 4'b0000;
        else
            Dout <= Din; // Load parallel input directly
    end

endmodule


// Testbench
module PIPO_tb;
    reg clk, rst;
    reg [3:0] Din;
    wire [3:0] Dout;

    PIPO uut (.clk(clk), .rst(rst), .Din(Din), .Dout(Dout));

    initial begin
        clk = 0;
        forever #10 clk = ~clk;
    end

    initial begin
        rst = 1; Din = 4'b0000;
        #20 rst = 0;
        #20 Din = 4'b1010;
        #20 Din = 4'b1111;
        #20 Din = 4'b0101;
        #100 $finish;
    end
endmodule
