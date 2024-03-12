package DesignPatterns;

interface WeightMachine {
    public double getWeightInPound();
}
interface WeightMachineAdapter {
    public double getWeightInKg();
}
class WeightMachineImpl implements WeightMachine {
    @Override
    public double getWeightInPound() {
        return 20;
    }
}
class WeightMachineAdapterImpl implements WeightMachineAdapter {
    private final WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

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
