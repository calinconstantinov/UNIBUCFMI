package ro.unibuc.fmi;

public abstract class AbstractBase {

    protected int secondValue;

    public void addOne() {
        secondValue++;
    }

    public abstract void outputValue();
}