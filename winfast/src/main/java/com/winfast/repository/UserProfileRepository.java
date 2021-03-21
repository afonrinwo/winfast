/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.profile.user.UserProfileObject;


/**
 * @author Emmanuel Afonrinwo
 *
 *
 */
@Repository
public interface UserProfileRepository extends CrudRepository<UserProfileObject, Serializable> {

	Iterable<UserProfileObject> findByStatus(int status);

	UserProfileObject findByUserName(String userName);

}
