public interface CarQueue extends CarCollection {
    boolean add(Car car);

    Car peek(); // возвращает первый элемент из коллекции

    Car poll(); // возвращает первый элемент из коллекции и возвращает его

}
