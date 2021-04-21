/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.access.AgentAccessCodesObject;
import com.winwallet.model.access.AgentDataObject;
import com.winwallet.model.account.AgentWalletObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface AgentRepository extends CrudRepository<AgentAccessCodesObject, Serializable> {

	AgentDataObject save(AgentDataObject agentDataObject);

	AgentWalletObject save(AgentWalletObject agentWalletObject);

	AgentDataObject findByMsisdn(String msisdn);
	

}
