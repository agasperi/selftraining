package com.tdp.ms.angular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tdp.ms.angular.model.dao.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
}
