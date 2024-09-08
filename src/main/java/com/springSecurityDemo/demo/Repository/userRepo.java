package com.springSecurityDemo.demo.Repository;

import com.springSecurityDemo.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);

}
