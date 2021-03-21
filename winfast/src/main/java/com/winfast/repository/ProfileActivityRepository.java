/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.profile.ProfileActivityLogObject;


/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface ProfileActivityRepository extends CrudRepository<ProfileActivityLogObject, Serializable> {

	ProfileActivityLogObject findByUserName(String userName);

}
