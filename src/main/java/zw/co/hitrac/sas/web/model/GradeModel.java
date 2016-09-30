/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.sas.business.domain.Grade;
import zw.co.hitrac.sas.business.service.GradeService;

/**
 *
 * @author tndangana
 */
public class GradeModel  extends LoadableDetachableModel<Grade>{
        @SpringBean
        private GradeService gradeService;
        private Long id;
        
        public GradeModel( Long id){
            Injector.get().inject(this);
        
        }

    @Override
    protected Grade load() {
        if (id==null){
        return new Grade();
        }
        else
        {
        return gradeService.find(id);
        }
    }
    
}
