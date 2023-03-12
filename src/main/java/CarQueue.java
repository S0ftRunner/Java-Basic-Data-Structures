public interface CarQueue<T> extends CarCollection<T> {
    boolean add(T car);

    T peek(); // возвращает первый элемент из коллекции

    T poll(); // возвращает первый элемент из коллекции и возвращает его

}
