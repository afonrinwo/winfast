/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.profile.agent.AgentProfileObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface AgentProfileRepository extends CrudRepository<AgentProfileObject, Serializable> {

	Iterable<AgentProfileObject> findByStatus(int status);

	AgentProfileObject findByAgentId(String agentId);

}
