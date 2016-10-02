package zw.co.hitrac.sas.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.hitrac.sas.business.domain.Program;

import java.io.Serializable;

/**
 * Created by tndangana on 9/23/16.
 */
public interface ProgramRepo extends JpaRepository<Program,Serializable> {
}
