package warsztaty.spring.ailleron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import warsztaty.spring.ailleron.model.RestResponse;
import warsztaty.spring.ailleron.model.RootObject;

import java.util.Locale;

@Service
public class CountryService {

    @Autowired
    private RestTemplate restTemplate; // RestTemplate: obiekt do komunikacji sieciowej po restach z metodami http

    @Autowired
    private MessageSource messageSource;

    private final static String COUNTRY_CODE_URL = "http://www.groupkt.com/country/get/iso2code/";

    public RestResponse getCountryFromRestApi(String code){
        ResponseEntity<RootObject> rootResponse = getDataFromApi(code);
        if(rootResponse.getStatusCode().is2xxSuccessful()){
            RestResponse restResponse = rootResponse.getBody().getRestResponse();
            restResponse.setSayHello(
                    messageSource.getMessage(
                            "hello.message",null, Locale.forLanguageTag(code)
                    )
            );
            return restResponse;
        }
        return null;
    }

    private ResponseEntity<RootObject> getDataFromApi(String code) {
        return restTemplate.getForEntity(
                UriComponentsBuilder.fromHttpUrl(COUNTRY_CODE_URL + code).build().toUri(), RootObject.class
        );
    }
}
