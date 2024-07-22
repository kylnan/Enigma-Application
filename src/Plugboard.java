import java.util.HashMap;

public class Plugboard {
    private final HashMap<Character, Character> settings = new HashMap<>();

    public Plugboard(String wires) {
        String[] pairs = wires.split(" ");
        for (String pair : pairs) {
            if (pair.isEmpty()) {
                break;
            }
            char a = pair.charAt(0);
            char b = pair.charAt(1);
            settings.put(a, b);
            settings.put(b, a);
        }
    }

    public char encode(char input) {
        return settings.getOrDefault(input, input);
    }
}
