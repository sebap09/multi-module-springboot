package pl.myproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.myproject.Entities.FamilyMember;
import pl.myproject.Services.FamilyMemberService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
public class Controller {

    private final FamilyMemberService familyMemberService;

    @Autowired
    public Controller(FamilyMemberService familyMemberService) {
        this.familyMemberService = familyMemberService;
    }

    @PostMapping
    public ResponseEntity<?> createFamilyMember(@RequestBody final FamilyMember familyMember){
        FamilyMember saved=familyMemberService.save(familyMember);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<FamilyMember>> searchFamilyMember(@RequestParam Integer familyId){
        return new ResponseEntity<>(familyMemberService.findByFamilyId(familyId), HttpStatus.OK);
    }
}
