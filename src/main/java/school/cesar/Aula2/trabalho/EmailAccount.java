package school.cesar.Aula2.trabalho;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EmailAccount {

    private String user;
    private String domain;
    private String password;
    private static LocalDate lastPasswordUpdate;

    public EmailAccount(String user, String domain, String password, LocalDate lastPasswordUpdate){
        this.user = user;
        this.domain = domain;
        this.password = password;
        this.lastPasswordUpdate = lastPasswordUpdate;
    }

    public String getUser() {
        return user;
    }
    public String getDomain() {
        return domain;
    }
    public String getPassword() {
        return password;
    }
    public static LocalDate getLastPasswordUpdate() {
        return lastPasswordUpdate;
    }
    public void setLastPasswordUpdate(LocalDate lastPasswordUpdate) {
        this.lastPasswordUpdate = lastPasswordUpdate;
    }
    public static boolean verifyPasswordExpiration(){
      //  O password é considerado expirado se o lastPasswordUpdate for maior que 90 dias da data atual do sistema
        boolean resetpassword = true;
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        hoje.format(formatador);

        final long days = ChronoUnit.DAYS.between(getLastPasswordUpdate(), hoje);
        if (days<=90){
            resetpassword = false;
        }
        return resetpassword;
    }
}
