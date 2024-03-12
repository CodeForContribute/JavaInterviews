package DesignPatterns;

import java.util.HashMap;
import java.util.Map;

interface ILetter {
    public void display(int row, int col);
}

class LetterFactory {
    private static final Map<Character, ILetter> characterCache
            = new HashMap<>();

    public static ILetter createLetter(char characterValue) {
        if (characterCache.containsKey(characterValue)) {
            return characterCache.get(characterValue);
        } else {
            DocumentCharacter characterObj = new DocumentCharacter(characterValue,
                    "ARIAL", 20);
            characterCache.put(characterValue, characterObj);
            return characterObj;
        }
    }
}

class DocumentCharacter implements ILetter {
    private char character;
    private String fontType;
    private int size;

    public DocumentCharacter(char character, String fontType, int size) {
        this.character = character;
        this.fontType = fontType;
        this.size = size;
    }

    @Override
    public void display(int row, int col) {
        // display the character of particular font and size
        // at given location
    }
}

public class WordProcessorFlyWeight {
    public static void main(String[] args) {
        ILetter ob1 = LetterFactory.createLetter('t');
        ob1.display(0, 0);
        ILetter ob2 = LetterFactory.createLetter('m');
        ob2.display(0, 8);
    }
}
