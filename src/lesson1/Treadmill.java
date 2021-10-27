package lesson1;

public class Treadmill extends Task {
    static int range;
    public Treadmill(int range){
        this.range = range;
    }
    public double getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;

    }
}
