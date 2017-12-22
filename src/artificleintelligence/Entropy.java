/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artificleintelligence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dilolokko
 */
public class Entropy{
    public double entropyHesapla(Map<Integer,String> body_of_value){
        LinkedHashMap<String,Integer> gecici = new LinkedHashMap<String, Integer>();
        int j=0;
        for(int i = 0; i<body_of_value.size();i++){
            if(!gecici.containsKey(body_of_value.get(i))){
                gecici.put(body_of_value.get(i), 1);
            }
            else{
                gecici.put(body_of_value.get(i), (gecici.get(body_of_value.get(i))+1));
            }   
        }
        //System.out.println("deger bolmek için gecici:" + gecici);
        return entrophy(gecici,body_of_value.size());
    }

    public double entrophy(LinkedHashMap<String, Integer> gecici,int size) {
        double entropy_value = 0.0;
        int sizefor=size;
        //System.out.println(String.valueOf(gecici));
            for (Map.Entry<String, Integer> entry : gecici.entrySet()) {
               // System.out.println(String.valueOf(entry));
                int deger = entry.getValue();
                //System.out.println("size "+deger+"  bolunecek deger: "+size);
                double veri = ((double)deger/(double)size);
                //System.out.println("bolunmus deger veri: "+veri);
                entropy_value += (float)((nlog2(veri)));
                //System.out.println(String.valueOf("entrypoy:" + entropy_value));
            }
        return entropy_value;
    }
    private double nlog2(double value) {
        if ( value == 0 )   return 0;
        double ent = -value * Math.log(value) / Math.log(2);
        return ent;
    }
}
