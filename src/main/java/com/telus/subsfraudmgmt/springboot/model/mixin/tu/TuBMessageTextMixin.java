package com.telus.subsfraudmgmt.springboot.model.mixin.tu;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * AFM MessageText should not contain value in json, otherwise 400 bad request.
 * @author Harry Xu
 *
 */
public interface TuBMessageTextMixin {
	
	@JsonIgnore
    abstract String getValue();
	

}
