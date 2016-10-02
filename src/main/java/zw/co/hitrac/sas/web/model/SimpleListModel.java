//
//
//package zw.co.hitrac.sas.web.model;
//
//import java.util.List;
//import java.util.Objects;
//import org.apache.wicket.model.LoadableDetachableModel;
//import zw.co.hitrac.sas.IService;
//
///**
// *
// * @author tndangana
// */
//public class SimpleListModel <T> extends LoadableDetachableModel<List<T>>{
//    
//    private final IService<T> service;
//
//    public SimpleListModel(final Class<T> tClass, final IService<T> service) {
//
//        this.service = Objects.requireNonNull(service, getMissingFieldMessage("generic service"));
//
//    }
//
//    @Override
//    protected List<T> load() {
//
//        return getNullSafeList(service.findAll());
//    }
//    
//}
