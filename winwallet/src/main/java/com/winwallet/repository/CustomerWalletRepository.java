/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winwallet.model.account.CustomerWalletObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface CustomerWalletRepository extends CrudRepository<CustomerWalletObject, Serializable> {

	boolean existsByMsisdn(String msisdn);

	CustomerWalletObject findByMsisdn(String msisdn);

}
