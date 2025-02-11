package com.telus.subsfraudmgmt.api.modelmapper.tfm;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fico.afm.model.application.Disposition;
import com.telus.subsfraudmgmt.api.model.FraudActivityUpdate;
import com.telus.subsfraudmgmt.api.modelmapper.common.MapperCommon;

@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@MapperConfig(unmappedTargetPolicy=ReportingPolicy.WARN)
public interface FraudActivityUpdateMapper extends MapperCommon {
	
	FraudActivityUpdateMapper INSTANCE = Mappers.getMapper( FraudActivityUpdateMapper.class );
	
	@Mappings({
		@Mapping(source = "fraudDisposition.dispositionDateTime", target = "dispositionDateTime", qualifiedByName = "offsetDateTimeToCalendar"),
		@Mapping(source = "fraudDisposition.manuallyReviewedInd", target = "manualReview"),
		@Mapping(source = "fraudDisposition.productActivatedInd", target = "activated"),
		@Mapping(source = "fraudDisposition.fraudStatusCode", target = "fraudDisposition"),
		@Mapping(source = "fraudDisposition.fraudTypeCode", target = "fraudType")
	})
	Disposition fromFraudActiveUpdateToDisposition(FraudActivityUpdate fraudActivityUpdate);
	 
}