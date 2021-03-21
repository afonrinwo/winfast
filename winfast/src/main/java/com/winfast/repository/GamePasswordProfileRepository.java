/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winfast.model.profile.game.GamePasswordProfileObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface GamePasswordProfileRepository extends CrudRepository<GamePasswordProfileObject, Serializable> {

	Object findByUserId(String userId);

}
