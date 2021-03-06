package com.pms.pension.disbursement.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pms.pension.disbursement.exception.AadharNumberNotFound;
import com.pms.pension.disbursement.exception.AuthorizationException;
import com.pms.pension.disbursement.model.PensionerDetail;

import io.swagger.annotations.ApiParam;

@FeignClient(name ="pensionerdetail-microservice",url = "http://890387-pensioner-detail-lb-341589305.us-east-1.elb.amazonaws.com/pensioner/api/final")
public interface PensionDisbursementFeignClient {
	
	@GetMapping("/PensionerDetailByAadhaar/{aadharNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader,
			@ApiParam(name = "aadharNumber", value = "Aadhar Card Number") 
			@PathVariable long aadharNumber) throws AuthorizationException, AadharNumberNotFound;
}
