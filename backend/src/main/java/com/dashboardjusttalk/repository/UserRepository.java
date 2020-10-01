package com.dashboardjusttalk.repository;

import com.dashboardjusttalk.Dto.UserAccessDto;
import com.dashboardjusttalk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUser(String user);
    boolean findByUserAndPassword(String user, String Password);
    boolean existsByUserAndPassword(String user, String Password);
    User getByUser(String user);
}
