package org.pg4200.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex05Test {

    @Test
    void test(){
        Ex05 compressor = new Ex05();

        String data = "Programming-PG4200:456987 / 2022-JUN-06. File: feedback-PG4200-456987.pdf;\n" +
                "ArtificialIntelligence-AI1701:987456 / 2021-AUG-13. File: feedback-AI1701-987456.pdf;\n" +
                "FrontendProgramming-FP1453:963258 / 2022-OCT-30. File: feedback-FP1453-963258.pdf;\n" +
                "Cybersecurity-SC1007:741654 / 2022-JAN-05. File: feedback-SC1007-741654.pdf;\n" +
                "DataScience-DS0112:159753 / 2020-MAR-08. File: feedback-DS0112-159753.pdf;\n";

        byte[] test = compressor.compress(data);

        String decomp = compressor.decompress(test);

        assertEquals(data, decomp);
    }

}
