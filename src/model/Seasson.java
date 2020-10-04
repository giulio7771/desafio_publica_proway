/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author giuliog
 * 
 * Essa classe representa uma temporada
 */
public class Seasson {
    private List<Match> matches;
    private List<Round> rounds;
    
    private short minimumScore;
    private short maximumScore;
    
    private short minimumScoreBrokenTimes;
    private short maximumScoreBrokenTimes;

    
    public Seasson() {
        this.matches = new LinkedList<>();
        this.rounds = new LinkedList<>();
        this.setMaximumScore((short) 0);
        this.setMinimumScore((short) 0);
        this.setMaximumScoreBrokenTimes((short) 0);
        this.setMinimumScoreBrokenTimes((short) 0);
    }
    
    public void addMatch(Match match) throws RuntimeException{
        if (match == null) {
            throw new RuntimeException("Cadastro de partida não pode ser nulo");
        }
        this.checkAndUpdateBrokenScores(match);
        this.matches.add(match);
        this.rounds.add(this.buildRoundObject(match));
    }
    
    private Round buildRoundObject(Match match) {
        Round round = new Round();
        round.setMatchScore(match.getMatchScore());
        round.setMaximumScore(this.getMaximumScore());
        round.setMinimumScore(this.getMinimumScore());
        round.setMaximumScoreBrokenTimes(this.getMaximumScoreBrokenTimes());
        round.setMinimumScoreBrokenTimes(this.getMinimumScoreBrokenTimes());
        return round;
    }
    
    public short getMinimumScore() {
        return minimumScore;
    }

    public void setMinimumScore(short minimumScore) {
        this.minimumScore = minimumScore;
    }

    public short getMaximumScore() {
        return maximumScore;
    }

    private void setMaximumScore(short maximumScore) {
        this.maximumScore = maximumScore;
    }

    public short getMinimumScoreBrokenTimes() {
        return minimumScoreBrokenTimes;
    }

    private void setMinimumScoreBrokenTimes(short minimumScoreBrokenTimes) {
        this.minimumScoreBrokenTimes = minimumScoreBrokenTimes;
    }

    public short getMaximumScoreBrokenTimes() {
        return maximumScoreBrokenTimes;
    }

    private void setMaximumScoreBrokenTimes(short maximumScoreBrokenTimes) {
        this.maximumScoreBrokenTimes = maximumScoreBrokenTimes;
    }
    
    private void incrementMaximumScoreBrokenTimes() {
        this.setMaximumScoreBrokenTimes((short) (this.getMaximumScoreBrokenTimes() + 1));
    }
    
    private void incrementMinimumScoreBrokenTimes() {
        this.setMinimumScoreBrokenTimes((short) (this.getMinimumScoreBrokenTimes() + 1));
    }
    /**
     * 
     * @param match The new match that is going to add to this season
     */
    private void checkAndUpdateBrokenScores(Match match) {
        if (this.matches.size() == 0) {
                this.setMaximumScore(match.getMatchScore());
                this.setMinimumScore(match.getMatchScore());
                return;
        }
        if (match.getMatchScore() < this.getMinimumScore()) {
            this.incrementMinimumScoreBrokenTimes();
            this.setMinimumScore(match.getMatchScore());
        } else if (match.getMatchScore() > this.getMaximumScore()) {
            this.incrementMaximumScoreBrokenTimes();
            this.setMaximumScore(match.getMatchScore());
        }
    }
    
    
    public String getHistoryReport() {
        StringBuilder report = new StringBuilder();
        for (short i = 0; i < rounds.size(); i++) {
            Round round = rounds.get(i);
            report.append(round.toString((short)(i + 1)));
            report.append("\n\n");
        }
        return report.toString();
    }
    
    @Deprecated
    public String getHistoryReportOld() {
        StringBuilder report = new StringBuilder();
        this.addReportHeaderField(report, "Jogo");
        this.addReportHeaderField(report, "Placar");
        this.addReportHeaderField(report, "Mínimo temp.");
        this.addReportHeaderField(report, "Máximo temp.");
        this.addReportHeaderField(report, "Quebra recorde min.");
        this.addReportHeaderField(report, "Quebra recorde máx.");
        
        for (int i = 0; i < 150; i++) {
            report.append("-");
        }
        report.append("\n");
        
        for (short i = 0; i < rounds.size(); i++) {
            Round round = rounds.get(i);
            report.append(round.toString((short)(i + 1)));
        }
        return report.toString();
    }
    
    @Deprecated
    private void addReportHeaderField(StringBuilder sb, String value) {
        int baseSpace = 26;
        baseSpace = baseSpace - value.length();
        sb.append("|");
        for (int i = 0; i < baseSpace/2; i++) {
            sb.append(" ");
        }
        sb.append(value);
        for (int i = 0; i < baseSpace/2; i++) {
            sb.append(" ");
        }
    }
}
