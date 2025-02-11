package com.telus.subsfraudmgmt.api.modelmapper.tfm.util;

import java.util.HashMap;
import java.util.Map;

import com.fico.afm.model.application.types.PackageType;

public class PackageTypeUtil {
	static final Map<String, PackageType> PAKAGETYPE_MAP = buildMap();
	
	public static PackageType derivePackageType(String typeSubtypeCd) {
		if (typeSubtypeCd ==null) {
			return null;
		}
		return PAKAGETYPE_MAP.get(typeSubtypeCd);
	}
	
	private static Map<String, PackageType> buildMap() {
		Map<String, PackageType> map = new HashMap<String, PackageType>();
		
		map.put("IR", PackageType.INDIVIDUAL);
		map.put("BP", PackageType.BUSINESS);
		map.put("CE", PackageType.INDIVIDUAL);
		map.put("CI", PackageType.INDIVIDUAL);
		map.put("IE", PackageType.INDIVIDUAL);
		map.put("IF", PackageType.INDIVIDUAL);
		//ignore IQ, BR using null
		map.put("IQ", null);
		map.put("BR", null);
		
		return map;
		
	}
}
