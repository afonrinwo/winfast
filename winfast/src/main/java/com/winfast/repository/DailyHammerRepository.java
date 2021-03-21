/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.games.DailyHammerObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface DailyHammerRepository extends CrudRepository<DailyHammerObject, Serializable> {

	DailyHammerObject findBySourceUid(String sourceUid);

	DailyHammerObject findByMobileNumberAndSourceUidLike(String mobileNumber, String sourceUid);

	DailyHammerObject findByMobileNumberAndSourceUidContains(String mobileNumber, String sourceUid);

	DailyHammerObject findByMobileNumber(String mobileNumber);

	DailyHammerObject findBySourceUidContains(String ticketId);

}
