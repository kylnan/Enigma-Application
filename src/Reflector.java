public class Reflector {
    private final String wiring;
    // The reflector should encode similarly to the rotors it just doesn't have the step functionality
    public Reflector(String wiring) {
        this.wiring = wiring;
    }

    public char encodeForward(char input){
        // convert input character to index
        int index = (input - 'A') % 26;

        // Substitute using wiring;
       return wiring.charAt(index);
    }

    public char encodeBackward(char input){
        // convert input character to index
        int index = wiring.indexOf(input);

        return (char)(index + 'A');
    }
}
