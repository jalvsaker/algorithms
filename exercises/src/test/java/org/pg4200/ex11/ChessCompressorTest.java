package org.pg4200.ex11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChessCompressorTest {

    @Test
    void test1(){
        test("1pc2c32pd7d63qd1a4!4pb7b5");
    }

    @Test
    void test2(){
        test("1pf2f32pe7e53pg2g44qd8h4!");
    }

    void test(String input){

        ChessCompressor cc = new ChessCompressor();

        byte[] comp = cc.compress(input);

        String output = cc.decompress(comp);

        assertEquals(input, output);
    }

}
