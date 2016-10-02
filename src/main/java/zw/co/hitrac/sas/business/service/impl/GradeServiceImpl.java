
package zw.co.hitrac.sas.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.sas.business.domain.Grade;
import zw.co.hitrac.sas.business.repository.GradeRepo;
import zw.co.hitrac.sas.business.service.GradeService;

/**
 *
 * @author tndangana
 */
@Service
public class GradeServiceImpl  implements GradeService{
     @Autowired
     private GradeRepo gradeRepo;
     
     
     public Grade Save(Grade grade) {
     return gradeRepo.save(grade);
     }

     public List<Grade> findAll(){
     List<Grade> list= gradeRepo.findAll();
     return list;
     }
     
     public Grade find(Long id){
     return gradeRepo.findOne(id);
     
     }
     
     public void delete (Grade grade){ gradeRepo.delete(grade);}

    
     
    }
     
   

