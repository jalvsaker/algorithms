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

            writer.write(archive(inputArray[i+2]),3);

            writer.write(parseInt(inputArray[i+3]), 4);

            writer.write(parseInt(inputArray[i+4]), 11);

            writer.write(parseInt(inputArray[i+5]), 12);

            i+=5;
        }

        return writer.extract();
    }
    private int month(String code){
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
        throw new IllegalArgumentException();
    }

    private String month(int number){
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

        throw new IllegalArgumentException();
    }

    private int archive(String code){
        switch (code){
            case "NAT": return 0;
            case "OSL": return 1;
            case "BER": return 2;
            case "KRS": return 3;
            case "TRO": return 4;
            case "TRM": return 5;
            case "MAR": return 6;
        }
        throw new IllegalArgumentException();
    }
    private String[] archive(int number){
        switch (number){
            case 0: return new String[]{"NAT", "NationalArchive"};
            case 1: return new String[]{"OSL", "OsloArchive"};
            case 2: return new String[]{"BER", "BergenArchive"};
            case 3: return new String[]{"KRS", "KristiansandArchive"};
            case 4: return new String[]{"TRO", "TrondheimArchive"};
            case 5: return new String[]{"TRM", "TromsoArchive"};
            case 6: return new String[]{"MAR", "MaritimeArchive"};
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String decompress(byte[] input) {
        BitReader reader = new BitReader(input);

        int length = (input.length * 8)/51; //239 -> 96

        StringBuilder out = new StringBuilder();

        for (int j = 0; j < length; j++) {
            out.append(String.format("%04d", reader.readInt(12)));

            out.append("-");

            out.append(month(reader.readInt(4)));

            out.append("-");

            out.append(String.format("%02d", reader.readInt(5)));

            out.append("; ");

            String[] archive = archive(reader.readInt(3));

            out.append(archive[1]).append("; ");

            out.append(archive[0]).append("; ");

            out.append(String.format("%02d", reader.readInt(4))).append("; ");

            out.append(String.format("%03d", reader.readInt(11))).append("; ");
            out.append(String.format("%04d", reader.readInt(12))).append(";\n");
        }

        return out.toString();
    }
}
