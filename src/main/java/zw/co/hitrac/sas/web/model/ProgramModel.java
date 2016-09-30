/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.sas.business.domain.Program;
import zw.co.hitrac.sas.business.service.ProgramService;

/**
 *
 * @author tndangana
 */
public class ProgramModel extends LoadableDetachableModel<Program> {
    
    private final Long id;
    @SpringBean
    private ProgramService programService;
    
    public ProgramModel(Long id){
    this.id = id;
        Injector.get().inject(this);
    
    }

    @Override
    protected Program load() {
       
        
        if(id==null){
            
            return new Program();
        }
        else{
        return programService.find(id);
        }
            
            
    }
    
}
