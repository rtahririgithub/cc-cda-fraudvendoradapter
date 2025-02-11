package com.telus.subsfraudmgmt.springboot.aop.helper;

import com.telus.subsfraudmgmt.api.model.TelusIndividualIdentification;

public class TFMModelDataIntegrityHelper {

	public static String maskPin(String source) {
	
		if (source==null) {
			return null;
		}
		String pattern = "pin: .*(\\s*)";

        return source.replaceAll(pattern, "pin: ***$1");
		
	}
	
	public static String maskIdentificationNumber(TelusIndividualIdentification o) {

		StringBuilder sb = new StringBuilder();
		sb.append("class TelusIndividualIdentification {\n");
		sb.append("    identificationType: ").append(toIndentedString(o.getIdentificationType())).append("\n");
		sb.append("    identificationId: ").append(toIndentedString("***")).append("\n");
		sb.append("    issuingAuthority: ").append(toIndentedString(o.getIssuingAuthority())).append("\n");
		sb.append("    issuingDate: ").append(toIndentedString(o.getIssuingDate())).append("\n");
		sb.append("    validFor: ").append(toIndentedString(o.getIssuingDate())).append("\n");
		sb.append("    attachment: ").append(toIndentedString(o.getAttachment())).append("\n");
		sb.append("    characteristic: ").append(toIndentedString(o.getCharacteristic())).append("\n");
		sb.append("}");
		return sb.toString();

	}
	
	public static String maskSocialInsurance(String source) {
		
		if (source==null) {
			return null;
		}
		String pattern = "\"socialInsuranceNumber\": \".*\",";

        return source.replaceAll(pattern, "\"socialInsuranceNumber\": \"***\",");
		
	}
	
	public static String maskSubjectSin(String source) {
		
		if (source==null) {
			return null;
		}
		String pattern = "\"subjectSin\": \".*\",";

        return source.replaceAll(pattern, "\"subjectSin\": \"***\",");
		
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private static String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
