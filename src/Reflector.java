public class Reflector {
    private final String wiring;
    // The reflector should encode similarly to the rotors it just doesn't have the step functionality
    public Reflector(String wiring) {
        this.wiring = wiring;
    }

    public char encode(char input){
        int index = ((input) - 'A') % 26;
       return wiring.charAt(index);
    }
}
