package com.bmtsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmtsys.entity.Module;
import com.bmtsys.entity.Status;

/**
 * created on :  Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Repository
public interface ModuleRepository extends JpaRepository<Module, Long>{

	List<Module> findByStatus(Status active);

}
