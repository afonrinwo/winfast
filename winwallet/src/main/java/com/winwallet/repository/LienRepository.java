/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.account.LienObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface LienRepository extends CrudRepository<LienObject, Serializable> {

	LienObject findByMsisdn(String msisdn);

}
