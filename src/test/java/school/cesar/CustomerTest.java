package school.cesar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;

class CustomerTest {

   private Customer user1;
   private   Customer user2;
   private   CustomerBuilder userBuilder1;
   private   CustomerBuilder userBuilder2;

    @BeforeEach
    void setUp() {
        userBuilder1 = new CustomerBuilder()
                .setFirstName("Mauricio")
                .setLastName("Silva")
                .setMaritalStatus("Solteiro")
                .setDateBirth("16091993")
                .setCity("Jaboatão dos Guararapes")
                .setState("Pernambuco");

        userBuilder2 = new CustomerBuilder()
                .setFirstName("Chaves")
                .setLastName("Silva")
                .setMaritalStatus("Casado")
                .setDateBirth("16091994")
                .setCity("Jaboatão dos Guararapes")
                .setState("Pernambuco");
    }
    @Test
     void myNiverTest() throws ParseException {
        user1 = userBuilder1.build();
        Assertions.assertEquals(DateNow.checkNiverCustomer(user1.getDatebirth()),user1.getDatebirth());
    }
    @Test
     void checkParentFamilyFirstNameTest() { // "Verifique se outra pessoa pertence a sua familia"
        //carregando instância dos usuarios
        user1 = userBuilder1.build();
        user2 = userBuilder2.build();

        //"Verificando se possui nomes diferentes"
        Assertions.assertNotSame(user1.getFirstname(),user2.getFirstname());
    }
    @Test
     void checkParentFamilyLastNameTest() { // "Verifique se outra pessoa pertence a sua familia"
        //carregando instância dos usuarios
        user1 = userBuilder1.build();
        user2 = userBuilder2.build();

        //"Tem o mesmo sobrenome"
        Assertions.assertEquals(user1.getLastname(), user2.getLastname());
    }
    @Test
     void checkParentFamilyCityTest() { // "Verifique se outra pessoa pertence a sua familia"
        //carregando instância dos usuarios
        user1 = userBuilder1.build();
        user2 = userBuilder2.build();

        //"Moram na mesma cidade"
        Assertions.assertEquals(user1.getCity(), user2.getCity());
    }
    @Test
     void checkParentFamilyStateTest() { // "Verifique se outra pessoa pertence a sua familia"
        //carregando instância dos usuarios
        user1 = userBuilder1.build();
        user2 = userBuilder2.build();

        //"Moram no mesmo estado"
        Assertions.assertEquals(user1.getState(), user2.getState());
    }
}
