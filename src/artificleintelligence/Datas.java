/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artificleintelligence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dilolokko
 */
public class Datas {
    private Map<Integer,String> header;
    private Map<Integer,String> body;
    private List<Map<Integer,String>> BODY_OF_VALUE = new ArrayList<Map<Integer,String>>();

    public Map<Integer, String> getHeader() {
        return header;
    }

    public void setHeader(Map<Integer, String> header) {
        this.header = header;
    }

    public Map<Integer, String> getBody() {
        return body;
    }

    public void setBody(Map<Integer, String> body) {
        this.body = body;
    }

    public List<Map<Integer, String>> getBODY_OF_VALUE() {
        return BODY_OF_VALUE;
    }

    public void setBODY_OF_VALUE(List<Map<Integer, String>> BODY_OF_VALUE) {
        this.BODY_OF_VALUE = BODY_OF_VALUE;
    }
    
}
