/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winwallet.model.AccessLogObject;
import com.winwallet.model.access.AccessCodesObject;
import com.winwallet.model.access.AgentAccessCodesObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface AccessRepository extends CrudRepository<AccessCodesObject, Serializable> {

	AccessCodesObject findByMsisdn(String msisdn);

	AccessLogObject save(AccessLogObject accessLogObject);

}
