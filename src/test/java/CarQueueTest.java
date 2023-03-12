import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarQueueTest {

    private CarQueue<Car> carQueue;

    @Before
    public void setUp() throws Exception {
        carQueue = new CarLinkedList<>();
        for (int i = 0; i < 10; i++) {
            carQueue.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void add() {
        assertEquals(10, carQueue.size());
    }

    @Test
    public void peek() {
        Car car = carQueue.peek();
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void poll() {
        Car car = carQueue.peek();
        carQueue.poll();
        assertEquals("Brand0", car.getBrand());
        assertEquals(9, carQueue.size());
    }
}