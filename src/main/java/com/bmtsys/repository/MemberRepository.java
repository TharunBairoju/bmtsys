package com.bmtsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmtsys.entity.Member;

/**
 * created on :  Oct 7, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	Member findByAuthenticationId(long id);

}
