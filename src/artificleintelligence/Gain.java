/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artificleintelligence;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dilolokko
 */
public class Gain {
    public double genelKazanc(double genel_entropy, List<Map<Integer,String>> body_of_value,int sutun,int sutunBoyu){
        LinkedHashMap<String,Integer> gecici = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String,Double> sutun_ent_deger = new LinkedHashMap<String, Double>();
        int j=0, f=0;
        double veri=0.0;
        for(int i = 0; i<body_of_value.get(sutun).size();i++){
            if(!gecici.containsKey(body_of_value.get(sutun).get(i))){
                gecici.put(body_of_value.get(sutun).get(i), 1);
            }
            else{
                gecici.put(body_of_value.get(sutun).get(i), (gecici.get(body_of_value.get(sutun).get(i))+1));
            }   
        }
        sutun_ent_deger = parcalaKazanc(gecici,body_of_value,sutun,(body_of_value.size()-1));
        System.out.println("dizi degeri: "+gecici + "   veri: "+sutun_ent_deger);
        for (Map.Entry<String, Double> entry : sutun_ent_deger.entrySet()) {
            for(Map.Entry<String,Integer> entry2 : gecici.entrySet()){
                if(entry2.getKey().equals(entry.getKey())){
                    veri += entry.getValue()*(entry2.getValue()/(double)sutunBoyu);
                    System.out.println("entrophy sutun kazanc: "+entry.getValue()+"*("+entry2.getValue()+"/"+sutunBoyu+") : "+veri);
                }
            }  
        }
        return genel_entropy-veri;    
    }
    
    public LinkedHashMap<String,Double> parcalaKazanc(LinkedHashMap<String,Integer> gecici, List<Map<Integer,String>> body_of_value,int sutun,int son){
        LinkedHashMap<String,Integer> gecici_kazanc = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String,Double> sutun_ent_deger = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Integer> entry : gecici.entrySet()) {
            int j = 1;
            String veri = entry.getKey();
            //System.out.println("Veri : " + veri +"  "+ body_of_value.get(son).size());
            for(int i = 0; i<body_of_value.get(son).size();i++){
                if(body_of_value.get(sutun).get(i).equals(veri)){
                    //System.out.println("sutun: "+body_of_value.get(sutun).get(i)+"  "+String.valueOf(j));
                    if(!gecici_kazanc.containsKey(body_of_value.get(son).get(i))){
                        gecici_kazanc.put(body_of_value.get(son).get(i), 1);
                    }
                    else{
                        gecici_kazanc.put(body_of_value.get(son).get(i), (gecici_kazanc.get(body_of_value.get(son).get(i))+1));
                    }
                    //System.out.println("son sütun "+String.valueOf(body_of_value.get(son).get(i))+"  "+(gecici_kazanc.get(body_of_value.get(son).get(i))+1));
                     j++;
                }
                 
            }
            j--;
            //System.out.println("gecici "+gecici+"\n"+"buyuk sutun"+String.valueOf(j));
            //System.out.println("gecici kazanc"+gecici_kazanc+"\n"+String.valueOf(veri));
            Entropy etp = new Entropy();
            sutun_ent_deger.put(veri, etp.entrophy(gecici_kazanc,j));
            System.out.println("Veri: "+veri+"  deger entropy: "+sutun_ent_deger);
            gecici_kazanc = new LinkedHashMap<String, Integer>();
        }
        System.out.println("");
        return sutun_ent_deger;
    }
}
