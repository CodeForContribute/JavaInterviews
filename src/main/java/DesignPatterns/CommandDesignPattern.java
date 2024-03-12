package DesignPatterns;

import java.util.Stack;

// Command
interface ICommand {
    public void execute();

    public void undo();
}

class Bulb {
    private boolean isOn;

    public void turnOnBulb() {
        this.isOn = true;
        System.out.println("Bulb is On!");
    }

    public void turnOffBulb() {
        this.isOn = false;
        System.out.println("Bulb is Off!");
    }
}

// Receiver
class AirConditioner {
    private boolean isOn;
    private int temperature;

    public void turnOnAc() {
        this.isOn = true;
        System.out.println("AC is On!");
    }

    public void turnOffAc() {
        this.isOn = false;
        System.out.println("AC is Off!");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperature changed to : " + temperature);
    }
}

class TurnACOnCommand implements ICommand {
    private AirConditioner ac;

    public TurnACOnCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        this.ac.turnOnAc();
    }

    @Override
    public void undo() {
        this.ac.turnOffAc();
    }
}

class TurnACOffCommand implements ICommand {
    private AirConditioner ac;

    public TurnACOffCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        this.ac.turnOffAc();
    }

    @Override
    public void undo() {
        this.ac.turnOnAc();
    }
}

// Invoker
class MyRemoteControl {
    private Stack<ICommand> acCommandHistory;
    private ICommand command;

    public MyRemoteControl() {
        this.acCommandHistory = new Stack<>();
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        this.command.execute();
        this.acCommandHistory.add(command);
    }

    public void undo() {
        if (!acCommandHistory.isEmpty()) {
            ICommand lastCommand = this.acCommandHistory.pop();
            lastCommand.undo();
        }
    }
}

public class CommandDesignPattern {
    /*
     * 1. It's a behavioral pattern
     * 2. It is used for provide abstraction
     * 3. To implement Undo/Redo functionality
     * 3. Difficulty in Code maintenance - to add more command for more devices
     * */
    public static void main(String[] args) {
//        AirConditioner ac = new AirConditioner();
//        ac.turnOnAc();
//        ac.setTemperature(24);
//        ac.turnOffAc();
//
//        Bulb bulb = new Bulb();
//        bulb.turnOnBulb();
//        bulb.turnOffBulb();

        // How command design pattern solves it ?
        // it separates the logic of
        // -Receiver, -Invoker and Command
        // AC object
        AirConditioner ac = new AirConditioner();
        // remote
        MyRemoteControl myRemoteControl = new MyRemoteControl();
        myRemoteControl.setCommand(new TurnACOnCommand(ac));
        // create the command and press the button
        myRemoteControl.pressButton();
        myRemoteControl.undo();
    }
}
