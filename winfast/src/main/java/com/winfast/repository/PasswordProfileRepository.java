/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.profile.user.UserPasswordProfileObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface PasswordProfileRepository extends CrudRepository<UserPasswordProfileObject, Serializable> {

	UserPasswordProfileObject findByUserName(String userName);


}
