package edu;

public class GameConsole implements Powered {
    private String brand;
    private String model;
    private String serial;
    private String firstGame_pad;
    private String secondGame_pad;
    private boolean isOn;

    public GameConsole(String brand, String serial) {
        this.brand = brand;
        this.serial = serial;
    }

    public GameConsole() {
    }

    @Override
    public void powerOn() {
        System.out.println(isOn = true);
    }

    @Override
    public void powerOf() {
        System.out.println(isOn = false);
    }

    class Gamepad implements Powered {
        private String brand;
        private String consoleSerial = serial;
        private String connectedNumber;
        private String color;
        public float chargeLevel = 100.0f;
        private boolean isOn;

        Gamepad(String brand, String connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            GameConsole console = new GameConsole();
            console.setFirstGame_pad("Joystick_1");
            console.setSecondGame_pad("Joystick_2");

        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public void setConsoleSerial(String consoleSerial) {
            this.consoleSerial = consoleSerial;
        }

        public String getConnectedNumber() {
            return connectedNumber;
        }

        public void setConnectedNumber(String connectedNumber) {
            this.connectedNumber = connectedNumber;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isOn() {
            return isOn;
        }

        public void setOn(boolean on) {
            isOn = on;
        }


        @Override
        public void powerOn() {
            if (Gamepad.this.isOn = true) {
                GameConsole.this.powerOn();
            }else {
                GameConsole.this.powerOf();
            }

        }

        @Override
        public void powerOf() {

            System.out.println(isOn = false);
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getFirstGame_pad() {
        return firstGame_pad;
    }

    public void setFirstGame_pad(String firstGame_pad) {
        this.firstGame_pad = firstGame_pad;
    }

    public String getSecondGame_pad() {
        return secondGame_pad;
    }

    public void setSecondGame_pad(String secondGame_pad) {
        this.secondGame_pad = secondGame_pad;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return "GameConsole{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", serial='" + serial + '\'' +
                ", firstGame_pad='" + firstGame_pad + '\'' +
                ", secondGame_pad='" + secondGame_pad + '\'' +
                ", isOn=" + isOn +
                '}';
    }
}
