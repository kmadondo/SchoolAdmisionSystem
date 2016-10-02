package zw.co.hitrac.sas.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import zw.co.hitrac.sas.business.domain.Subject;

/**
 * Created by tndangana on 9/23/16.
 */
public interface SubjectRepo extends JpaRepository<Subject,Serializable> {
}
