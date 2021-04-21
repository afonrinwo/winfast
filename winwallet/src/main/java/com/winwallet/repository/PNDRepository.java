/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.account.PNDObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface PNDRepository extends CrudRepository<PNDObject, Serializable> {

	PNDObject findByMsisdn(String msisdn);

}
