/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.sas.business.service.StudentService;
import zw.co.hitrac.sas.web.model.StudentModel;

/**
 *
 * @author tndangana
 */
public class StudentEditPage extends TemplatePage {
    
    @SpringBean
    private StudentService studentService;
    private StudentModel studentModel;

    public StudentEditPage(PageParameters pageParameter) {
        super(pageParameter);
        
    }

 
        
    
    
}
