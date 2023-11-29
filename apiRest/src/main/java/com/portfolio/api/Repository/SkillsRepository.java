
package com.portfolio.api.Repository;

import com.portfolio.api.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skill, Integer> {
    
}
