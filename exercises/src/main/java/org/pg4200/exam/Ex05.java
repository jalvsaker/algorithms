package org.pg4200.exam;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

import static java.lang.Integer.parseInt;

public class Ex05 {
    public byte[] compress(String input){
        BitWriter writer = new BitWriter();

        String[] inputArray = input.split("\n");

        for (String line : inputArray) {
            int i = 0;

            i = line.indexOf('-');
            writer.write(program(line.substring(0,i)),3);

            //Assume Course code matches program

            i += 3;

            writer.write(parseInt(line.substring(i, i+= 4)), 14);

            assert line.charAt(i) == ':';

            i++;

            //unique id
            writer.write(parseInt(line.substring(i, i+= 6)), 20);


            //Date
            writer.write(Integer.parseInt(line.substring(i+=3,i+=4)), 12);

            i++;

            writer.write(month(line.substring(i, i+=3)),4);

            i++;

            writer.write(parseInt(line.substring(i, i+=2)),5);

            //assume info in filename is the same as before
        }

        return writer.extract();
    }

    public String decompress(byte[] input){
        BitReader reader = new BitReader(input);

        int length = (input.length * 8)/53;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < length; i++) {
            String programAndCourseCode = program(reader.readInt(3))
                    + String.format("%04d", reader.readInt(14));

            output.append(programAndCourseCode);

            output.append(":");

            String uniqueId = String.format("%06d", reader.readInt(20));
            output.append(uniqueId);

            output.append(" / ");

            //Date
            output.append(String.format("%04d", reader.readInt(12)));
            output.append("-");
            output.append(month(reader.readInt(4)));
            output.append("-");
            output.append(String.format("%02d", reader.readInt(5)));

            //File
            output.append(". File: feedback-");
            output.append(programAndCourseCode.substring(programAndCourseCode.length() - 6));
            output.append("-");
            output.append(uniqueId);
            output.append(".pdf");

            output.append(";\n");
        }

        return output.toString();
    }

    private int program(String name){
        switch (name){
            case "Programming": return 0;
            case "ArtificialIntelligence": return 1;
            case "FrontendProgramming": return 2;
            case "Cybersecurity": return 3;
            case "DataScience": return 4;
        }
        throw new IllegalArgumentException(name);
    }

    private String program(int number){
        switch (number){
            case 0: return "Programming-PG";
            case 1: return "ArtificialIntelligence-AI";
            case 2: return "FrontendProgramming-FP";
            case 3: return "Cybersecurity-SC";
            case 4: return "DataScience-DS";
        }
        throw new IllegalArgumentException(String.valueOf(number));
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
        throw new IllegalArgumentException(code);
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

        throw new IllegalArgumentException(String.valueOf(number));
    }
}
