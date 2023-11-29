
package com.portfolio.api.Repository;

import com.portfolio.api.Model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findOneByEmail(String email);

}
