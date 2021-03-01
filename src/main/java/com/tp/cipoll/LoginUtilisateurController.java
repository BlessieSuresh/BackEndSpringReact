package com.tp.cipoll;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/login")
public class LoginUtilisateurController {
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/authenticate")
    public String login(@RequestBody String emailPassWord,HttpServletResponse response) {
		
		ObjectMapper jacksonObjMapper = new ObjectMapper();
		try {
			JsonNode jsonNode = jacksonObjMapper.readTree(emailPassWord);
			String email = jsonNode.get("email").toString();
			String password = jsonNode.get("password").toString();
			if((email.equals("\"tom@orange.fr\"") && password.equals("\"keen\"")) || (email.equals("\"ray@orange.fr\"") && password.equals("\"red\""))) {
				response.setStatus(200);
			} else {
				response.setStatus(403);
			}
		} catch (JsonMappingException e) {
			response.setStatus(403);
		} catch (JsonProcessingException e) {
			response.setStatus(403);
		}
		
        return emailPassWord;
    }
}
