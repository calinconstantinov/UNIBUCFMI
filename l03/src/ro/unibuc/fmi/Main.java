package ro.unibuc.fmi;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Base base = new Base(5);
        System.out.println(base.getVal());

        SecondLevelDerived derived = new SecondLevelDerived();

        AbstractBase abstractBase = new SecondAbstractBase();

        ImplementationClass implementationClass = new ImplementationClass();
        implementationClass.doSomethingElse();

        Base baseClass = new Base(2);
        Derived derivedClass = new Derived();
        SecondLevelDerived secondLevelDerivedClass = new SecondLevelDerived();

        Base[] bases = new Base[3];
        bases[0] = baseClass;
        bases[1] = derivedClass;
        bases[2] = secondLevelDerivedClass;

        List<Base> baseList = new LinkedList<>();
        baseList.add(baseClass);
        baseList.add(derivedClass);
        baseList.add(secondLevelDerivedClass);

        System.out.println(baseList.size());
    }
}
