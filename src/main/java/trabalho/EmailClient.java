package trabalho;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmailClient {

    private EmailService emailService;
    List accounts = new ArrayList();

    public EmailClient() {

    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public boolean isValidAddress(String emailAddress) {
        // usuario Apenas Letras, números e os seguintes caracteres: ponto (.), linha (_) e traço (-)
        //domain Letras, números e o caractere ponto (.), não podendo ele estar no início, final ou seguido de outro ponto
        //Um endereço é considerado válido se possuir usuário válido, seguido pelo caracterae arroba (@) e posteriormente um domínio válido.

        boolean validaddress = false;
        boolean user = false;
        boolean domain = false;

        if (emailAddress.contains("@")) {
            String email[] = emailAddress.split("@");

            //valida usuario
            // usuario Apenas Letras, números e os seguintes caracteres: ponto (.), linha (_) e traço (-)
            if (email[0] != null) {
                String userPattern = "[a-zA-Z0-9._-]+";

                if (email[0].matches(userPattern) ) {
                    user = true;
                }
            }

            //validar domain
            //domain Letras, números e o caractere ponto (.), não podendo ele estar no início, final ou seguido de outro ponto
            if (email[1] != null) {
                if ((!(email[1].contains(".."))) && (!(email[1].startsWith("."))) && (!(email[1].endsWith(".")))) {
                    String domainPattern = "[a-zA-Z0-9.]+";
                            if (email[1].matches(domainPattern)) {
                                domain = true;
                            }
                }
            }
        }
        if ((domain == true) && (user == true)) {
            validaddress = true;
        }
        return validaddress;
    }

    public boolean isValidEmail(Email email) {
        // É considerado válido o email que possuir um creationDate, um destinatário (to) válido, ao menos um emissor (from) válido e os demais e-mails também sejam válidos
        boolean emailuser = true;

        //validando creationDate
        if (email.getCreationDate() != null) {

            //validando um ou mais destinatário (to)
            if (email.getTo() != null) {

                for (String emailvaliding:email.getTo()) {
                    if (!(isValidAddress(emailvaliding))){
                        emailuser = false;
                    }
                }
            }else{
                emailuser = false;
            }

            //validando um ou mais destinatário (bcc)
            if (email.getBcc() != null) {

                for (String emailvaliding:email.getBcc()) {
                    if (!(isValidAddress(emailvaliding))){
                        emailuser = false;
                    }
                }
            }else{
                emailuser = false;
            }

            //validando um ou mais destinatário (cc)
            if (email.getCc() != null) {

                for (String emailvaliding:email.getCc()) {
                    if (!(isValidAddress(emailvaliding))){
                        emailuser = false;
                    }
                }
            }else{
                emailuser = false;
            }

            //validando um emissor (from)
                if (email.getFrom() != null) {
                    if (!(isValidAddress(email.getFrom()))) {
                        emailuser = false;
                    }
                }else{
                    emailuser = false;
                }
        }else{
            emailuser = false;
        }
        return emailuser;
    }

    public Collection<Email> emailList(EmailAccount account){
        // Antes de obter emails verificar se password é válido (password é valido se maior que 6 caracteres ou lastPasswordUpdate menor ou igual a 90 dias)
        // Se password inválido levantar uma exeção do tipo RuntimeException
        // Chamar emailService.emailList(account)

            if(!(account.getPassword().length()> 6) || account.verifyPasswordExpiration()){
                throw new RuntimeException("Password Invalido");
            }
        return emailService.emailList(account);
    }

    public void sendEmail(Email email){
       // verifica se o email é válido (utilizando o método isValidEmail)
       //  chamar emailService.sendEmail(Email email)
       //  Se retorno false levantar uma exeção do tipo RuntimeException

       if(isValidEmail(email)){
            emailService.sendEmail(email);
       }else{
           throw new RuntimeException("Email Invalido");
       }
    }

    public boolean createAccount(EmailAccount account){
        // verifica se o usuário e o dominio são válidos
        // verifica se o password é maior que 6 caracteres
        // adiciona data atual ao lastPasswordUpdate
        // adcionar objeto a coleção accounts

        boolean add = false;
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        hoje.format(formatador);

       if( (isValidAddress(account.getUser()+"@"+account.getDomain())) && (account.getPassword().length() > 6)){
           account.setLastPasswordUpdate(hoje);

           accounts.add(account);
           add = true;
       }
        return add;
    }
}
