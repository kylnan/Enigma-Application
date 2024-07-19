public class Rotor {
    private String wiring;  // rotor sets I-V
    private int position;   // gives current index/position of the rotor
    private int notch;      // The notch position that sets off the next rotor found on https://en.wikipedia.org/wiki/Enigma_machine#Rotors

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

    /*
        - The input character needs to be adjusted by the rotor's current position.
        - meaning this shifts the character forward in the alphabet by the number of positions the rotor has advanced
        - the adjusted character is then substituted using the rotor's wiring
     */


    public char encodeForward(char input){
        // convert input character to index and adjust for rotor position
        int index = (input - 'A' + position) % 26;

        // Substitute using wiring;
        char substitute = wiring.charAt(index);

        //Adjust back for rotor position
        int substituteIndex = (substitute - 'A' - position + 26) % 26;
        return (char)(substituteIndex + 'A');
    }

    public char encodeBackward(char input){
        // convert input character to index and adjust for rotor position
        int index = (input - 'A' + position) % 26;

        int wiringIndex = (wiring.indexOf((char) (index + 'A')));

        // Adjust back for rotor position
        int outputIndex = (wiringIndex - position + 26) % 26;
        return (char)(outputIndex + 'A');
    }

    public int getPosition(){
        return this.position;
    }

    public boolean atNotch(){
        return position == this.notch;
    }
}
