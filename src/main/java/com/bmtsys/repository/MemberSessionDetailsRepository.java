package com.bmtsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmtsys.entity.MemberSessionDetails;

/**
 * created on :  Oct 10, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Repository
public interface MemberSessionDetailsRepository extends JpaRepository<MemberSessionDetails, Long>{

	MemberSessionDetails findByMemberId(long id);

}
