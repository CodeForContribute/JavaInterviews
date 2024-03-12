package DesignPatterns;

import java.util.HashMap;
import java.util.Map;

enum RobotType {
    HUMANOID,
    ROBOTIC_DOG
}

interface IRobot {
    public void display(int a, int b);
}

class Sprites {

}

class RoboticFactory {
    private static Map<RobotType, IRobot> roboticCache =
            new HashMap<>();

    public static IRobot createRobot(RobotType robotType) {
        if (roboticCache.containsKey(robotType)) {
            return roboticCache.get(robotType);
        } else {
            if (robotType == RobotType.HUMANOID) {
                Sprites humanoidSprite = new Sprites();
                IRobot humanoidObject = new HumanoidRobot(robotType, humanoidSprite);
                roboticCache.put(robotType, humanoidObject);
                return humanoidObject;
            } else if (robotType == RobotType.ROBOTIC_DOG) {
                Sprites roboticDogSprite = new Sprites();
                IRobot roboticDogObject = new RoboticDog(robotType, roboticDogSprite);
                roboticCache.put(robotType, roboticDogObject);
                return roboticDogObject;
            }
            return null;
        }
    }
}

class RoboticDog implements IRobot {
    private RobotType type;
    // small 2d bitmap(graphic element)
    private Sprites body;

    public RoboticDog(RobotType type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    public RobotType getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }

    @Override
    public void display(int a, int b) {
        // use the robotic dog sprites object
        // and a and b co-ordinate to render
        // the image
    }
}

class HumanoidRobot implements IRobot {
    private RobotType type;
    private Sprites body;

    public HumanoidRobot(RobotType type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    public RobotType getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }

    @Override
    public void display(int a, int b) {
        // use the humanoid sprites object
        // and a and b co-ordinate to render the image
    }
}

public class FlyWeightDesignPattern {
    public static void main(String[] args) {
        IRobot humanoidRobot1 = RoboticFactory.createRobot(RobotType.HUMANOID);
        humanoidRobot1.display(1, 3);
        IRobot humanoidRobot2 = RoboticFactory.createRobot(RobotType.HUMANOID);
        humanoidRobot2.display(3, 1);

        IRobot robotDog1 = RoboticFactory.createRobot(RobotType.ROBOTIC_DOG);
        robotDog1.display(2, 9);
        IRobot robotDog2 = RoboticFactory.createRobot(RobotType.ROBOTIC_DOG);
        robotDog2.display(23, 12);
    }
}
