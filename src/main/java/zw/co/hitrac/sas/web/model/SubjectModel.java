 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import zw.co.hitrac.sas.business.domain.Subject;
import zw.co.hitrac.sas.business.service.SubjectService;

/**
 *
 * @author tndangana
 */
public class SubjectModel extends LoadableDetachableModel<Subject> {

    private SubjectService subjectService;
    private final Long id;

    public SubjectModel(Long id) {
        this.id = id;
        Injector.get().inject(this);
    }

    @Override
    protected Subject load() {
        if (id == null) {

            return new Subject();

        } else {

            return subjectService.find(id);
        }
    }

}
