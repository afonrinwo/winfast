/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.account.AgentWalletObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface AgentWalletRepository extends CrudRepository<AgentWalletObject, Serializable> {

	boolean existsByMsisdn(String msisdn);

	AgentWalletObject findByMsisdn(String msisdn);

}
