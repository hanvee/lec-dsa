class Instrument {
    protected String name;
    protected String sound;
    
    public Instrument(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }
    
    public void play() {
        System.out.println(name + " goes " + sound);
    }
}

class Guitar extends Instrument {
    public Guitar() {
        super("Guitar", "strum strum");
    }
    
    public void tune() {
        System.out.println("Tuning guitar strings...");
    }
}

class Drums extends Instrument {
    public Drums() {
        super("Drums", "boom boom");
    }
    
    public void beat() {
        System.out.println("Beating the drums hard!");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Drums drums = new Drums();
        
        guitar.play();
        guitar.tune();
        
        drums.play();
        drums.beat();
    }
}
