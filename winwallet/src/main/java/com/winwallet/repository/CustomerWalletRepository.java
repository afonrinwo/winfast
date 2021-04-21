/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.account.CustomerWalletObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface CustomerWalletRepository extends CrudRepository<CustomerWalletObject, Serializable> {

	boolean existsByMsisdn(String msisdn);

	CustomerWalletObject findByMsisdn(String msisdn);

}
