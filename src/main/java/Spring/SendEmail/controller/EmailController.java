package Spring.SendEmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Spring.SendEmail.dto.EmailDto;
import Spring.SendEmail.service.EmailService;

@RestController
@RequestMapping("/api/email")

public class EmailController {
	
	@Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailDto emailDto) {
        emailService.sendEmail(emailDto.getTo(), emailDto.getSubject(), emailDto.getText());
        return ResponseEntity.ok("Email sent successfully");
    }

}
