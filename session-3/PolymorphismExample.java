class Transportation {
    protected String name;
    
    public Transportation(String name) {
        this.name = name;
    }
    
    public void move() {
        System.out.println(name + " sedang bergerak");
    }
}

// Bus
class Bus extends Transportation {
    public Bus(String name) {
        super(name);
    }
    
    @Override
    public void move() {
        System.out.println(name + " mulai berjalan di jalan raya");
    }
}

// Train
class Train extends Transportation {
    public Train(String name) {
        super(name);
    }
    
    @Override
    public void move() {
        System.out.println(name + " melaju cepat di atas rel kereta api");
    }
}


public class PolymorphismExample {
    public static void main(String[] args) {
        Transportation bus = new Bus("Bus A");
        Transportation train = new Train("Kereta B");

        bus.move();

        train.move();
    }
}
