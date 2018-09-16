package school.cesar.Aula1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class MyYearTest {

    public static final String BISSEXTO = "bissexto";
    public static final String NO_BISSEXTO = "nobissexto";
    public static final String YEAR_NOW = "2018";
    public static final String BISSEXTO_YEAR = "1980";
    public static final String NO_BISSEXTO_YEAR = "1981";

    @Test
    public void checkYearNowTest() {
        Assertions.assertEquals(YEAR_NOW, DateNow.getYearNow());
    }
    @Test
    public void bissextoYearNowTest() {
        Assertions.assertEquals(BISSEXTO, DateNow.validaBissexto(DateNow.getYearNow()));
    }
    @Test
    public void bissextoTest() {
        Assertions.assertEquals(BISSEXTO, DateNow.validaBissexto(BISSEXTO_YEAR));
    }
    @Test
    public void noBissextoTest() {
        Assertions.assertEquals(NO_BISSEXTO, DateNow.validaBissexto(NO_BISSEXTO_YEAR));
    }
}



