package zw.co.hitrac.sas.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import zw.co.hitrac.sas.business.domain.Grade;

/**
 * Created by tndangana on 9/23/16.
 */
public interface GradeRepo extends JpaRepository<Grade,Serializable>{
}
