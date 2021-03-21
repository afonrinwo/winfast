/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.games.InstantMillionObject;


/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface InstantMillionRepository extends CrudRepository<InstantMillionObject, Serializable> {

	InstantMillionObject findBySourceUid(String sourceUid);

	InstantMillionObject findByMobileNumberAndSourceUidContains(String mobileNumber, String ticketId);

}
