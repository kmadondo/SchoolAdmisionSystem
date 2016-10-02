/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.web.pages;


import static org.apache.wicket.Component.PARENT_PATH;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.hitrac.sas.SaSPageParametersUtil;
import zw.co.hitrac.sas.business.domain.Grade;
import zw.co.hitrac.sas.web.model.GradeListModel;

import org.apache.wicket.request.mapper.parameter.PageParameters;


/**
 *
 * @author tndangana
 */
public class GradeListPage  extends TemplatePage  {

    public GradeListPage(PageParameters pageParameter) {
        super(pageParameter);

        add(new Link("createGradePage") {
            
            @Override
            public void onClick() {
                setResponsePage(GradeEditPage.class);
            }
        });
       
    }

    private PropertyListView<Grade> createSubjectListView() {
        PropertyListView<Grade> listView = new PropertyListView<Grade>("gradeListView", new GradeListModel()) {

            @Override
            protected void populateItem(final ListItem<Grade> li) {
                li.add(nameLabel());
                li. add(new Link("createEditPage") {
            
            @Override
            public void onClick() {
                PageParameters pageParameters = new PageParameters();
                pageParameters.add(SaSPageParametersUtil.ID, li.getModelObject().getId());
                setResponsePage(new GradeEditPage(pageParameters));
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
