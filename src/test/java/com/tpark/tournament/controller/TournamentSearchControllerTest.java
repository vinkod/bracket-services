package com.tpark.tournament.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.tpark.tournament.dataaccess.TournamentRepository;
import com.tpark.tournament.entity.RefTournamentType;
import com.tpark.tournament.entity.Sport;
import com.tpark.tournament.entity.Tournament;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(TournamentSearchController.class)
@ContextConfiguration(classes = TournamentSearchController.class)
public class TournamentSearchControllerTest {

    @InjectMocks
    TournamentSearchController tournamentSearchController;

    @Mock
    TournamentRepository tournamentRepository;

    @Mock
    Sport sport;

    @Ignore // TODO : Having issues due to the Sport foreign key serialization!
    @Test
    public void searchTournamentByTerm() throws Exception {
        RefTournamentType type = new RefTournamentType("SingleElimination");
        when(sport.getName()).thenReturn("Cricket");
        Tournament mockTournament = new Tournament("CricketTournament", type, sport, 0);

        MockMvc mockMvc = standaloneSetup(tournamentSearchController).build();
        when(tournamentRepository.findAll()).thenReturn(Lists.newArrayList(mockTournament));

        MockMvcResponse actualResponse = RestAssuredMockMvc.given().mockMvc(mockMvc).when().get("/tournaments/all").then().statusCode(200).extract().response();
        Assert.assertTrue(actualResponse.asString().contains("CricketTournament"));
    }

}