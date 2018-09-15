package school.cesar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

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

class DateNow {
    static Integer data = 0 ;


    public static String getYearNow() {
        data = Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH);
        return  data.toString();
    }

    public static String validaBissexto(String AnoAtual) {
        int ano = Integer.parseInt(AnoAtual);
        if ((ano % 4 == 0) || (ano % 100 == 0 && ano % 400 != 0)){
            return MyYearTest.BISSEXTO;
        }
        return MyYearTest.NO_BISSEXTO;
     }

     public static String checkNiverCustomer(String data) throws ParseException {
         Date datanow = new Date();
         String dataFormatada = data;

        //pegar apenas o ano da data do customer
         Integer datenowatt = Integer.parseInt(data);
        data = data.substring(4,8);

        if( DateNow.validaBissexto(DateNow.getYearNow()) == MyYearTest.BISSEXTO && DateNow.validaBissexto(data) == MyYearTest.BISSEXTO ){

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



