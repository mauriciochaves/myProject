package school.cesar.Aula2.trabalho;

import java.util.Collection;

public interface EmailService {

    boolean sendEmail(Email email);

    Collection<Email> emailList(EmailAccount account);

}
