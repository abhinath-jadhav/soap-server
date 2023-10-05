package com.tutorial.soap.server;

import com.tutorial.soap.gen.GetCountryRequest;
import com.tutorial.soap.gen.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAME_SPACE = "http://www.tutorial.com/soap/gen";

    @Autowired
    private CountryService countryService;

    @PayloadRoot(namespace = NAME_SPACE, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
        GetCountryResponse getCountryResponse = new GetCountryResponse();

        getCountryResponse.setCountry(countryService.findCountry(request.getName()));
        return getCountryResponse;
    }

}
