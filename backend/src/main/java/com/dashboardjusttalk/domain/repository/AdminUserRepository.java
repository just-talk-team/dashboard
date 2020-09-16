package com.dashboardjusttalk.domain.repository;


import com.dashboardjusttalk.persistence.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface AdminUserRepository extends JpaRepository<AdminUser, String> {

    @Query("from AdminUser where userName=:username and password=:password")
    AdminUser getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
