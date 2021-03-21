/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winfast.model.profile.agent.AgentPasswordProfileObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface AgentPasswordProfileRepository extends CrudRepository<AgentPasswordProfileObject, Serializable>{

	AgentPasswordProfileObject findByAgentId(String agentId);

}
