package com.lakshita.easelearn.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lakshita.easelearn.entity.Profile;

import com.lakshita.easelearn.entity.Education;
import com.lakshita.easelearn.entity.Teacher;
import com.lakshita.easelearn.entity.Experience;
import com.lakshita.easelearn.repository.ProfileRepository;
import com.lakshita.easelearn.repository.TeacherRepository;
import com.lakshita.easelearn.request.ProfileRequest;


@RestController
@RequestMapping("/profile")

public class ProfileController {
	private final TeacherRepository teacherRepository;
    private final ProfileRepository profileRepository;
    
    public ProfileController(TeacherRepository teacherRepository, ProfileRepository profileRepository) {
        this.teacherRepository = teacherRepository;
        this.profileRepository = profileRepository;
    }
    
    @PostMapping("/create/{teacherId}")
    public ResponseEntity<Profile> createProfile(
        @PathVariable Long teacherId,
        @RequestBody Profile profileRequest
    ) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);
        
        if (!teacherOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Teacher teacher = teacherOptional.get();

        // Create Profile entity
        Profile profile = new Profile();
        profile.setDescription(profileRequest.getDescription());
        profile.setLocation(profileRequest.getLocation());
        profile.setLanguage(profileRequest.getLanguage());
        profile.setDate_of_join(profileRequest.getDate_of_join());

        // Map Education
        List<Education> educationList = profileRequest.getEducation().stream() // list of education request list
            .map(req -> { 
                Education edu = new Education();
                edu.setName(req.getName());
                edu.setDescription(req.getDescription());
               edu.setProofFile(req.getProofFile());
               edu.setStartDate(req.getStartDate());
               edu.setEndDate(req.getEndDate());
               edu.setProofURL(req.getProofURL());// Assuming proof is stored as a string (URL or ID)
               
                return edu;
            }).collect(Collectors.toList());

//        // Map Experience
        List<Experience> experienceList = profileRequest.getExperience().stream()
            .map(req -> {
                Experience exp = new Experience();
                exp.setDescription(req.getDescription());
                exp.setEndDate(req.getEndDate());
                exp.setName(req.getName());
                exp.setStartDate(req.getStartDate());
               
                return exp;
            }).collect(Collectors.toList());
//
        profile.setEducation(educationList);
//        profile.setExperience(experienceList);

        // Link Profile to Teacher
        teacher.setProfile(profile);
        profileRepository.save(profile); // Saves profile along with education & experience

        return ResponseEntity.status(HttpStatus.CREATED).body(profile);
    }
    
    
}
