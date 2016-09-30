/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.sas.business.service.StudentService;

/**
 *
 * @author tndangana
 */
public class StudentListPage  extends WebPage{
    
    @SpringBean
    StudentService studentService;

    public StudentListPage() {
        
        
    }
    
    
    
}
