//
package zw.co.hitrac.sas.web.pages;

import static org.apache.wicket.Component.PARENT_PATH;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import zw.co.hitrac.sas.SaSPageParametersUtil;
import zw.co.hitrac.sas.business.domain.Gender;
import zw.co.hitrac.sas.web.model.GenderListModel;

/**
 *
 * @author tndangana
 */
public class GenderListPage extends TemplatePage {

    public GenderListPage(PageParameters pageParameter) {
        super(pageParameter);
        add(new Link("createGradePage") {
            
            @Override
            public void onClick() {
                setResponsePage(GradeEditPage.class);
            }
        });
       
    }

    private PropertyListView<Gender> createSubjectListView() {
        PropertyListView<Gender> listView = new PropertyListView<Gender>("gradeListView", new GenderListModel()) {

            @Override
            protected void populateItem(final ListItem<Gender> li) {
                li.add(nameLabel());
                li. add(new Link("createEditPage") {
            
            @Override
            public void onClick() {
                PageParameters pageParameters = new PageParameters();
                pageParameters.add(SaSPageParametersUtil.ID, li.getModelObject().getId());
                setResponsePage(new GenderEditPage(pageParameters));
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
