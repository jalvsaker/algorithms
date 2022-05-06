package org.pg4200.ex11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

public class ChessCompressor extends GenericCompressor{
    @Override
    public byte[] compress(String input) {
        BitWriter writer = new BitWriter();

        for (int i = 0; i < input.length(); i++) {

            boolean stop = false;
            String number = "";

            while (!stop){
                if (Character.isDigit(input.charAt(i))){
                    number += input.charAt(i);
                    i++;
                } else {
                    stop = true;
                }
            }

            writer.write(Integer.parseInt(number),9);

            writer.write(piece(input.charAt(i)),3);
            i++;

            compressSquare(String.valueOf(input.charAt(i)) + input.charAt(i + 1), writer);

            i += 2;

            compressSquare(String.valueOf(input.charAt(i)) + input.charAt(i + 1), writer);
            i += 2;



                if (i < input.length() && input.charAt(i) == '!'){
                    writer.write(true);
                } else {
                    writer.write(false);
                    i -= 1;
                }
        }


        return writer.extract();
    }

    private void compressSquare(String square, BitWriter writer){
        assert square.length() == 2;

        int row = square.charAt(0) - 'a';

        int colum = square.charAt(1) - 1;

        writer.write(row, 3);
        writer.write(colum, 3);
    }

    private int piece(char character){
        switch (character){
            case 'p': return 0;
            case 'r': return 1;
            case 'n': return 2;
            case 'b': return 3;
            case 'q': return 4;
            case 'k': return 5;
        }

        throw new IllegalArgumentException(String.valueOf(character));
    }

    private char piece(int numb){
        switch (numb){
            case 0: return 'p';
            case 1: return 'r';
            case 2: return 'n';
            case 3: return 'b';
            case 4: return 'q';
            case 5: return 'k';
        }

        throw new IllegalArgumentException(String.valueOf(numb));
    }

    @Override
    public String decompress(byte[] input) {
        BitReader reader = new BitReader(input);

        StringBuilder output = new StringBuilder();

        int length = (input.length * 8)/25;

        for (int i = 0; i < length; i++) {
            output.append(reader.readInt(9));

            output.append(piece(reader.readInt(3)));

            output.append(decompressSquare(reader));
            output.append(decompressSquare(reader));

            if (reader.readBoolean()) output.append("!");
        }

        return output.toString();
    }

    private String decompressSquare(BitReader reader){
        char row = (char) (reader.readInt(3) + 'a');

        int colum = reader.readInt(3) + 1;

        return "" + row + colum;
    }
}