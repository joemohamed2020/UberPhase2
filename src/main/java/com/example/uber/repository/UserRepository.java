package com.example.uber.repository;

import com.example.uber.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//database
@Repository
public interface UserRepository extends JpaRepository <UserData,String> {

}
