package com.bichel.java.interfaceclass;

@FunctionalInterface
public interface Greeting {
    void greet();
}

class HindiGreeting implements Greeting {

    // Overriding the greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Namaste");
    }
}

class EnglishGreeting implements Greeting {

    // Overriding the greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Good Morning");
    }
}

class WellWisherWithLambda {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    // Passing a lambda expression to wish method.
    public static void main(String args[]) {
        wish( () -> System.out.println("Namaste") );
    }
}

class WellWisherOOP {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        Greeting hindiGreeting = new HindiGreeting();
        wish(hindiGreeting);  // Passing an object of HindiGreeting.

        Greeting englishGreeting = new EnglishGreeting();
        wish(englishGreeting);  // Passing an object of EnglishGreeting.
    }
}
