import java.util.List;
import java.util.Set;

public interface CarMap<K, V> {
    void put(K key, V value);
    V getValue(K key);
    Set<K> keySet();
    List<V> values();
    boolean remove(K key);
    int size();
    void clear();
}
