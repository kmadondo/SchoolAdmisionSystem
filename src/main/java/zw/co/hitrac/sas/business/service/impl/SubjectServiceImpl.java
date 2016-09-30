/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.sas.business.domain.Subject;
import zw.co.hitrac.sas.business.repository.SubjectRepo;
import zw.co.hitrac.sas.business.service.SubjectService;

/**
 *
 * @author tndangana
 */
@Service 
public class SubjectServiceImpl implements SubjectService {
@Autowired
private SubjectRepo subjectRepo;
    
    public Subject Save(Subject  subject) {
        return subjectRepo.findOne(subject);
    }

    public List<Subject> findAll() {
       return subjectRepo.findAll();
    }

    public Subject find(Long id) {
       return subjectRepo.findOne(id);
    }

    public void delete(Subject subject) {
       subjectRepo.delete(subject);
    }
    
}
