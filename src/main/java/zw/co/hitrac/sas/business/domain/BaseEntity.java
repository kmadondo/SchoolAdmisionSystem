/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.business.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author tndangana
 */
@Entity
public abstract  class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    
    
   
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName(){
    return name;
    }
    
    public void setName(String name){
    this.name = name;
    }

    
    
}
