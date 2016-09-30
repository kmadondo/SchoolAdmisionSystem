/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.hitrac.sas.business.domain.Program;
import zw.co.hitrac.sas.business.repository.ProgramRepo;
import zw.co.hitrac.sas.business.service.ProgramService;

/**
 *
 * @author tndangana
 */
@Service
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    private ProgramRepo programRepo;
    
    public Program Save (Program program){
    Program program1 = programRepo.save(program);
    return program1;
    }
    
    public Program find (Long id){
    return programRepo.findOne(id);
    
    }
    
    public List<Program> findAll(){
    return programRepo.findAll();
    }
    
    public void delete(Program program){
    programRepo.delete(program);
    }
    
}
