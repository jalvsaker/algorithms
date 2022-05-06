package org.pg4200.ex11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArchiveCompressorTest {
    @Test
    void test(){
        ArchiveCompressor ac = new ArchiveCompressor();

        String input = "1805-OCT-21; MaritimeArchive; MAR; 03; 126; 1111;\n" +
                "1805-DEC-02; NationalArchive; NAT; 07; 084; 1780;\n" +
                "1805-OCT-21; MaritimeArchive; MAR; 03; 126; 1111;\n" +
                "1814-MAY-17; NationalArchive; NAT; 01; 001; 0001;\n" +
                "1905-JUN-07; NationalArchive; NAT; 02; 042; 0042;\n";

        byte[] test = ac.compress(input);

        System.out.println(test.length);

        String dc = ac.decompress(test);

        Assertions.assertEquals(input, dc);
    }
}
