package ir.rabbitgrout.repository;

import ir.rabbitgrout.domain.SibaAccountForm;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SibaAccountForm entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SibaAccountFormRepository extends JpaRepository<SibaAccountForm, Long> {

}
