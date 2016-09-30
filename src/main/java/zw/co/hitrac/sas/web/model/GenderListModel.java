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
import zw.co.hitrac.sas.business.domain.Gender;
import zw.co.hitrac.sas.business.domain.Grade;
import zw.co.hitrac.sas.business.service.GenderService;

/**
 *
 * @author tndangana
 */
public class GenderListModel extends LoadableDetachableModel<List<Gender>> {
    
    @SpringBean
    private GenderService genderService;

    public GenderListModel() {
        Injector.get().inject(this);
    }
    
    

    @Override
    protected List<Gender> load() {
    return genderService.findAll();   
    
    }
    
}
