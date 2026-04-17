import java.util.*;

interface SmartDevice {
    void turnOn();
    void turnOff();
    String getStatus();
}

class SmartLight implements SmartDevice {
    String name;
    boolean isOn;

    SmartLight(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Light '" + name + "' is ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Light '" + name + "' is OFF.");
    }

    public String getStatus() {
        return "Light '" + name + "': " + (isOn ? "ON" : "OFF");
    }
}

class SmartThermostat implements SmartDevice {
    String name;
    int temperature;
    boolean isOn;

    SmartThermostat(String name, int temperature) {
        this.name = name;
        this.temperature = temperature;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Thermostat '" + name + "' is ON. Temp set to " + temperature + "°C.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Thermostat '" + name + "' is OFF.");
    }

    public String getStatus() {
        return "Thermostat '" + name + "': " + (isOn ? "ON" : "OFF") + ", Temp: " + temperature + "°C";
    }
}

class SmartFan implements SmartDevice {
    String name;
    int speed;
    boolean isOn;

    SmartFan(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Fan '" + name + "' is ON. Speed set to " + speed + ".");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Fan '" + name + "' is OFF.");
    }

    public String getStatus() {
        return "Fan '" + name + "': " + (isOn ? "ON" : "OFF") + ", Speed: " + speed;
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        List<SmartDevice> devices = new ArrayList<>();

        System.out.print("Enter Smart Light name: ");
        String lightName = S.nextLine();
        devices.add(new SmartLight(lightName));

        System.out.print("Enter Smart Thermostat name: ");
        String thermoName = S.nextLine();
        System.out.print("Enter initial temperature: ");
        int temp = S.nextInt();
        S.nextLine();
        devices.add(new SmartThermostat(thermoName, temp));

        System.out.print("Enter Smart Fan name: ");
        String fanName = S.nextLine();
        System.out.print("Enter fan speed (1-5): ");
        int speed = S.nextInt();
        S.nextLine();
        devices.add(new SmartFan(fanName, speed));

        System.out.println("\n--- Turning all devices ON ---");
        for (SmartDevice d : devices) d.turnOn();

        System.out.println("\n--- Turning all devices OFF ---");
        for (SmartDevice d : devices) d.turnOff();

        System.out.println("\n--- Device Status ---");
        for (SmartDevice d : devices) System.out.println(d.getStatus());

        S.close();
    }
}