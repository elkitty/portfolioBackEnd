
package com.portfolio.api.Repository;

import com.portfolio.api.Model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
    
}
