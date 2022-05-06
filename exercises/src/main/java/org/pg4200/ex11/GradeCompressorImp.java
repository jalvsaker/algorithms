package org.pg4200.ex11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class GradeCompressorImp implements GradeCompressor{
    /**
     * @param idsAndGrades string list in the form id:grade, eg, 0A1F2C
     * @return compressed bytes
     */
    @Override
    public byte[] compress(String idsAndGrades) {
        String id = "";
        BitWriter writer = new BitWriter();

        for (int i = 0; i < idsAndGrades.length(); i++) {
            if (Character.isDigit(idsAndGrades.charAt(i))){
                id += idsAndGrades.charAt(i);
            } else {
                writer.write(Integer.parseInt(id), 9);
                id = "";

                int grade = idsAndGrades.charAt(i) - 'A';
                writer.write(grade, 3);
            }
        }

        return writer.extract();
    }

    @Override
    public String decompress(byte[] data) {
        int length = (data.length * 8)/12;

        BitReader reader = new BitReader(data);

        String result = "";

        for (int i = 0; i < length; i++) {
            result += reader.readInt(9);

            result += (char) ('A' + reader.readInt(3));
        }

        return result;
    }
}
