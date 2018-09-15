package trabalho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trabalho.util.EmailAccountBuilder;

import java.time.LocalDate;

public class EmailAccountTest {

    private EmailAccount emailaccount;
    private EmailAccountBuilder emailaccountbuilderPassWordNoExpiration;
    private EmailAccountBuilder emailAccountBuilderPasswordExpiration;
    private static final String DOMAIN_EMAIL = "cesar.school";
    private static final String USER_EMAIL = "mauricio.chaves";
    private static final String PASSWORD = "123456mj";

    @BeforeEach
    void setUp() {
        //emailAccountBuilderPasswordExpiration
        emailAccountBuilderPasswordExpiration = new EmailAccountBuilder()
                .setDomain(DOMAIN_EMAIL)
                .setUser(USER_EMAIL)
                .setLastPasswordUpdate(LocalDate.now().minusDays(91))
                .setPassword(PASSWORD);

        //emailaccountbuilderPassWordNoExpiration
        emailaccountbuilderPassWordNoExpiration = new EmailAccountBuilder()
                .setDomain(DOMAIN_EMAIL)
                .setLastPasswordUpdate(LocalDate.now())
                .setPassword(PASSWORD)
                .setUser(USER_EMAIL);
    }
    @Test
    void verifyPasswordExpirationTest_ExpirationDate_True() {
        emailaccount = emailAccountBuilderPasswordExpiration.build();
        Assertions.assertTrue(emailaccount.verifyPasswordExpiration());
    }
    @Test
    void verifyPasswordExpirationTest_NotExpirationDate_False() {
        emailaccount = emailaccountbuilderPassWordNoExpiration.build();
        Assertions.assertFalse(emailaccount.verifyPasswordExpiration());
    }
}
