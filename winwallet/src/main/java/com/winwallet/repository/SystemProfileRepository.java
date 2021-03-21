/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.system.SystemProfileObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface SystemProfileRepository extends CrudRepository<SystemProfileObject, Serializable> {

	SystemProfileObject findByAppId(String header2);

}
