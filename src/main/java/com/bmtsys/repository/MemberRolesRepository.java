package com.bmtsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmtsys.entity.MemberRoles;
import com.bmtsys.entity.Status;

/**
 * created on :  Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Repository
public interface MemberRolesRepository extends JpaRepository<MemberRoles, Long>{

	List<MemberRoles> findByIdIn(List<Long> memberRoleIds);

	List<MemberRoles> findByMemberIdAndStatus(long id, Status active);

}
