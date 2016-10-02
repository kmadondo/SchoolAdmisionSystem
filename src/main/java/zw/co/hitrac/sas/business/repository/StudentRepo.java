/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.hitrac.sas.business.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.hitrac.sas.business.domain.Student;

/**
 *
 * @author tndangana
 */
public interface StudentRepo extends JpaRepository<Student, Serializable> {
    
}
