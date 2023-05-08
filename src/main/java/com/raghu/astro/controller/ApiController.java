package com.raghu.astro.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.swisseph.ISwissEph;
import org.swisseph.SwephNative;
import org.swisseph.api.ISweGeoLocation;
import org.swisseph.api.ISweObjects;
import org.swisseph.app.SweGeoLocation;
import org.swisseph.app.SweJulianDate;
import org.swisseph.app.SweObjects;

import com.raghu.astro.domain.response.ApiResponse;
import com.raghu.astro.domain.response.Status;
import com.raghu.astro.util.AppConstants;

@RestController
@RequestMapping("/api/ephemeris")
@CrossOrigin(origins = "*")
public class ApiController {
	
	  public static final ISweGeoLocation GEO_NEWDELHI = new SweGeoLocation(77.209023,28.613939,239); 
	  protected static final ThreadLocal<ISwissEph> SWEPH_EXPS = new ThreadLocal<>(); 
	  public static final   String EPHE_PATH = "ephe";
	 

	
	@GetMapping("/health")
	   public ResponseEntity<ApiResponse> checkHealth() {
			
			  Calendar now = new GregorianCalendar(2023,4,3,13,30); ISwissEph swissEph =
			  getSwephExp(); SweJulianDate julianDate = new SweJulianDate(now);
			  
			  
			  ISweObjects sweObjects = new SweObjects(swissEph,julianDate, GEO_NEWDELHI,
			  org.swisseph.app.SweObjectsOptions.LAHIRI_AYANAMSA).completeBuild();
			 
			
		    ApiResponse apiResponse = new ApiResponse();
		    apiResponse.setStatus(new Status(AppConstants.STATUS_SUCCESS));
		    ArrayList arrayList = new ArrayList(); 
		   // arrayList.add(sweObjects);
		    apiResponse.setPayload(arrayList);
		    return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	   }
	
		
		  public static ISwissEph getSwephExp() { ISwissEph swissEph =
		  SWEPH_EXPS.get();
		  
		  if (null == swissEph) { swissEph = newSwephExp(); SWEPH_EXPS.set(swissEph); }
		  
		  return swissEph; }
		  
		  protected static SwephNative newSwephExp() { return new
		  SwephNative(EPHE_PATH); }
		 
}
