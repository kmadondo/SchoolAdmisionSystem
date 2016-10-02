/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.pages;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import zw.co.hitrac.sas.SaSPageParametersUtil;
import zw.co.hitrac.sas.business.domain.Grade;
import zw.co.hitrac.sas.business.domain.Student;
import zw.co.hitrac.sas.business.service.StudentService;
import zw.co.hitrac.sas.web.model.GradeModel;
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
        createModel(pageParameter);

    }

    private Form<Student> createStudentForm() {
        Form<Student> form = new Form<Student>("form", compoundPropertyModel());
        form.add(createSubmitButton());
        form.add(createStudentTextField());
        return form;
    }

    private CompoundPropertyModel<Student> compoundPropertyModel() {
        CompoundPropertyModel<Student> compoundPropertyModel = new CompoundPropertyModel<Student>(studentModel);
        return compoundPropertyModel;
    }

    private TextField<String> createStudentTextField() {
        TextField<String> textField = new TextField<String>("");
        return textField;
    }

    private Button createSubmitButton() {
        Button submitButton = new Button("createStudentSubmitButton") {
            @Override
            public void onSubmit() {

                studentService.Save(studentModel.getObject());
                setResponsePage(StudentListPage.class);

            }
        };
        return submitButton;

    }

    private void createModel(PageParameters pageParameter) {
      Long id = SaSPageParametersUtil.extractId(pageParameter);
        studentModel = new StudentModel(id);
    }

}
