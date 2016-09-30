/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tndangana
 * @param <T>
 */
public interface IService  <T> extends Serializable {
    
    public T Save (T t);
    public List<T> findAll();
    public T find(Long id);
    public void  delete (T t);
    
}
