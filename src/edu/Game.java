package edu;

/*2.  Реализация вложенного статического класса
        •  Создать класс Game.
        Описать поля (пометить final):
        name (название игры),
        genre (жанр игры, например ACTION, SPORT, RACE. Можно оформить enum-ом),
        type (тип носителя, например VIRTUAL, PHYSICAL. Можно оформить enum-ом прямо внутри класса Game),*/
public class Game {
    private final String name;
    private final Genre genre;
    private final Type type;

    //    •  Создать приватный конструктор. В конструктор передать поля: name, genre, type
    private Game(String name, Genre genre, Type type) {
        this.name = name;
        this.genre = genre;
        this.type = type;
    }

    //    •  Создать getter-ы для полей.
    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Type getType() {
        return type;
    }

    //•  Создать вложенный (статический) класс GameDisk.
//    • Создать поле description (описание игры, пометить final)
//    • Создать поле Game data (final);
    static class GameDisk {
        private final String description;
        private final Game data;

        /*• В приватный конструктор передать поля: name, genre, description.
          • При вызове конструктора создавать экземпляр класса Game и передавать в него параметры name, genre и фиксированный type
    соответствующий этому носителю.
          • Также инициализировать поле с описанием. */
        private GameDisk(String name, Genre genre, String description) {
            data = new Game(name, genre, Type.PHYSICAL);
            this.description = description;
        }

        //        • Создать геттеры
        public String getDescription() {
            return description;
        }

        public Game getData() {
            return data;
        }
    }

    /*  •  Создать вложенный (статический) класс VirtualGame
      • Создать поле rating (рейтинг игры от 0 до 5)
      • Создать поле Game data (final);
      • В приватный конструктор передать поля: name, genre.
      • При вызове конструктора создавать экземпляр класса Game и
      передавать в него параметры name, genre и фиксированный type
      соответствующий этому носителю.*/
    static class VirtualGame {
        private int rating; //рейтинг игры от 0 до 5
        private final Game data;

        private VirtualGame(String name, Genre genre, int rating) {
            this.rating = rating;
            data = new Game(name, genre, Type.VIRTUAL);
        }

        //        • Создать необходимые геттеры/сеттеры
        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public Game getData() {
            return data;
        }
    }

    /*•  В классе Game создать статический метод GameDisk getDisk(…){…} для
        получения экземпляра класса (Паттерн static factory)
      • В метод передать параметры name, genre, description
      • Внутри метода создать и вернуть экземпляр класса GameDisk*/
    static GameDisk getDisk(String name, Genre genre, String description) {
        return new GameDisk(name, genre, description);
    }

    /*•  Аналогично, в классе Game создать статический метод VirtualGame
        getVirtualGame (…){…}
      • В метод передать параметры name, genre
      • Внутри метода создать и вернуть экземпляр класса VirtualGame.*/
    static VirtualGame getVirtualGame(String name, Genre genre, int rating) {
        return new VirtualGame(name, genre, rating);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                ", type=" + type +
                '}';
    }
}
