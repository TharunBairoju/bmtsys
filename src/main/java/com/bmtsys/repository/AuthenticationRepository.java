package com.bmtsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmtsys.entity.Authentication;

/**
 * created on :  Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long>{

	Authentication findByUserName(String userName);

}
