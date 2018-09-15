package school.cesar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ImcCalculatorTest {
    public ImcCalculator calculator;

    public static final String PESO_NORMAL = "normal";
    public static final String ACIMA_DO_PESO = "acimadopeso";
    public static final String ABAIXO_DO_PESO = "abaixopeso";
    public static final String DESNUTRICAO = "desnutricao";
    public static final String OBESIDADE_UM = "obesidadeum";
    public static final String OBESIDADE_DOIS = "obesidadedois";
    public static final String OBESIDADE_MORBIDA = "obesidademorbida";

    @BeforeEach
    public void setUp() {
        this.calculator = new ImcCalculator();
    }


    @Test
    public void desnutricaoTest() {
        Assertions.assertEquals(DESNUTRICAO, calculator.calc(1.80, 55));
    }

    @Test
    public void abaixoPesoTest() {
        Assertions.assertEquals(ABAIXO_DO_PESO, calculator.calc(1.95, 70));
    }

    @Test
    public void normalPesoTest() {
        Assertions.assertEquals(PESO_NORMAL, calculator.calc(1.55, 60));
    }

    @Test
    public void acimaDoPesoTest() {
        Assertions.assertEquals(ACIMA_DO_PESO, calculator.calc(1.70, 85));
    }

    @Test
    public void obesidadeUmTest() {
        Assertions.assertEquals(OBESIDADE_UM, calculator.calc(1.65, 95));
    }

    @Test
    public void obesidadeDoisTest() {
        Assertions.assertEquals(OBESIDADE_DOIS, calculator.calc(1.70, 115));
    }

    @Test
    public void obesdadeMorbidaTest() {
        Assertions.assertEquals(OBESIDADE_MORBIDA, calculator.calc(1.85, 140));
    }


    //classes

    public class ImcCalculator {
        public String calc(double altura, double peso) {
            double imc = peso / Math.pow(altura, 2.0);

            if (imc < 17) {
                return DESNUTRICAO;
            } else if (imc >= 17 && imc <= 18.49) {
                return ABAIXO_DO_PESO;
            } else if (imc >= 18.5 && imc <= 24.99) {
                return PESO_NORMAL;
            } else if (imc >= 25 && imc <= 29.99) {
                return ACIMA_DO_PESO;
            } else if (imc >= 30 && imc <= 34.99) {
                return OBESIDADE_UM;
            } else if (imc >= 35 && imc <= 39.99) {
                return OBESIDADE_DOIS;
            }
            return OBESIDADE_MORBIDA;
        }
    }
}
