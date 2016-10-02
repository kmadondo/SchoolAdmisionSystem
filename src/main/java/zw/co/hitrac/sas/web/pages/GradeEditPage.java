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
import zw.co.hitrac.sas.business.service.GradeService;
import zw.co.hitrac.sas.web.model.GenderModel;
import zw.co.hitrac.sas.web.model.GradeModel;

/**
 *
 * @author tndangana
 */
public class GradeEditPage extends TemplatePage {

    private GradeModel gradeModel;
    @SpringBean
    private GradeService gradeService;

    public GradeEditPage(PageParameters pageParameter) {
        super(pageParameter);
        createModel(pageParameter);
        setDefaultModel(compoundPropertyModel());
        add(createGradeForm());

    }

    private Form<Grade> createGradeForm() {
        Form<Grade> form = new Form<Grade>("form", compoundPropertyModel());
        form.add(createSubmitButton());
        form.add(createGradeTextField());
        return form;
    }

    private CompoundPropertyModel<Grade> compoundPropertyModel() {
        CompoundPropertyModel<Grade> compoundPropertyModel = new CompoundPropertyModel<Grade>(gradeModel);
        return compoundPropertyModel;
    }

    private TextField<String> createGradeTextField() {
        TextField<String> textField = new TextField<String>("");
        return textField;
    }

    private Button createSubmitButton() {
        Button submitButton = new Button("createGradeSubmitButton") {
            @Override
            public void onSubmit() {

                gradeService.Save(gradeModel.getObject());
                setResponsePage(GradeListPage.class);

            }
        };
        return submitButton;

    }

    private void createModel(PageParameters pageParameter) {
        Long id = SaSPageParametersUtil.extractId(pageParameter);
        gradeModel = new GradeModel(id);
    }

}
