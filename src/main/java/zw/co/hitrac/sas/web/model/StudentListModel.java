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
import zw.co.hitrac.sas.business.domain.Student;
import zw.co.hitrac.sas.business.service.StudentService;

/**
 *
 * @author tndangana
 */
public class StudentListModel extends LoadableDetachableModel<List<Student>> {
    @SpringBean
    private StudentService studentService;
     
    public StudentListModel(){
    Injector.get().inject(this);
    
    }
    

    @Override
    protected List<Student> load() {
       return studentService.findAll();
         }
    
}
