package pl.myproject.Services;

import pl.myproject.Entities.FamilyMember;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WebClientService {

    private final WebClient webClient;

    public WebClientService() {
        this.webClient = WebClient.create("http://member:10101");;
    }

    public FamilyMember postRequest(FamilyMember familyMember){
        return webClient.post()
                .uri("/api/member")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(familyMember), FamilyMember.class)
                .retrieve()
                .bodyToMono(FamilyMember.class).block();
    }

    public List<FamilyMember> getRequest(Integer familyId){
        return webClient.get()
                .uri("/api/member?familyId="+familyId)
                .retrieve()
                .bodyToFlux(FamilyMember.class).collectList().block();
    }
}
