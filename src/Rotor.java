public class Rotor {
    private final String wiring;  // rotor sets I-V
    private int position;   // gives current index/position of the rotor
    private final int notch;      // The notch position that sets off the next rotor found on https://en.wikipedia.org/wiki/Enigma_machine#Rotors
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Constructor
    public Rotor(String wiring, char notch) {
        this.wiring = wiring;
        this.position = 0; // setting default position to 0
        this.notch = notch - 'A';
    }

    // set initial position of the rotor
    public void setPosition(int position) {
        if (position < 0 || position > 25){
            throw new IllegalArgumentException("Position must be between 0 and 25");
        }
        this.position = position;
    }

    // step through the rotor
    public void step(){
        this.position = (this.position + 1) % 26;
    }

    public char encodeForward(char input){
        // convert the input character to an index in the alphabet with respect to position
        int index = (input - 'A' + position) % 26;
        // find where input character is mapped to in wiring
        char substitute = wiring.charAt(index);
        // Find substitute in alphabet and rotate rotor back to 0
        int substituteIndex = (substitute - 'A' - position + 26) % 26;
        return alphabet.charAt(substituteIndex);
    }

    public char encodeBackward(char input){
        int index = (input - 'A' + position) % 26;
        int wiringIndex = (wiring.indexOf((char) (index + 'A')));
        int outputIndex = (wiringIndex - position + 26) % 26;
        return alphabet.charAt(outputIndex);
    }


    public int getPosition(){
        return this.position;
    }

    public boolean atNotch(){
        return position == this.notch;
    }
}
