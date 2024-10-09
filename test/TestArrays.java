import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestArrays{
    
    private static Arrays<Integer> integerList;
    @BeforeAll
    static void setUp(){
        integerList = new Arrays<>();
    }
    
    @Test
    void simpleAdd(){
        integerList.add(10);
        integerList.add(11);
        integerList.add(12);
        integerList.add(13);
        assertEquals(4, integerList.size());
    }

    @Test
    void addRemove(){
        simpleAdd();
        integerList.remove(0);
        assertEquals(3, integerList.size());
        assertEquals(integerList.get(0), 11);
        int removed = integerList.remove(integerList.size());
        assertEquals(removed, 13);
        assertEquals(integerList.size(), 2);
    }
}
