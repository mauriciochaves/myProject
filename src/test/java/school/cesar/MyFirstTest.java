package school.cesar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFirstTest {

    private boolean isTrue = false;

    @AfterEach
    public void tearDown() {
        isTrue = false;
    }

    @Test
    public void myTest() {
        Assertions.assertTrue(isTrue);
    }

    @Test
    public void myTest2() {
        Assertions.assertEquals("Teste 1", "Teste 1");
    }

}
