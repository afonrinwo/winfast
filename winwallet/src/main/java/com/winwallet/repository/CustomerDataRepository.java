/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winwallet.model.access.AgentDataObject;
import com.winwallet.model.access.CustomerDataObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface CustomerDataRepository extends CrudRepository<CustomerDataObject, Serializable> {

	boolean existsByMsisdn(String msisdn);

	CustomerDataObject findByMsisdn(String msisdn);

	AgentDataObject save(AgentDataObject agentDataObject);

}
