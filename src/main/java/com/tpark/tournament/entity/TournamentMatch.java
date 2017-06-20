package com.tpark.tournament.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tournament_matches")
public class TournamentMatch implements Serializable {
    private static final long serialVersionUID = 2458313523456625439L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private long id;

    @Column(name = "match_seq")
    private int match_seq;

    @ManyToMany
    @JoinColumn(name = "participant_id1")
    private Participant participant1;

    @ManyToMany
    @JoinColumn(name = "participant_id2")
    private Participant participant2;

    @Column(name = "round")
    private int round;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournamentId;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Participant winner;

    // TODO ENUM result // Single Winner, WalkOver etc.

    TournamentMatch() {
    }

    public TournamentMatch(long id, int match_seq, Participant participant1, Participant participant2, int round, Tournament tournamentId, Participant winner) {
        this.id = id;
        this.match_seq = match_seq;
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.round = round;
        this.tournamentId = tournamentId;
        this.winner = winner;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public int getMatch_seq() {
        return match_seq;
    }

    public Participant getParticipant1() {
        return participant1;
    }

    public Participant getParticipant2() {
        return participant2;
    }

    public int getRound() {
        return round;
    }

    public Tournament getTournamentId() {
        return tournamentId;
    }

    public Participant getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "TournamentMatch{" + "id=" + id + ", match_seq=" + match_seq + ", participant1=" + participant1 + ", participant2=" + participant2 + ", round=" + round + ", tournamentId=" + tournamentId + ", winner=" + winner + '}';
    }
}