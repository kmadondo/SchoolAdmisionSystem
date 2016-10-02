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
import zw.co.hitrac.sas.business.domain.Subject;
import zw.co.hitrac.sas.business.service.SubjectService;
import zw.co.hitrac.sas.web.model.SubjectModel;

import org.apache.wicket.request.mapper.parameter.PageParameters;


/**
 *
 * @author tndangana
 */
public class SubjectEditPage extends TemplatePage {

private SubjectModel subjectModel;
@SpringBean
private SubjectService subjectService;
    
    public SubjectEditPage(PageParameters pageParameter) {
        super(pageParameter);
        createModel(pageParameter);
    }
    
      private Form<Subject> createSubjectForm() {
        Form<Subject> form = new Form<Subject>("form", compoundPropertyModel());
        form.add(createSubmitButton());
        form.add(createStudentTextField());
        return form;
    }

    private CompoundPropertyModel<Subject> compoundPropertyModel() {
        CompoundPropertyModel<Subject> compoundPropertyModel = new CompoundPropertyModel<Subject>(subjectModel);
        return compoundPropertyModel;
    }

    private TextField<String> createStudentTextField() {
        TextField<String> textField = new TextField<String>("");
        return textField;
    }

    private Button createSubmitButton() {
        Button submitButton = new Button("createSubjectSubmitButton") {
            @Override
            public void onSubmit() {

                subjectService.Save(subjectModel.getObject());
                setResponsePage(SubjectListPage.class);

            }
        };
        return submitButton;

    }

    private void createModel(PageParameters pageParameter) {
       Long id = SaSPageParametersUtil.extractId(pageParameter);
        subjectModel = new SubjectModel(id);
    }

}
