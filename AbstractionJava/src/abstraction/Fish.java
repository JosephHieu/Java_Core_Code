package abstraction;

public class Fish extends Animal {


    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {

        if (speed.equals("slow")) {
            System.out.print(super.getExplicitType() + " lazily swimming\n");
        } else {
            System.out.print(getExplicitType() + " darting frantically\n");
        }
    }

    @Override
    public void makeNoise() {

        if (type == "GoldFish") {
            System.out.print("swish! \n");
        } else {
            System.out.print("splash! \n");
        }
    }
}
