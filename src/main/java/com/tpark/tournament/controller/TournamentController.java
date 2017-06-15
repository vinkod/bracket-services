package com.tpark.tournament.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableList;
import com.tpark.tournament.dataaccess.RefTournamentTypeRepository;
import com.tpark.tournament.dataaccess.TournamentRepository;
import com.tpark.tournament.entity.RefTournamentType;
import com.tpark.tournament.entity.Tournament;
import com.tpark.tournament.resource.TournamentResource;

@RestController
@EnableAutoConfiguration
@RequestMapping("/tournament")
public class TournamentController {
    private static Logger LOGGER = Logger.getLogger(TournamentController.class);
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private RefTournamentTypeRepository tournamentTypeRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{tournamentId}")
    public TournamentResource readTournament(@PathVariable Long tournamentId) {
        return new TournamentResource(this.tournamentRepository.findOne(tournamentId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/types")
    public List<RefTournamentType> readTypes() {
        return this.tournamentTypeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament) {
        Tournament result = this.tournamentRepository.save(tournament);
        // Create bracket

        Link forOneTournament = new TournamentResource(result).getLink("self");
        return ResponseEntity.created(URI.create(forOneTournament.getHref())).build();
    }

    private void createBracket(Tournament tournament) {

        // determine the number of rounds and number of matches per round

        // determine the round assignments - which seeds are playing.

        // determine the byes

        // save the matches and round info.

    }



    private long findNumberOfMatchesToBePlayedInSingleElimination(long participantCount) {

        return participantCount - 1;
    }

    /*
     * https://stackoverflow.com/questions/27239863/find-previous-power-of-2-in-64-bit-number
     */
    private long findTheNearestSmallerPowerOfTwo(long x) {
        int c = -1;
        while (x > 0) {
            x >>= 1;
            c++;
        }
        return ((long) 1) << c;
    }

    /*
     * https://stackoverflow.com/questions/600293/how-to-check-if-a-number-is-a-power-of-2
     */
    private boolean isPowerOfTwo(long x) {
        return (x != 0) && ((x & (x - 1)) == 0);
    }

}
