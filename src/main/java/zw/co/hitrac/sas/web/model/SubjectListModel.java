/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.model;

import java.util.List;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import zw.co.hitrac.sas.business.domain.Subject;
import zw.co.hitrac.sas.business.service.SubjectService;

/**
 *
 * @author tndangana
 */
public class SubjectListModel  extends LoadableDetachableModel<List<Subject>>{
    
    private SubjectService subjectService;
    
    public SubjectListModel(){
    Injector.get().inject(this);
    }

    @Override
    protected List<Subject> load() {
    return subjectService.findAll();}
    
}
