import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapTest {

    private CarMap<CarOwner, Car> carMap;


    @Before
    public void setUp() throws Exception {
        carMap = new CarHashMap<>();
    }

    @Test
    public void putTest() {
        for (int i = 0; i < 100; i++) {
             carMap.put(new CarOwner(i, "name" + i, "Last Name" + i), new Car("Brand" + i, i));
         }
        assertEquals(100, carMap.size());
    }

    @Test
    public void whenPut100ElementsWith10DifferentKeysThenSizeMustBe10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "name" + index, "last name" + index);
            Car car = new Car("Brand" + index, index);
            carMap.put(carOwner, car);
        }
        assertEquals(10, carMap.size());
    }



    @Test
    public void removeReturnTrueOnlyOnce() {
            for (int i = 0;i < 10; i++) {
                CarOwner carOwner = new CarOwner(i, "name" + i, "last name" + i);
                Car car = new Car("Brand" + i, i);
                carMap.put(carOwner, car);
            }
            assertEquals(10, carMap.size());

            CarOwner elementForDeleting = new CarOwner(1, "name1", "last name1");
            carMap.remove(elementForDeleting);
            assertEquals(9, carMap.size());
            assertFalse(carMap.remove(elementForDeleting));
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOfValues() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "name" + i, "last name" + i);
            Car car = new Car("Brand" + i, i);
            carMap.put(carOwner, car);
        }

        assertEquals(100, carMap.size());
        assertEquals(100, carMap.keySet().size());
        assertEquals(100, carMap.values().size());
    }

    public void methodGetMustReturnRightValue() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "name" + i, "last name" + i);
            Car car = new Car("Brand" + i, i);
            carMap.put(carOwner, car);
        }

        CarOwner key = new CarOwner(1, "name1", "last name1");
        Car value = carMap.getValue(key);
        String expectedCarBrand = "Brand1";
        assertEquals(expectedCarBrand, value.getBrand());
    }
}