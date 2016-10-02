/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.pages;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.hitrac.sas.SaSPageParametersUtil;
import zw.co.hitrac.sas.business.domain.Gender;
import zw.co.hitrac.sas.web.model.GenderModel;

/**
 *
 * @author tndangana
 */
public class GenderEditPage extends TemplatePage {

    private GenderModel genderModel;
    private Long id;

    public GenderEditPage(PageParameters pageParameter) {
        super(pageParameter);
        createModel(pageParameter);
        add(new FeedbackPanel("feedback"));
        setDefaultModel(createCompoundPropertyModel());
        add(createForm());

    }

    private CompoundPropertyModel<Gender> createCompoundPropertyModel() {
        CompoundPropertyModel<Gender> compoundPropertyModel;
        compoundPropertyModel = new CompoundPropertyModel<Gender>(genderModel);
        return compoundPropertyModel;
    }

    private Form<Gender> createForm() {
        Form<Gender> form;
        form = new Form<Gender>("form", createCompoundPropertyModel());
        form.add(genderTextField());
        return form;
    } 
    private TextField<Gender> genderTextField() {
        TextField<Gender> textField;
        textField = new TextField<Gender>("genderType");

        return textField;
    }

    private void createModel(PageParameters pageParameter) {
         Long id = SaSPageParametersUtil.extractId(pageParameter);
        genderModel = new GenderModel(id);
    }

}
