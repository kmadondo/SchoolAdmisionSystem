/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.business.domain;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tndangana
 */
public enum Subjects {
    
    MATHEMATICS("Mathematics"),
    PHYSICS("Physics"),
    CHEMISTRY("Chemistry"),
    BIOLOGY("Biology"),
    GEOGRAPHY("Geography"),
    BUSINESS_STUDIES("Business Studies"),
    ECONOMICS("Economics"),
    DIVINITY("Divinity"),
    SHONA("Shona"),
    LITERATURE("Literature"),
    HISTORY("History"),
    ACCOUNTS("Accounts");
    
    private final String mySubject;
    
    Subjects(String mySubject){
     this.mySubject= mySubject;
     }
    
    public static List<Subjects> asList() {

        return Arrays.asList(Subjects.values());
    }
    
    public String getMySubject(){
        return mySubject;
    
    }

    @Override
    public String toString(){
        
        return getMySubject();
}
    
    
}
