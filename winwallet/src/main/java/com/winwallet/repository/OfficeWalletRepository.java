/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winwallet.model.account.OfficeWalletObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface OfficeWalletRepository extends CrudRepository<OfficeWalletObject, Serializable> {

	OfficeWalletObject findByWalletNumber(String walletNumber);

}
