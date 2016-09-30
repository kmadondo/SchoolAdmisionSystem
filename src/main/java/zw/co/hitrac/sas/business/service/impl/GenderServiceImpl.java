/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.sas.business.domain.Gender;
import zw.co.hitrac.sas.business.repository.GenderRepo;
import zw.co.hitrac.sas.business.service.GenderService;

/**
 *
 * @author tndangana
 */
@Service
public class GenderServiceImpl implements GenderService
{
    @Autowired
    private GenderRepo genderRepo;

    public Gender Save(Gender gender) {
       return genderRepo.save(gender);//To change body of generated methods, choose Tools | Templates.
    }

    public List<Gender> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Gender find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Gender t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
