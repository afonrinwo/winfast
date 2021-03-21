/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winwallet.model.access.AgentAccessCodesObject;
import com.winwallet.model.access.AgentDataObject;
import com.winwallet.model.account.AgentWalletObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface AgentRepository extends CrudRepository<AgentAccessCodesObject, Serializable> {

	AgentDataObject save(AgentDataObject agentDataObject);

	AgentWalletObject save(AgentWalletObject agentWalletObject);

	AgentDataObject findByMsisdn(String msisdn);
	

}
