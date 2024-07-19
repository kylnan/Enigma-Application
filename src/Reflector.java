public class Reflector {
    private String wiring;
    // The reflector should encode similarly to the rotors it just doesn't have the step functionality
    public Reflector(String wiring) {
        this.wiring = wiring;
    }

    public char encodeForward(char input){
        // convert input character to index
        int index = (input - 'A') % 26;

        // Substitute using wiring;
        char substitute = wiring.charAt(index);

        return substitute;
    }

    public char encodeBackward(char input){
        // convert input character to index
        int index = (input - 'A') % 26;

        // Find index of the character in the wiring
        int wiringIndex = (wiring.indexOf((char) (index + 'A')));

        return (char)(wiringIndex + 'A');
    }
}
