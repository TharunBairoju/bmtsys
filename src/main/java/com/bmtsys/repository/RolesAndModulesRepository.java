package com.bmtsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmtsys.entity.RolesAndModules;

/**
 * created on :  Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */

@Repository
public interface RolesAndModulesRepository extends JpaRepository<RolesAndModules, Long>{

}
