/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artificleintelligence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dilolokko
 */
public class ArtificleIntelligence{
    Datas data = new Datas();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double entropy_value = 0.0;
        Entropy ent = new Entropy();
        Gain kazanc = new Gain();
        
       Map<Integer,String> header = new HashMap<Integer,String>();
       Map<Integer,String> body = new HashMap<Integer,String>();
       List<Map<Integer,String>> BODY_OF_VALUE = new ArrayList<Map<Integer,String>>();
       
       header.put(0, "weather");
       header.put(1, "parents");
       header.put(2, "money");
       header.put(3, "decision");
       
       body = new HashMap<Integer,String>();
       body.put(0, "SUNNY");
       body.put(1, "SUNNY");
       body.put(2, "WINDY");
       body.put(3, "RAINY");
       body.put(4, "RAINY");
       body.put(5, "RAINY");
       body.put(6, "WINDY");
       body.put(7, "WINDY");
       body.put(8, "WINDY");
       body.put(9, "SUNNY");
       BODY_OF_VALUE.add(body);
       
       body = new HashMap<Integer,String>();
       body.put(0, "YES");
       body.put(1, "NO");
       body.put(2, "YES");
       body.put(3, "YES");
       body.put(4, "NO");
       body.put(5, "YES");
       body.put(6, "NO");
       body.put(7, "NO");
       body.put(8, "YES");
       body.put(9, "NO");
       BODY_OF_VALUE.add(body);
       
       body = new HashMap<Integer,String>();
       body.put(0, "RICH");
       body.put(1, "RICH");
       body.put(2, "RICH");
       body.put(3, "POOR");
       body.put(4, "RICH");
       body.put(5, "POOR");
       body.put(6, "POOR");
       body.put(7, "RICH");
       body.put(8, "RICH");
       body.put(9, "RICH");
       BODY_OF_VALUE.add(body);
       
       body = new HashMap<Integer,String>();
       body.put(0, "CINEMA");
       body.put(1, "TENNIS");
       body.put(2, "CINEMA");
       body.put(3, "CINEMA");
       body.put(4, "STAY");
       body.put(5, "CINEMA");
       body.put(6, "CINEMA");
       body.put(7, "SHOPPING");
       body.put(8, "CINEMA");
       body.put(9, "TENNIS");

       BODY_OF_VALUE.add(body);
       ArtificleIntelligence ai = new ArtificleIntelligence();
       if(ai.kokler_bul(BODY_OF_VALUE, header)){
           System.out.println("Ağacın sonuna gelindi");
       }
       
    }
    public boolean kokler_bul(List<Map<Integer,String>> BODY_OF_VALUE, Map<Integer,String> header){
        List<Map<Integer,String>> altKokler = new ArrayList<Map<Integer,String>>();
        List<Map<Integer,String>> gecici = new ArrayList<Map<Integer,String>>();
        Map<Integer,String> body = new HashMap<Integer,String>();
        Map<Integer,String> head = new HashMap<Integer,String>();
        double entropy_value = 0.0;
        Entropy ent = new Entropy();
        Gain kazanc = new Gain();
        int header_size=0;
        entropy_value = ent.entropyHesapla(BODY_OF_VALUE.get(BODY_OF_VALUE.size()-1));
        System.out.println("O anki genel Entropy :"+String.valueOf(entropy_value));
        int uzunluk= BODY_OF_VALUE.size()-1, buyuk_sutun_no = 0, gecici_body=0;
        double kok = 0.0;
        for(int i = 0; i < uzunluk ; i++){
            double sutun_deger = kazanc.genelKazanc(entropy_value, BODY_OF_VALUE, i,BODY_OF_VALUE.get(i).size());
            if(kok<sutun_deger)
            {
                buyuk_sutun_no = i;
                kok = sutun_deger;
            }
            System.out.println("Sutunun kazancı: "+sutun_deger + " deger :"+header.get(i));
        }
        
        System.out.println("\n\n KÖK : "+header.get(buyuk_sutun_no)+"  sutun no: "+ buyuk_sutun_no+ "    "+header+"\n\n");
        
        for(int i = 0; i<BODY_OF_VALUE.get(buyuk_sutun_no).size()-1; i++){
            if(!body.containsValue(BODY_OF_VALUE.get(buyuk_sutun_no).get(i))){
                body.put(gecici_body, BODY_OF_VALUE.get(buyuk_sutun_no).get(i));
                gecici_body++;
            }
        }
        System.out.println("alt secenekler: "+body+"\n");
        for(int i = 0;i<BODY_OF_VALUE.size();i++){
            Map<Integer,String> icerik = new HashMap<Integer,String>();
            for(int j = 0;j<BODY_OF_VALUE.get(i).size(); j++){
                icerik.put(j, BODY_OF_VALUE.get(i).get(j));
            }
            gecici.add(icerik);
        }
        System.out.println("body size:"+body.size());
        if(!(entropy_value == 0.0)){
            if(body.size()>1){
                for(int i = 0;i<body.size();i++){
                    altKokler = new ArrayList<Map<Integer,String>>();
                    int icerikSayisi =gecici.get(buyuk_sutun_no).size()-1, eleman_sirasi =0;
                    for(int j = 0; j<=icerikSayisi; j++){
                        if(body.get(i).equals(gecici.get(buyuk_sutun_no).get(j))){
                            for(int k = 0; k<gecici.size();k++){
                                if(altKokler.size()<gecici.size()){
                                    Map<Integer,String> veri = new HashMap<Integer,String>();
                                    veri.put(eleman_sirasi, gecici.get(k).get(j));
                                    altKokler.add(k,veri);
                                }
                                else{
                                    altKokler.get(k).put(eleman_sirasi,gecici.get(k).get(j));
                                }
                            }
                            eleman_sirasi++;
                        }
                    }
                    if(altKokler.get(0).size()>0){
                        System.out.println("Alt kok için bulunan veri seti :"+altKokler);
                        kokler_bul(altKokler,header);
                    }
                    else{
                        for(int j = 0; j< altKokler.size();j++){
                            System.out.print(altKokler.get(j)+" iken ");
                        }
                        System.out.println("");
                    }
                }
            }
        }
        BODY_OF_VALUE.remove(buyuk_sutun_no);
        

        if(BODY_OF_VALUE.size()>2 && body.size()>1){
            header_size=0;
            for(int i =0;i<header.size();i++){
                if(buyuk_sutun_no!=i){
                    head.put(header_size, header.get(i));
                    header_size++;
                }
            }
            System.out.println("Head:"+head+"  header:"+header);
            System.out.println("\nSutun sildikten sonraki dizi :"+BODY_OF_VALUE+"\n");
            kokler_bul(BODY_OF_VALUE,head);
            return true;
        }
        return false;
    }
    
}
