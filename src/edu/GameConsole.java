package edu;

public class GameConsole extends MyException implements Powered {
    private final String brand;
    private String model;
    private final String serial;
    private final Gamepad firstGame_pad;
    private final Gamepad secondGame_pad;
    private boolean isOn;
    private Game activeGame;
    private int waitingCounter;

    public GameConsole(String brand, String serial) {
        this.brand = brand;
        this.serial = serial;
        firstGame_pad = new Gamepad(brand, 1);
        secondGame_pad = new Gamepad(brand, 2);
    }

    void loadGame(Game game) {
        activeGame = game;
        System.out.println("Игра " + game.getName() + " загружается");
    }

    void playGame() {
        if (!isOn) {
            System.out.println("Играем в " + activeGame.getName());
            Gamepad[] gamepads = {firstGame_pad, secondGame_pad};
            for (Gamepad gamepad : gamepads) {
                if (gamepad.chargeLevel == 0.0) {
                    gamepad.powerOff();
                    System.out.println("Game over");
                } else if (!gamepad.isOn) {
                    gamepad.chargeLevel -= 10f;
                    System.out.println("Заряд джойстика " + gamepad.connectedNumber + " " + gamepad.chargeLevel);
                }
            }
        }
        checkStatus();
    }

    private void checkStatus() {
        if (firstGame_pad.chargeLevel < 10.0 & secondGame_pad.chargeLevel < 10.0) {
            System.out.println("Подключите джойстик " + ++waitingCounter);
            try {
                if (waitingCounter > 5) throw new MyException();
                {
                    powerOff();
                }
            } catch (MyException ex) {
                System.err.println("Приставка завершает работу из-за отсутствия активности");
            }
        } else {
            System.out.println(waitingCounter = 0);
        }
    }


    @Override
    public void powerOn() {
        System.out.println(isOn = true);
    }

    @Override
    public void powerOff() {
        System.out.println(isOn = false);
    }


    class Gamepad implements Powered {
        private final String brand;
        private final String consoleSerial;
        private int connectedNumber;
        private String color;
        public float chargeLevel = 100.0f;
        private boolean isOn;


        Gamepad(String brand, int connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            this.consoleSerial = serial;

        }

        public String getBrand() {
            return brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public int getConnectedNumber() {
            return connectedNumber;
        }

        public void setConnectedNumber(int connectedNumber) {
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
            isOn = true;
            GameConsole.this.powerOn();
            if (firstGame_pad.isOn) {
                secondGame_pad.connectedNumber = 2;
            } else {
                secondGame_pad.connectedNumber = 1;
            }
        }

        @Override
        public void powerOff() {
            //TODO checking whether console is on
            isOn = false;
            if (firstGame_pad.isOn) {
                secondGame_pad.connectedNumber = 1;
            }
        }

    }

    public String getBrand() {
        return brand;
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

    public Gamepad getFirstGame_pad() {
        return firstGame_pad;
    }

    public Gamepad getSecondGame_pad() {
        return secondGame_pad;
    }


    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public int getWaitingCounter() {
        return waitingCounter;
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
