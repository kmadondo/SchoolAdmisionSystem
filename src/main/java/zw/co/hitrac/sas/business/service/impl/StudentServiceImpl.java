/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.sas.business.domain.Student;
import zw.co.hitrac.sas.business.repository.StudentRepo;
import zw.co.hitrac.sas.business.service.StudentService;

/**
 *
 * @author tndangana
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student Save(Student student) {
        return  studentRepo.save(student) ;
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Student find(Long id) {
 return studentRepo.findOne(id);
    }

    public void delete(Student student) {
    studentRepo.delete(student);    }

   
    
}
