package org.example.authentification;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.authentification.controleur.Controleur;
import org.example.authentification.facade.exceptions.UtilisateurInexistantException;
import org.example.authentification.modele.Utilisateur;
import org.example.authentification.facade.FacadeUtilisateurs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

public class TestTokensApplication {

    @Autowired
    MockMvc mvc;


    @MockBean
    PasswordEncoder passwordEncoder;

    @MockBean
    FacadeUtilisateurs facadeUtilisateurs;


    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void testLogin() throws Exception {

        String email = "test@univ-orleans.fr";
        String passwordClair = "passwordtestclair";
        String passwordEncode = "passwordtestencode";
        int id = 12;

        Controleur.LoginDTO loginDTO = new Controleur.LoginDTO(email, passwordClair);
        Utilisateur utilisateur = mock(Utilisateur.class);
        doReturn(utilisateur).when(facadeUtilisateurs).getUtilisateurByEmail(loginDTO.email());
        doReturn(passwordEncode).when(utilisateur).getEncodedPassword();
        doReturn(email).when(utilisateur).getEmail();
        doReturn(id).when(utilisateur).getIdUtilisateur();

        doReturn(true).when(passwordEncoder).matches(passwordClair, passwordEncode);

        mvc.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginDTO)))
                .andExpect(status().isOk())
                .andExpect(header().exists("Authorization"));


    }



    @Test
    public void testLogin2() throws Exception {

        String email = "test@univ-orleans.fr";
        String passwordClair = "passwordtestclair";
        String passwordEncode = "passwordtestencode";
        int id = 12;

        Controleur.LoginDTO loginDTO = new Controleur.LoginDTO(email, passwordClair);
        Utilisateur utilisateur = mock(Utilisateur.class);
        doThrow(UtilisateurInexistantException.class).when(facadeUtilisateurs).getUtilisateurByEmail(loginDTO.email());

        mvc.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDTO)))
                .andExpect(status().isUnauthorized());
      }

    @Test
    public void testLogin3() throws Exception {

        String email = "test@univ-orleans.fr";
        String passwordClair = "passwordtestclair";
        String passwordEncode = "passwordtestencode";
        int id = 12;

        Controleur.LoginDTO loginDTO = new Controleur.LoginDTO(email, passwordClair);
        Utilisateur utilisateur = mock(Utilisateur.class);
        doReturn(utilisateur).when(facadeUtilisateurs).getUtilisateurByEmail(loginDTO.email());
        doReturn(passwordEncode).when(utilisateur).getEncodedPassword();
        doReturn(email).when(utilisateur).getEmail();
        doReturn(id).when(utilisateur).getIdUtilisateur();

        doReturn(false).when(passwordEncoder).matches(passwordClair, passwordEncode);

        mvc.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDTO)))
                .andExpect(status().isUnauthorized());


    }




}
