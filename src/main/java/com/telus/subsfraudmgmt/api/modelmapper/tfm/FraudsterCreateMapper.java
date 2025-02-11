package com.telus.subsfraudmgmt.api.modelmapper.tfm;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.fico.afm.model.application.Address;
import com.fico.afm.model.application.Email;
import com.fico.afm.model.application.Person;
import com.fico.afm.model.application.Phone;
import com.telus.subsfraudmgmt.api.model.ContactMedium;
import com.telus.subsfraudmgmt.api.model.ContactMediumRefOrValue;
import com.telus.subsfraudmgmt.api.model.FraudsterCreate;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;

@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@MapperConfig(unmappedTargetPolicy=ReportingPolicy.WARN)

public interface FraudsterCreateMapper extends CustomerToApplicantsMapper {
	
	FraudsterCreateMapper INSTANCE = Mappers.getMapper( FraudsterCreateMapper.class );
	
 
    default com.fico.afm.model.application.Individual fromFraudsterCreateToAfmIndividual(FraudsterCreate fraudsterCreate) {
    	
    	com.fico.afm.model.application.Individual afmIndividual = null;
    	 
    	//source objects making map easy
    	com.telus.subsfraudmgmt.api.model.Individual apiIndividual = null;
    	
    	if (fraudsterCreate ==null) {
    		return afmIndividual;
    	} 
    	
    	afmIndividual = new com.fico.afm.model.application.Individual();
    	afmIndividual.setApplicationId(fraudsterCreate.getExternalApplicationId());
    	Person person = new Person();
    	afmIndividual.setPerson(person);

    	if (fraudsterCreate.getIndividual() !=null &&  fraudsterCreate.getIndividual().getValue() !=null) {
    		apiIndividual =  fraudsterCreate.getIndividual().getValue();
    		
    		updatePersonNonUserDataFromIndividual (apiIndividual, person);
    	}
    	if (apiIndividual != null && apiIndividual.getContactMedium()!=null && !apiIndividual.getContactMedium().isEmpty()) {
			for (ContactMediumRefOrValue refOrValue: apiIndividual.getContactMedium()) {
				ContactMedium contactMedium = refOrValue.getValue();
				if (contactMedium ==null || contactMedium.getMediumType() ==null) {
					continue;
				}
				if ("ADDRESS".equalsIgnoreCase(contactMedium.getMediumType())) {
					Address address = fromContactMediaToAddressMainContents (contactMedium);
					if (address!=null) {
						//address5, streetName etc has to be in user data
						TelusBillingAccount account = null; //no account info
						AddressUserData addressUserData = mapToApplicantAddressUserData(account, contactMedium);
						address.getUserData().addAll(this.toAFMUserDataList(addressUserData));
						afmIndividual.setAddress(address);
					}
				}
				if ("EMAIL".equalsIgnoreCase(contactMedium.getMediumType())) {
					Email email = fromContactMediaToEmail(contactMedium);
					if (email !=null) {
						afmIndividual.setEmail(email);
					}
				}
				if (contactMedium.getMediumType().toUpperCase().endsWith("PH")) {
				   //HOPH- Home Phone
                   // WKPH - Business Phone
                   //DYPH- Contact Phone
                   //WKPH - Other Phone

					Phone phone = fromContactMediaToPhone(contactMedium);
					if (phone !=null) {
						afmIndividual.getPhone().add(phone);
					}
				}

			}	
			
		}
    	return afmIndividual;
    	 
    }
    
    
	@Mapping(source="birthDate", target="birthDate", qualifiedByName = "offsetDateTimeToCalendar")
	@Mapping(target="primaryIdentificationType", constant = NATIONAL_ID)
	@Mapping(source="individual", target="primaryIdentificationNumber", qualifiedByName = "derivepPimaryIdentificationNumber")
	@Mapping(source="individual", target="primaryIdentificationSupplemental", qualifiedByName = "derivepPimaryIdentificationSupplementalNumber")
	@Mapping(target="secondaryIdentificationType", constant = DRIVERS_LICENSE)
	@Mapping(source="individual", target="secondaryIdentificationNumber", qualifiedByName = "derivepSecondaryIdentificationNumber")
	@Mapping(source="individual", target="secondaryIdentificationSupplemental", qualifiedByName = "derivepSecondaryIdentificationSupplementalNumber")
	 
	//
	//Based on Name tab
	//
	@Mapping(source="givenName", target="name.first")
	@Mapping(source="middleName", target="name.middle")
	@Mapping(source="familyName", target="name.last")
	
	void updatePersonNonUserDataFromIndividual(com.telus.subsfraudmgmt.api.model.Individual individual, @MappingTarget Person person);



}