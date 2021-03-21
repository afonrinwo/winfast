/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.profile.system.SystemProfileObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface SystemProfileRepository extends CrudRepository<SystemProfileObject, Serializable> {

	SystemProfileObject findByAppId(String appId);

	Iterable<SystemProfileObject> findByStatus(int status);


}
