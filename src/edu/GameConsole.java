package edu;
      /*1.Реализация внутреннего класса
       •Создать класс GameConsole.
        Описать поля:
        brand (название производителя, например Sony, Microsoft. Можно оформить enum-ом),
        model (название модели, например XBOX 360, PS4 PRO),
        serial (серийный номер приставки, например XC123QeWR),
        firstGamepad (объект для первого джойстика, который будет реализован как
        внутренний класс),
        secondGamepad (объект для второго джойстика),
        isOn (флаг состояния. True – вкл, false - выкл)*/

public class GameConsole extends MyException implements Powered {
    private final String brand;
    private String model;
    private final String serial;
    private final Gamepad firstGamePad;
    private final Gamepad secondGamePad;
    private boolean isOn;
    // •  Добавить поле Game activeGame
    private Game activeGame;
    //    Добавить новое поле для класса GameConsole – waitingCounter;
    private int waitingCounter;

//  • Создать конструктор для класса GameConsole. Передать в него 2 параметра (brand, serial)
//  • Внутри конструктора создать и присвоить 2 джойстика (firstGamepad, secondGamepad). Причем brand можно передать уже существующие для самой
//    консоли, а connectedNumber фиксированными значениями 1 и 2.
//    •  Для полей которые не должны меняться (определите их сами :) ), применить
//       модификатор final, и создать геттеры.
//    • Для остальных полей создать геттеры и сеттеры.

    public GameConsole(String brand, String serial) {
        this.brand = brand;
        this.serial = serial;
        firstGamePad = new Gamepad(brand, 1);
        secondGamePad = new Gamepad(brand, 2);
    }

    //•  Добавить метод loadGame(Game). В нем вывести сообщение «Игра
//    {название} загружается»
    void loadGame(Game game) {
        activeGame = game;
        System.out.println("Игра " + game.getName() + " загружается");
    }

    /*    •  Добавить метод playGame(). В нем выводить информацию о текущей игре
          «Играем в {игра}» и информацию о заряде только активных джойстиков.
          Внимание! При каждом вызове метода – уменьшать заряд джойстика на 10%.
        Когда заряд уменьшиться до 0 – нужно выключить джойстик.*/
    void playGame() {
        if (!isOn) {
            System.out.println("Играем в " + activeGame.getName());
            Gamepad[] gamepads = {firstGamePad, secondGamePad};
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

    //    •  Добавить приватный метод void checkStatus(). Который будет вызываться
//    каждый раз когда вызывается метод playGame().
/*Если оба джойстика выключены – выводить сообщение «Подключите
    джойстик» и увеличивать счетчик на 1. Если хотя-бы один джойстик
    активен – сбрасывать в 0.
    Если счетчик превысил 5 циклов ожидания – «Выключить» приставку и
    бросить исключение с текстом «Приставка завершает работу из-за
    отсутствия активности» (Класс-исключение создать свой.)*/
    private void checkStatus() {
        if (firstGamePad.chargeLevel < 10.0 & secondGamePad.chargeLevel < 10.0) {
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

    //•  Реализовать данный интерфейс для джойстика и консоли
    @Override
    public void powerOn() {
        System.out.println(isOn = true);
    }

    @Override
    public void powerOff() {
        System.out.println(isOn = false);
    }

/*      • Создать внутренний (нестатический) класс Gamepad.
          Описать поля:
          brand (название производителя, например Sony, Microsoft).
          consoleSerial (серийный номер консоли, к которой подключен джойстик),
          connectedNumber (порядковый номер джойстика),
          color (цвет джойстика, можно оформить enum-ом),
          chargeLevel (значение процента заряда, по умолчанию поставить 100.0)
          isOn (флаг состояния. True – вкл, false - выкл).*/

    class Gamepad implements Powered {
        private final String brand;
        private final String consoleSerial;
        private int connectedNumber;
        private String color;
        public float chargeLevel = 100.0f;
        private boolean isOn;

        /*•  Создать конструктор для класса Gamepad. Передать в него параметр (brand и
             connectedNumber), а полю consoleSerial присвоить значение серийного номера приставки.*/
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

        //•  Реализовать данный интерфейс для джойстика и консоли
        //•  Добавить функционал, который включает приставку, когда включается джойстик.
        //•  Добавить функционал, который делает «второй» джойстик «первым», если первый был выключен.

        @Override
        public void powerOn() {
            isOn = true;
            GameConsole.this.powerOn();
            if (firstGamePad.isOn) {
                secondGamePad.connectedNumber = 2;
            } else {
                secondGamePad.connectedNumber = 1;
            }
        }

        @Override
        public void powerOff() {
            //TODO checking whether console is on
            isOn = false;
            if (firstGamePad.isOn) {
                secondGamePad.connectedNumber = 1;
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

    public Gamepad getFirstGamePad() {
        return firstGamePad;
    }

    public Gamepad getSecondGamePad() {
        return secondGamePad;
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
                ", firstGame_pad='" + firstGamePad + '\'' +
                ", secondGame_pad='" + secondGamePad + '\'' +
                ", isOn=" + isOn +
                '}';
    }
}
