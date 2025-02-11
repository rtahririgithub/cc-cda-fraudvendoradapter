package com.telus.subsfraudmgmt.springboot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "@type" })
public interface EntityMixin {

}
