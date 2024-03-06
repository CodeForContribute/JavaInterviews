interface Car{
    public int topSpeed();
}

interface AbstractFactory{
    public Car getInstance(int price);
}
enum FactoryType{
    ECONOMIC,
    LUXURY
}

class AbstractFactoryProducer{
    public AbstractFactory getFactoryInstance(FactoryType factoryType){
        switch (factoryType){
            case ECONOMIC:
                return new EconomicCarFactory();
            case LUXURY:
                return new LuxuryCarFactory();
        }
        return null;
    }
}
class EconomicCarFactory implements AbstractFactory{
    @Override
    public Car getInstance(int price) {
        if (price <= 200000){
            return new EconomicCar1();
        }else if (price > 200000){
            return new EconomicCar2();
        }
        return null;
    }
}

class LuxuryCarFactory implements AbstractFactory{
    @Override
    public Car getInstance(int price) {
        if (price <= 20000000){
            return new LuxuryCar1();
        }else if (price > 20000000){
            return new LuxuryCar2();
        }
        return null;
    }
}
class LuxuryCar1 implements Car{
    @Override
    public int topSpeed() {
        return 220;
    }
}
class LuxuryCar2 implements Car{
    @Override
    public int topSpeed() {
        return 240;
    }
}

class EconomicCar1 implements Car{
    @Override
    public int topSpeed() {
        return 40;
    }
}

class EconomicCar2 implements Car{
    @Override
    public int topSpeed() {
        return 50;
    }
}
public class AbstractFactoryClientDemo {
    /*
    * It is a factory of a factory
    * */
    public static void main(String[] args) {
        AbstractFactoryProducer abstractFactoryProducer = new AbstractFactoryProducer();
        EconomicCarFactory economicCarFactory = (EconomicCarFactory) abstractFactoryProducer.getFactoryInstance(FactoryType.ECONOMIC);
        LuxuryCarFactory luxuryCarFactory = (LuxuryCarFactory) abstractFactoryProducer.getFactoryInstance(FactoryType.LUXURY);
        Car economicCar = economicCarFactory.getInstance(10000);
        Car luxaryCar = luxuryCarFactory.getInstance(30000);
        System.out.println(economicCar.topSpeed());
        System.out.println(luxaryCar.topSpeed());

    }
}
