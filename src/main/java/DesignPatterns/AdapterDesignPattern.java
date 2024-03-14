package DesignPatterns;

// adaptee
interface WeightMachine {
    public double getWeightInPound();
}
// adapter
interface WeightMachineAdapter {
    public double getWeightInKg();
}
// Concrete Adaptee
class WeightMachineImpl implements WeightMachine {
    @Override
    public double getWeightInPound() {
        return 20;
    }
}
// Concrete Adapter
class WeightMachineAdapterImpl implements WeightMachineAdapter {
    // Adapter has adaptee object
    private final WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    // adapter converts the adaptee logic op to expected client op.
    @Override
    public double getWeightInKg() {
        // convert it to KGs
        double weightInPound = this.weightMachine.getWeightInPound();
        return weightInPound * 0.45;
    }
}

public class AdapterDesignPattern {
    /*
     * It bridges between expected interface and existing interface
     * */
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter =
                new WeightMachineAdapterImpl(new WeightMachineImpl());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
