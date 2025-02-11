package com.telus.subsfraudmgmt.api.modelmapper.tfm;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.fico.afm.model.application.Disposition;
import com.telus.subsfraudmgmt.api.model.FraudCaseUpdate;
import com.telus.subsfraudmgmt.api.modelmapper.common.MapperCommon;

@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@MapperConfig(unmappedTargetPolicy=ReportingPolicy.WARN)
public interface FraudCaseUpdateMapper extends MapperCommon {
	
	FraudCaseUpdateMapper INSTANCE = Mappers.getMapper( FraudCaseUpdateMapper.class );
	
	@Mappings({
		@Mapping(source = "fraudCase.fraudDisposition.dispositionDateTime", target = "dispositionDateTime", qualifiedByName = "offsetDateTimeToCalendar"),
		@Mapping(source = "fraudCase.fraudDisposition.manuallyReviewedInd", target = "manualReview"),
		@Mapping(source = "fraudCase.fraudDisposition.productActivatedInd", target = "activated"),
		@Mapping(source = "fraudCase.fraudDisposition.fraudStatusCode", target = "fraudDisposition"),
		@Mapping(source = "fraudCase.fraudDisposition.fraudTypeCode", target = "fraudType")
		 
	})
	Disposition fromFraudCaseUpdateToDisposition(FraudCaseUpdate fraudCaseUpdate);
	
}
