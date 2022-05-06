package org.pg4200.ex11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

import static java.lang.Integer.parseInt;

public class ArchiveCompressor extends GenericCompressor {
    @Override
    public byte[] compress(String input) {
        BitWriter writer = new BitWriter();

        String[] inputArray = input.split(";(\\n)? ?");

        for (int i = 0; i < inputArray.length; i++) {
            String[] date = inputArray[i].split("-");

            writer.write(parseInt(date[0]),12);

            writer.write(month(date[1]),4);

            writer.write(parseInt(date[2]), 5);

            writer.write(inputArray[i+2]);

            writer.write(parseInt(inputArray[i+3]), 4);

            writer.write(parseInt(inputArray[i+4]), 11);

            writer.write(parseInt(inputArray[i+5]), 12);

            i+=5;
        }

        return writer.extract();
    }

    int month(String code){
        switch (code){
            case "JAN": return 1;
            case "FEB": return 2;
            case "MAR": return 3;
            case "APR": return 4;
            case "MAY": return 5;
            case "JUN": return 6;
            case "JUL": return 7;
            case "AUG": return 8;
            case "SEP": return 9;
            case "OCT": return 10;
            case "NOV": return 11;
            case "DEC": return 12;
        }
        return 0;
    }

    String month(int number){
        switch (number){
            case 1: return "JAN";
            case 2: return "FEB";
            case 3: return "MAR";
            case 4: return "APR";
            case 5: return "MAY";
            case 6: return "JUN";
            case 7: return "JUL";
            case 8: return "AUG";
            case 9: return "SEP";
            case 10: return "OCT";
            case 11: return "NOV";
            case 12: return "DEC";
        }

        return null;
    }

    @Override
    public String decompress(byte[] input) {
        BitReader reader = new BitReader(input);

        int length = (input.length * 8)/96; //239 -> 96

        String out = "";

        for (int j = 0; j < length; j++) {
            out += String.format("%04d", reader.readInt(12));

            out += "-";

            out+= month(reader.readInt(4));

            out += "-";

            out += String.format("%02d", reader.readInt(5));

            out += "; ";

            String code = "";

            for (int i = 0; i < 3; i++) {
                code += reader.readChar();
            }

            switch (code){
                case "MAR":
                    out += "MaritimeArchive; ";
                    break;
                case "NAT" :
                    out += "NationalArchive; ";
                    break;
            }

            out += code+"; ";

            out += String.format("%02d", reader.readInt(4)) + "; ";

            out += String.format("%03d", reader.readInt(11)) + "; ";
            out += String.format("%04d", reader.readInt(12)) + ";\n";
        }

        return out;
    }
}
