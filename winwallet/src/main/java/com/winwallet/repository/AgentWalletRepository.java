/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winwallet.model.account.AgentWalletObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface AgentWalletRepository extends CrudRepository<AgentWalletObject, Serializable> {

	boolean existsByMsisdn(String msisdn);

	AgentWalletObject findByMsisdn(String msisdn);

}
