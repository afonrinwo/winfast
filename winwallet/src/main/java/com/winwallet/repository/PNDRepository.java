/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winwallet.model.account.PNDObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface PNDRepository extends CrudRepository<PNDObject, Serializable> {

	PNDObject findByMsisdn(String msisdn);

}
