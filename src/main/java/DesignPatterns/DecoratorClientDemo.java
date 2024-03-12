package DesignPatterns;

abstract class BasePizza{
    public abstract int cost();
}

class FarmHouse extends BasePizza{
    @Override
    public int cost() {
        return 200;
    }
}
class Margherita extends BasePizza{
    @Override
    public int cost() {
        return 100;
    }
}
class VegDelight extends BasePizza{

    @Override
    public int cost() {
        return 120;
    }
}

abstract class Toppings extends BasePizza{
}

class ExtraCheese extends Toppings{
    private final BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}

class Mushroom extends Toppings{
    private final BasePizza basePizza;

    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 30;
    }
}

public class DecoratorClientDemo {
    /*
    * 1. Nested decoration of a base object
    * e.g, Pizza , coffee -
    * Need - to avoid class explosion
    * as for different toppings/features, if we extend the base class, there will be lot of classes - class explosions
    * in normal case we have to extend the base class and create the classes/objects
    * which will lead to huge class also named as class explosions.
    * */
    public static void main(String[] args) {
        BasePizza basePizza = new Margherita();
        BasePizza basePizza2 = new FarmHouse();
        Toppings extraCheese = new ExtraCheese(basePizza);
        System.out.println(" Margherita with extra Cheese Cost : " + extraCheese.cost());
        Toppings mushroom = new Mushroom(basePizza2);
        System.out.println(" FarmHouse with extra Mushroom Cost : " + mushroom.cost());
        Toppings margheritaWithExtraCheeseAndMushrooms = new Mushroom(extraCheese);
        System.out.println(" margheritaWithExtraCheeseAndMushrooms : " + margheritaWithExtraCheeseAndMushrooms.cost());
    }
}
