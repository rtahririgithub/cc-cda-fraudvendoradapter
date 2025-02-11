package com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.subsfraudmgmt.springboot.util.JsonUtil;

/**
 * Manually parsing bureauReport into Map view considering the dynamicness, and
 * the parsing is generic enough to be usable for both Equifax and TransUnion
 * (TU).
 * <p>
 * Parsed data to <code>ParsedResponse</code> to have a map of segment name to
 * segment holder values which wraps data, and potential error, warning key
 * value pairs.
 * 
 * @author Harry Xu
 *
 */
public class TfmBureauReports {

	private List<TfmBureauReport> tfmBureauReportList = new ArrayList<>();


	public List<TfmBureauReport> getTfmBureauReportList() {
		return tfmBureauReportList;
	}

	public void setTfmBureauReportList(List<TfmBureauReport> tfmBureauReportList) {
		this.tfmBureauReportList = tfmBureauReportList;
	}

	//
	//Reports have list of report
	//
	public static class TfmBureauReport {
		private List<TfmParsedResponse> tfmParsedResponseList = new ArrayList<>();

		public List<TfmParsedResponse> getTfmParsedResponseList() {
			return tfmParsedResponseList;
		}

		public void setTfmParsedResponseList(List<TfmParsedResponse> tfmParsedResponseList) {
			this.tfmParsedResponseList = tfmParsedResponseList;
		}

	}


	//
	// report has list of PrasedResponse
	//
	public static class TfmParsedResponse {
		//Top level errors: content="[{\"error\":{\"error1\":\"Input Equifax FFF is invalid!\"}}]", errors is one entry with key=error1
		private  Map<String, String> errors = new HashMap<>();
		//Key is the segment name, value is a list of segment holder, while in some cases could be a list of single entry
		private Map<String, List<SegmentHolder>> segmentNameToHolderMap = new HashMap<>();
		
		private boolean equifax;
		private boolean transunion;
        
		
        
		public boolean isEquifax() {
			return equifax;
		}

		public void setEquifax(boolean equifax) {
			this.equifax = equifax;
		}

		public boolean isTransunion() {
			return transunion;
		}

		public void setTransunion(boolean transunion) {
			this.transunion = transunion;
		}

		public Map<String, String> getErrors() {
			return errors;
		}

		public void setErrors(Map<String, String> errors) {
			this.errors = errors;
		}
		
		/**
		 * A segment data could be a list, such segment nameOrAlias, this will give the first item in the list.
		 * <p>Convinience method for segment that has one instace, such as "header" segment.
		 * @param segmentName the segment name such as "header", "nameOrAlias" as documented in https://docs.google.com/spreadsheets/d/1MgpKm-c7ZW9Ca3aWtmui7CZtKfW0ww09/edit#gid=1205639842
		 * @return the kv pairs in that segment
		 */
		public Map<String, String> getFirstSegmentDataBySegmentName(String segmentName) {
			List<Map<String, String>> list = getSegmentDataList(segmentName);
			if (list==null || list.isEmpty()) {
				return new HashMap<String, String>();
			}
			return list.get(0);
		}

		public List<Map<String, String>> getSegmentDataList(String segmentName) {
			List<Map<String, String>> flatview = new ArrayList<Map<String, String>>();
			List<SegmentHolder> holderList= segmentNameToHolderMap.get(segmentName);
			if (holderList==null || holderList.isEmpty()) {
				return flatview;
			}
			for (SegmentHolder holder: holderList) {
				flatview.add(holder.getDataProperties());
			}
			return flatview;
		}
		
		public Map<String, String> getFirstSegmentErrorBySegmentName(String segmentName) {
			List<Map<String, String>> list = getSegmentErrorList(segmentName);
			if (list==null || list.isEmpty()) {
				return new HashMap<String, String>();
			}
			return list.get(0);
		}
		public List<Map<String, String>> getSegmentErrorList(String segmentName) {
			List<Map<String, String>> flatview = new ArrayList<Map<String, String>>();
			List<SegmentHolder> holderList= segmentNameToHolderMap.get(segmentName);
			if (holderList==null || holderList.isEmpty()) {
				return flatview;
			}
			for (SegmentHolder holder: holderList) {
				flatview.add(holder.getErrors());
			}
			return flatview;
		}
		

		public Map<String, String> getFirstSegmentWarningBySegmentName(String segmentName) {
			List<Map<String, String>> list = getSegmentWarningList(segmentName);
			if (list==null || list.isEmpty()) {
				return new HashMap<String, String>();
			}
			return list.get(0);
		}
		public List<Map<String, String>> getSegmentWarningList(String segmentName) {
			List<Map<String, String>> flatview = new ArrayList<Map<String, String>>();
			List<SegmentHolder> holderList= segmentNameToHolderMap.get(segmentName);
			if (holderList==null || holderList.isEmpty()) {
				return flatview;
			}
			for (SegmentHolder holder: holderList) {
				flatview.add(holder.getWarnings());
			}
			return flatview;
		}
		
		public void addSegmentHolder(String segmentName, SegmentHolder holder) {
			List<SegmentHolder> holderList = segmentNameToHolderMap.get(segmentName);
			if (holderList==null) {
				holderList = new ArrayList<SegmentHolder>();
				segmentNameToHolderMap.put(segmentName,  holderList);
			}
			holderList.add(holder);
		}

		public boolean hasTopError() {
			return errors!=null && !errors.isEmpty();
		}
		
		public String getFirstErrorMsg() {
			if (errors.size()==0) {
				return null;
			}
			return errors.entrySet().iterator().next().getValue();
		}
		
		//The first segment which has warning message
		public String getFirstSegmentParseWarning() {
			Set<String> segmentNames = this.segmentNameToHolderMap.keySet();
			if (segmentNames ==null || segmentNames.isEmpty()) {
				return null;
			}
			Iterator<String> segmentNamesIterator = segmentNames.iterator();
			while (segmentNamesIterator.hasNext()) {
				Map<String, String> segmentWarnings = this.getFirstSegmentWarningBySegmentName(segmentNamesIterator.next());
				if (segmentWarnings!=null && !segmentWarnings.isEmpty()) {
					String firstWarningMessage= segmentWarnings.values().iterator().next();
					if (firstWarningMessage!=null) {
						return firstWarningMessage;
					}
				}
			}
			return null;
		}

		//for EQFX:  Header.totalNumberOfInquiries
		//for TU: creditSummary.numberOfInquiries"
		public String getTotalNumberOfInquiries() {
			Map<String, String> segmentData = null;
			if (this.isEquifax()) {
				segmentData = this.getFirstSegmentDataBySegmentName("header");
				if (segmentData!=null && isNonNullOrEmpty(segmentData.get("totalNumberOfInquiries"))) {
					return segmentData.get("totalNumberOfInquiries").trim();
				}else {
					return "";
				}
			}else if (this.isTransunion()) {
			 
				segmentData = this.getFirstSegmentDataBySegmentName("creditSummary");
				if (segmentData!=null && isNonNullOrEmpty(segmentData.get("numberOfInquiries"))) {
					return segmentData.get("numberOfInquiries").trim();
				}
				return "";
			}
			return "";
			
		}

		//For EQFX:  Header.creditFileWarningMessage
		//for TU: subjectHeader.consumerStatementIndicator"

		public String getCreditFileWarningMessage() {

			Map<String, String> segmentData = null;
			if (this.isEquifax()) {
				segmentData = this.getFirstSegmentDataBySegmentName("header");
				if (segmentData!=null && isNonNullOrEmpty(segmentData.get("creditFileWarningMessage"))) {
					return segmentData.get("creditFileWarningMessage").trim();
				}else {
					return "";
				}
			}else if (this.isTransunion()) {
				segmentData = this.getFirstSegmentDataBySegmentName("subjectHeader");
				if (segmentData!=null && isNonNullOrEmpty(segmentData.get("consumerStatementIndicator"))) {
					return segmentData.get("consumerStatementIndicator").trim();
				}
				return "";
			}
			return "";

		}
		
		private boolean isNonNullOrEmpty(String value) {
			return value!=null && !value.trim().isEmpty();
		}

		
	}


	/**
	 * Main method to parse the json string to map view - not java beans view considering dynamicness
	 *
	 */
	public static TfmBureauReports parseTfmBureauReport(String content, boolean equifax) throws Exception {
		if (content ==  null || content.trim().isEmpty()) {
			return null;
		}
		TfmBureauReports tfmEfuBureauReports = new TfmBureauReports();

		ObjectMapper objectMapper = new ObjectMapper();
		//parse it into TfmParsedResponse
		TfmParsedResponse tfmParsedResponse = new TfmParsedResponse();
		
		tfmParsedResponse.setEquifax(equifax);
		tfmParsedResponse.setTransunion(!equifax);
		
		traverse(objectMapper.readTree(content), tfmParsedResponse, objectMapper);

		TfmBureauReport tfmBureauReport = new TfmBureauReport();
		
		tfmBureauReport.getTfmParsedResponseList().add(tfmParsedResponse);
		tfmEfuBureauReports.getTfmBureauReportList().add(tfmBureauReport);

		return tfmEfuBureauReports;

	}

	//
	//Holder segment segmentNameToHolderMap and related errors or warnings
	//
	public static class SegmentHolder {
		private  Map<String, String> errors;
		private Map<String, String> warnings;
		//The key in reality is a segment such as "alsoKnownAs", and thus a single entry map, the value map is a segment properties map
		private Map<String, String> data = new HashMap<>();

		public Map<String, String> getErrors() {
			return errors;
		}
		public void setErrors(Map<String, String> errors) {
			this.errors = errors;
		}
		public Map<String, String> getWarnings() {
			return warnings;
		}
		public void setWarnings(Map<String, String> warnings) {
			this.warnings = warnings;
		}
		//flatten view of data map
		public Map<String, String> getDataProperties() {
			return this.data;
		}

		public void setData(Map<String, String> segmentData) {
			this.data =  segmentData;
		}
		
		public String getFirstParseError() {
			if (this.errors==null || this.errors.isEmpty()) {
				return null;
			}
			return this.errors.values().iterator().next();
		}
		
		public String getFirstParseWaring() {
			if (this.warnings==null || this.warnings.isEmpty()) {
				return null;
			}
			return this.warnings.values().iterator().next();
		}


	}


	private static void  traverse(JsonNode jsonNode, TfmParsedResponse tfmParsedResponse, ObjectMapper objectMapper) throws Exception{
		if (jsonNode.isArray()) {
			for (JsonNode subNode: jsonNode) {
				traverse(subNode, tfmParsedResponse, objectMapper);	
			}
		}else {
			//top level node that is not an array
			Map<String,String> errors = null;
			Map<String,String> warnings = null;
			Map<String, String> data = null;

			String segmentName = null; // data portion contains key
			int noOfchildren = 0;
			Iterator<Map.Entry<String, JsonNode>> childItertor= jsonNode.fields();

			while(childItertor.hasNext()) {
				noOfchildren ++;
				Map.Entry<String, JsonNode> entry = childItertor.next();
				if (entry.getKey().equals("error") && entry.getValue() !=null) {
					errors = objectMapper.readValue(entry.getValue().toString(), Map.class) ;
				}
				else if (entry.getKey().equals("warning") && entry.getValue() !=null) {
					warnings = objectMapper.readValue(entry.getValue().toString(), Map.class) ;
				}else if (entry.getValue() !=null){
					segmentName = entry.getKey();
					data  = objectMapper.readValue(entry.getValue().toString(), Map.class);
					
				}
			}

			if (noOfchildren ==1 && data ==null && errors!=null) {
				//top level error
				tfmParsedResponse.setErrors(errors);
			}
			else if (noOfchildren >1 && !(errors==null && warnings==null && data==null)) {
				//a segment
				SegmentHolder segmentHolder = new SegmentHolder();
				segmentHolder.setErrors(errors); //in reality only capture 1 error
				segmentHolder.setWarnings(warnings); //in reality only capture 1 warning
				segmentHolder.setData(data);

				tfmParsedResponse.addSegmentHolder(segmentName, segmentHolder);
			}

		}
	}	

}
