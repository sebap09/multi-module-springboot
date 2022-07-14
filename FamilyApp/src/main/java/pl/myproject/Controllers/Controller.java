package pl.myproject.Controllers;

import pl.myproject.Entities.Family;
import pl.myproject.Services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/family")
public class Controller {

    private final FamilyService familyService;

    @Autowired
    public Controller(FamilyService familyService) {
        this.familyService = familyService;
    }

    @PostMapping
    public ResponseEntity<?> createFamily(@RequestBody final Family family) {
            familyService.validateFamilyData(family);
            Integer familyId = familyService.generateFamilyId();
            family.setId(familyId);
            familyService.makePostRequests(family);
            Family saved=familyService.saveWithMyId(family);

            URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(saved.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        }



    @GetMapping
    public ResponseEntity<?> getFamily(@RequestParam final Integer familyId) {
            Family family = familyService.findById(familyId);
            Family aggregatedFamily=familyService.makeGetRequestAndAggregate(family);
            return new ResponseEntity<>(aggregatedFamily, HttpStatus.OK);
    }
}
