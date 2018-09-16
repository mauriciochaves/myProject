package school.cesar.Aula1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class DateNow {
    static Integer data = 0 ;
    public static final String BISSEXTO = "bissexto";
    public static final String NO_BISSEXTO = "nobissexto";

    public static String getYearNow() {
        data = Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH);
        return  data.toString();
    }

    public static String validaBissexto(String AnoAtual) {
        int ano = Integer.parseInt(AnoAtual);
        if ((ano % 4 == 0) || (ano % 100 == 0 && ano % 400 != 0)){
            return BISSEXTO;
        }
        return NO_BISSEXTO;
     }

     public static String checkNiverCustomer(String data) throws ParseException {
         Date datanow = new Date();
         String dataFormatada = data;

        //pegar apenas o ano da data do customer
         Integer datenowatt = Integer.parseInt(data);
        data = data.substring(4,8);

        if( DateNow.validaBissexto(DateNow.getYearNow()) == BISSEXTO && DateNow.validaBissexto(data) == BISSEXTO ){

            //convertento e somando mais um dia na data
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
            Date dataDoUsuario = formato.parse(datenowatt.toString());
            Calendar c = Calendar.getInstance();
            c.setTime(dataDoUsuario);
            c.add(Calendar.DATE, +1);
            dataDoUsuario = c.getTime();
            formato.applyPattern("ddMMyyyy");
             dataFormatada = formato.format(dataDoUsuario);
         }
         return dataFormatada;
     }
}
