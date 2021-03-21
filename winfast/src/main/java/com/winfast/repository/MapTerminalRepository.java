/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winfast.model.terminal.TerminalObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface MapTerminalRepository extends CrudRepository<TerminalObject, Serializable> {

	TerminalObject findByTerminalId(String terminalId);

}
