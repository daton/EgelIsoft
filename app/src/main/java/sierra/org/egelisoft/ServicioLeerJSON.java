package sierra.org.egelisoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by campitos on 15/12/17.
 */

public class ServicioLeerJSON {


    public static  String[] servicioLeerTemperaturas(){
        String mensaje="nada";
        boolean encontrada=false;
        int lineas=0;
        int valorLinea=0;
        String temperaturas[]=new String[5];


        String datos="nada";
        try{

            URL url = new URL("http://www.weatherlink.com/user/sierraguadalupe/index.php?view=summary&headers=0");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                datos=inputLine;
                lineas++;
                if(encontrada && valorLinea<5){
                    temperaturas[valorLinea]=inputLine;
                    valorLinea++;
                }
                if(inputLine.contains("Outside Temp")){
                    encontrada=true;

                }

            }
            int indice=datos.indexOf("#");
            //  mensaje=datos.substring(0, indice);

        }catch(Exception e){

        }

        return temperaturas;
    }
}
