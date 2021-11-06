package com.timbuchalka;

public class Main {

    public static void main(String[] args) {

        Animal dog = new Dog("Yorkie");
//        dog.breathe();
        dog.eat();
        System.out.println(dog.getName());
        ((Dog) dog).neueMethode();

        Parrot parrot = new Parrot("Australian ringneck");
//        parrot.breathe();
//        parrot.eat();
//        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
//        penguin.fly();
        Animal[] animals = {dog, parrot, penguin};
        animals[0].breathe();
        animals[1].eat();
        penguin.fly();
    }
}
