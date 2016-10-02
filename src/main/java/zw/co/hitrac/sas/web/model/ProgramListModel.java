/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.model;

import java.util.List;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.sas.business.domain.Program;
import zw.co.hitrac.sas.business.service.ProgramService;

/**
 *
 * @author tndangana
 */
public class ProgramListModel extends LoadableDetachableModel<List<Program>> {
    @SpringBean
    private ProgramService programService;
    
     public ProgramListModel(){
         Injector.get().inject(this);
     
     }

    @Override
    protected List<Program> load() {
        return programService.findAll();
    }
    
}
