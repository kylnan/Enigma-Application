public class Rotor {
    private String wiring; // rotor sets I-V
    private int position; // gives current index/position of the rotor
    private int notch; // The notch position that sets off the next rotor found on https://en.wikipedia.org/wiki/Enigma_machine#Rotors

    // Constructor
    public Rotor(String wiring, int position, int notch) {
        this.wiring = wiring;
        this.position = 0; // setting default position to 0
        this.notch = notch;
    }

    // set initial position of the rotor
    public void setPosition(int position) {
        this.position = position;
    }

    // step through the rotor
    public void step(){
        this.position = (this.position + 1) % 26;
    }

    public char encodeForward(char input){

    }

    public char encodeBackward(char input){

    }

    public int getPosition(){
        return this.position;
    }

    public boolean atNotch(){
        return position == this.notch;
    }
}
