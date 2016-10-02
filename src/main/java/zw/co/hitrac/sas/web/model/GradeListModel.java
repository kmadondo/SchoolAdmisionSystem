
package zw.co.hitrac.sas.web.model;

import java.util.List;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import zw.co.hitrac.sas.business.domain.Grade;
import zw.co.hitrac.sas.business.service.GradeService;

/**
 *
 * @author tndangana
 */
public class GradeListModel  extends LoadableDetachableModel<List<Grade>>{
    
    private GradeService gradeService;
     public GradeListModel(){
     
     Injector.get().inject(this);
     }

    @Override
    protected List<Grade> load() {
        return gradeService.findAll(); }
    
}
