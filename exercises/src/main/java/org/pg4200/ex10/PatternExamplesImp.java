package org.pg4200.ex10;

public class PatternExamplesImp implements PatternExamples{
    /**
     * Any sequence of letters C, G, A and T.
     * (cytosine [C], guanine [G], adenine [A] or thymine [T])
     * Should be at least one value.
     */
    @Override
    public String dnaRegex() {
        return "[ACGT]+";
    }

    /**
     * 8 digit number.
     * Might be preceded by a country code, which
     * is either a + or 00 followed by 2 digits
     */
    @Override
    public String telephoneNumberRegex() {
        return "(((\\+)|(00))(47))?[0-9]{8}";
    }

    /**
     * An email is composed of, in order:
     * - a non-empty word (letters from a to z, upper and lower case, plus digits)
     * - followed by zero or more non-empty words, each one separated by a "."
     * - symbol @
     * - a non-empty word
     * - followed by zero or more non-empty words, each one separated by a "."
     * - a final domain code, which is at least 2 letters (upper or lower case), and no digits
     */
    @Override
    public String emailRegex() {
        return "([a-zA-Z0-9]\\.)?[a-zA-Z0-9]+@([a-zA-Z0-9]\\.)?[a-zA-Z0-9]+\\.[a-zA-Z]{2,}";
    }

    /**
     * Need match the following sentence:
     * <p>
     * Is this an out of season april fools joke?
     * <p>
     * However, the regex should be general enough to also match for further string variants following these properties:
     * a)	there can  be any number of spaces between the words
     * b)	each letter can be either in lower or upper case
     */
    @Override
    public String isItAJoke() {
        return "[iI][sS] +[tT][hH][iI][sS] +[aA][nN] +[oO][uU][tT] +" +
                "[oO][fF] +[sS][eE][aA][sS][oO][nN] +" +
                "[aA][pP][rR][iI][lL] +[fF][oO][oO][lL][sS] +[jJ][oO][kK][eE]\\?";
    }
}
