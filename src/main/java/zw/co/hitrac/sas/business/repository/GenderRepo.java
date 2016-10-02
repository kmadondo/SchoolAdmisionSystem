package zw.co.hitrac.sas.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import zw.co.hitrac.sas.business.domain.Gender;

/**
 * Created by tndangana on 9/23/16.
 */
public interface GenderRepo extends JpaRepository <Gender,Serializable> {
}
