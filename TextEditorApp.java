import java.util.HashMap;
class Character {
    private final char value;
    private final String font;
    private final int size;
    public Character(char value, String font, int size) {
        this.value = value;
        this.font = font;
        this.size = size;
    }
    public char getValue() {
        return value;
    }
    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }
}
class CharacterFactory {
    private final HashMap<Character, Character> characters = new HashMap<>();
    public Character getCharacter(char value, String font, int size) {
        Character character = new Character(value, font, size);
        if (!characters.containsKey(character)) {
            characters.put(character, character);
        }
        return characters.get(character);
    }
}
class TextEditor {
    private final CharacterFactory characterFactory;
    private final StringBuilder text;
    public TextEditor() {
        characterFactory = new CharacterFactory();
        text = new StringBuilder();
    }
    public void insertCharacter(char value, String font, int size) {
        Character character = characterFactory.getCharacter(value, font, size);
        text.append(character.getValue());
    }
    public void render() {
        System.out.println("Rendering text: " + text.toString());
    }
}
public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.insertCharacter('H', "Arial", 12);
        editor.insertCharacter('e', "Arial", 12);
        editor.insertCharacter('l', "Arial", 12);
        editor.insertCharacter('l', "Arial", 12);
        editor.insertCharacter('o', "Arial", 12);
        editor.render();
    }
}
