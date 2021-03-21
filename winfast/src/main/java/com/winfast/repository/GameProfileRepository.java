/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winfast.model.profile.game.GameProfileObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface GameProfileRepository extends CrudRepository<GameProfileObject, Serializable> {
	
	Iterable<GameProfileObject> findByStatus(int status);

	GameProfileObject findByUserId(String userId);

}
