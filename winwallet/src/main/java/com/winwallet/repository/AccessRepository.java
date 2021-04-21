/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.access.AccessCodesObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface AccessRepository extends CrudRepository<AccessCodesObject, Serializable> {

	AccessCodesObject findByMsisdn(String msisdn);
}
