package ro.unibuc.fmi;

public class ImplementationClass implements SecondInterface, ThirdInterface {

    @Override
    public void doSomethingElse() {
        System.out.println(SecondInterface.a);
        System.out.println(ThirdInterface.a);
    }

    @Override
    public void doSomething() {

    }
}
