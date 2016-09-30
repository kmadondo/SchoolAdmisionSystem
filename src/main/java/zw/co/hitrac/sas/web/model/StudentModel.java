/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.sas.business.domain.Student;
import zw.co.hitrac.sas.business.service.StudentService;

/**
 *
 * @author tndangana
 */
public class StudentModel extends LoadableDetachableModel<Student> {
    @SpringBean
    private StudentService studentService;
    private final Long id;

    public StudentModel(Long id) {
        this.id = id;
        Injector.get().inject(this);
    }
    

    @Override
    protected Student load() {
     
     if (id == null)
     {
      return new Student();
     }
     else 
     {
     return studentService.find(id);
     }
    
    }
    
}
