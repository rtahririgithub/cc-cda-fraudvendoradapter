package com.telus.subsfraudmgmt.springboot.model.mixin;

import com.fasterxml.jackson.annotation.JsonFilter;
/**
 * General mixin that utilize json filter "generalFilter"
 * @author Harry Xu
 *
 */
@JsonFilter("generalFilter")
public class PropertyFilterMixIn {

}
