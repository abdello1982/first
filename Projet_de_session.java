/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_de_session;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import java.util.Calendar;
import java.util.*;
import net.sf.json.*;
import java.text.DecimalFormat;


/**
 *
 * @author abdello
 */
public class Projet_de_session {
    private static String dateString;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {   
       //if (args.length<1){System.out.print("erreur");System.exit(0);}
        String lien1="/src/projet_de_session/json/catalog.json";//args[1];
       String lien2="catalog.json";//args[2];
        int i = 0;
        int cpt =0;
        int asci=0;
        String json = FileReader.loadFileIntoString("src/projet_de_session/json/catalog.json", "utf-8");
        JSONObject fichier = JSONObject.fromObject(json);
          JSONObject voiture =fichier.getJSONObject("voiture");
          int annee = voiture.getInt("annee");
          String marque = voiture.getString("marque");
          String modele = voiture.getString("modele");  
        double valeur_des_options = voiture.getDouble("valeur_des_options");
        String burinage =voiture.getString("burinage");
        boolean garage_interieur =voiture.getBoolean("garage_interieur");
        boolean systeme_alarme= voiture.getBoolean("systeme_alarme");
        JSONObject conducteur =fichier.getJSONObject("conducteur");
        boolean cours_de_conduite_reconnus_par_CAA = conducteur.getBoolean("cours_de_conduite_reconnus_par_CAA");
        boolean premier_contrat =conducteur.getBoolean("premier_contrat");
        String date_de_naissance = conducteur.getString("date_de_naissance");
        String province =conducteur.getString("province");
        String ville = conducteur.getString("ville");
        String sexe =conducteur.getString("sexe");
        String date_fin_cours_de_conduite =conducteur.getString("date_fin_cours_de_conduite");  
         int duree_contrat =fichier.getInt("duree_contrat");
        String an1= date_de_naissance.substring(0,4);
        String mois1= date_de_naissance.substring(5,7);
        String jour1= date_de_naissance.substring(8,10);
        int ann1 =Integer.parseInt(an1);
         int moiss1 =Integer.parseInt(mois1);
         int jourr1 =Integer.parseInt(jour1);
        String an= date_de_naissance.substring(0,4);
        String mois= date_de_naissance.substring(5,7);
        String jour= date_de_naissance.substring(8,10);
        int ann =Integer.parseInt(an);
         int moiss =Integer.parseInt(mois);
         int jourr =Integer.parseInt(jour);
        boolean trouve =false;
        double comission=0.00;
        double comission_monsuel=0.0;
        String Modele[]={"Boxer" , "Boxer S" , "Cayman" , "Caymen S" ,
        "911 Carrera" , "911 Carrera S" , "911 Carrera 4S" , "911 Carrera 4 Cabriolet" ,
        "911 Carrera 4S Cabriolet" , "911 50 ans" , "911 Turbo" , 
        "911 Turbo S" , "911 GT3" , "Panamera" , "Panamera 4" , "Panamera S" , "Panamera S E-Hybride" ,
        "panamera 4S" , "Panamera 4S Executive" , "Panamera GTS" , "Panamera Turbo" ,
                "panamera Turbo Executive" , "Cayenne" , "Cayenne Diesel" , "Cayenne S" ,
                        "Cayenne S Hybride" , "Cayenne GTS" ,"Cayenne Turbo" ,"Cayenne Turbo S"};
        int Valeur[] = {60000 , 72000, 62000, 75000, 100000, 115000, 112000 , 129000 , 106000 ,
        123000 , 120000, 137000, 142000 , 170000, 207000 , 149000, 90000, 95000, 107000, 114000, 113000, 144000, 130000,
        162000, 185000, 59000, 67000, 77000 , 82000 , 96000 ,125000 , 169000};
    if (annee!= 2014) {System.out.print("erreur");System.exit(0);}
    if (!"Porsche".equals(marque)) {System.out.print("erreur");System.exit(0);}
    for ( i =0 ; i<Modele.length;i++)
    { if (modele.equals(Modele[i])){trouve = true;  cpt= i;}
    }
    if (trouve!=true){System.out.print("erreur");System.exit(0);}
        province=province.replace('�', 'e'); 
        //System.out.print("hello");
   if (!"Quebec".equals(province) ){System.out.print("erreur");System.exit(0);}
   // System.out.print(province);
    int monAge = Projet_de_session.Age(ann,moiss,jourr);
    if (monAge <25 && "M".equals(sexe)){System.out.print("erreur");System.exit(0);}
   if (monAge <21 && "F".equals(sexe)){System.out.print("erreur");System.exit(0);}
    if (monAge >75 ){System.out.print("erreur");System.exit(0);}
    if (duree_contrat >3 ){System.out.print("erreur");System.exit(0);}
    comission=9*Valeur[cpt]/100;
    if (duree_contrat==3)comission-=15*Valeur[cpt]/100;
    comission+=10*valeur_des_options/100;
     if ( "Longueuil".equals(ville) || "Montreal".equals(ville) )  comission+=200;
     if ("Sherlock".equals(burinage)) comission-=250;
     if ("F".equals(sexe)) comission-=1000;
    if (garage_interieur==true) comission-=500;
    if (systeme_alarme==true) comission-=500;
     if (cours_de_conduite_reconnus_par_CAA==true) comission-=100;
    if ("M".equals(sexe) && monAge <35) comission+=500;
    if (premier_contrat==true) comission+=2000;
    int monAgee = Projet_de_session.Age(ann1,moiss1,jourr1);
      if (monAgee>15) comission-=400;
      comission_monsuel = comission * 1.5 / 12;
      DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(2);
        String comissionn = format.format(comission);
        String comission_monsuell = format.format(comission_monsuel);
        JSONObject order = new JSONObject();
        order.accumulate("assurable", true);
        order.accumulate("montant_annuel", comissionn);
        order.accumulate("mensualite", comission_monsuell);
      System.out.print(order);
}
                                           
// Methode pour calculer l'age
    
    public static int Age(int aa, int mm, int jj) {
        Calendar cal = new GregorianCalendar(aa, mm, jj);
        Calendar now = new GregorianCalendar();
        int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        if ((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
                || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH) && cal.get(Calendar.DAY_OF_MONTH) > now
                .get(Calendar.DAY_OF_MONTH))) {
            res--;
        }
        return res;
    } // fin Methode Age
}