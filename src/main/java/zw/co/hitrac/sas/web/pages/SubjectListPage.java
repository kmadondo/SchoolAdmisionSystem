/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.hitrac.sas.SaSPageParametersUtil;
import zw.co.hitrac.sas.business.domain.Subject;
import zw.co.hitrac.sas.web.model.SubjectListModel;

/**
 *
 * @author tndangana
 */
public class SubjectListPage extends TemplatePage {

    public SubjectListPage(PageParameters pageParameter) {
        super(pageParameter);
        add(new Link("createNewPage") {
            
            @Override
            public void onClick() {
                setResponsePage(SubjectEditPage.class);
            }
        });
       
    }

    private PropertyListView<Subject> createSubjectListView() {
        PropertyListView<Subject> listView = new PropertyListView<Subject>("subjectListView", new SubjectListModel()) {

            @Override
            protected void populateItem(final ListItem<Subject> li) {
                li.add(nameLabel());
                li. add(new Link("createEditPage") {
            
            @Override
            public void onClick() {
                PageParameters pageParameters = new PageParameters();
                pageParameters.add(SaSPageParametersUtil.ID, li.getModelObject().getId());
                setResponsePage(new SubjectEditPage(pageParameters));
            }
        });
            }
        };

        return listView;
    }

    private Label nameLabel() {
        Label l = new Label(PARENT_PATH);

        return l;
    };
    



}
