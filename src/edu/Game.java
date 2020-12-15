package edu;

public class Game {
    private final String name;
    private final Genre genre;
    private final Type type;

    private Game(String name, Genre genre, Type type) {
        this.name = name;
        this.genre = genre;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Type getType() {
        return type;
    }


    static class GameDisk {
        private final String description;
        private final Game data;

        private GameDisk(String name, Genre genre, String description) {
            data = new Game(name, genre, Type.PHYSICAL);
            this.description = description;

        }

        public String getDescription() {
            return description;
        }

        public Game getData() {
            return data;
        }
    }

    static class VirtualGame {
        private int rating; //рейтинг игры от 0 до 5
        private final Game data;

        private VirtualGame(String name, Genre genre, int rating) {
            this.rating = rating;
            data = new Game(name, genre, Type.VIRTUAL);
        }

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

    static GameDisk getDisk(String name, Genre genre, String description) {
        return new GameDisk(name, genre, description);
    }

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
