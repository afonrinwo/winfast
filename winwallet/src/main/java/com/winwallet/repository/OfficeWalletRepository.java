/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.account.OfficeWalletObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface OfficeWalletRepository extends CrudRepository<OfficeWalletObject, Serializable> {

	OfficeWalletObject findByWalletNumber(String walletNumber);

}
