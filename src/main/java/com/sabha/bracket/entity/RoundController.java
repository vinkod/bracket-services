/**
 * @author Swaroop Gaddameedhi.
 */
package com.sabha.bracket.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

interface RefRoundRepository extends JpaRepository<Round, Long> {
}

@RestController
@EnableAutoConfiguration
public class RoundController {

    @Autowired
    private RefRoundRepository roundRepository;

    @RequestMapping("/rounds")
    public List<Round> handleRequest() {
        return this.roundRepository.findAll();
    }
}

@Entity
@Table(name = "ref_rounds")
class Round implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "round_id")
    private long roundId;

    @Column(name = "round_name")
    private String roundName;

    Round() {
    }

    public Round(String name) {
        this.roundName = name;
    }

    public String getRoundName() {
        return roundName;
    }

    public long getRoundId() {
        return roundId;
    }

    @Override
    public String toString() {
        return "Round[" + "round id='" + roundId + '\'' + " name='" + roundName + ']';
    }
}
