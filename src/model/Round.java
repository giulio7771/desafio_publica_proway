/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author giuliog
 */
public class Round {
    private short matchScore;
    private short minimumScore;
    private short maximumScore;
    private short minimumScoreBrokenTimes;
    private short maximumScoreBrokenTimes;

    public short getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(short matchScore) {
        this.matchScore = matchScore;
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

    public void setMaximumScore(short maximumScore) {
        this.maximumScore = maximumScore;
    }

    public short getMinimumScoreBrokenTimes() {
        return minimumScoreBrokenTimes;
    }

    public void setMinimumScoreBrokenTimes(short minimumScoreBrokenTimes) {
        this.minimumScoreBrokenTimes = minimumScoreBrokenTimes;
    }

    public short getMaximumScoreBrokenTimes() {
        return maximumScoreBrokenTimes;
    }

    public void setMaximumScoreBrokenTimes(short maximumScoreBrokenTimes) {
        this.maximumScoreBrokenTimes = maximumScoreBrokenTimes;
    }
    
    public String toString(short matchNumber) {
        StringBuilder sb =  new StringBuilder();
        sb.append("Jogo: " + matchNumber);
        sb.append("\n     Placar: " + this.getMatchScore());
        sb.append("\n     Mínimo da temporada: " + this.getMinimumScore());
        sb.append("\n     Máximo da temporada: " + this.getMaximumScore());
        sb.append("\n     Quebra recorde min.: " + this.getMinimumScoreBrokenTimes());
        sb.append("\n     Quebra de recorde máx.: " + this.getMaximumScoreBrokenTimes());
        
        return sb.toString();
    }
    
    @Deprecated
    public String toStringDepretated(short matchNumber) {
        StringBuilder report = new StringBuilder();
        report.append("|");
        this.addReportField(report, matchNumber);
        this.addReportField(report, this.getMatchScore());
        this.addReportField(report, this.getMinimumScore());
        this.addReportField(report, this.getMaximumScore());
        this.addReportField(report, this.getMinimumScoreBrokenTimes());
        this.addReportField(report, this.getMaximumScoreBrokenTimes());
        report.append("\n");
        return report.toString();
    }
    
    @Deprecated
    private void addReportField(StringBuilder str, short info) {
        int baseSpace = 32;
        int extraSpaces = 1;
        //kepping grid aligned
        if (info > 999) {
            extraSpaces = 4;
        } else if (info > 99) {
            extraSpaces = 3;
        } else if (info > 9) {
            extraSpaces = 2;
        }
        baseSpace = baseSpace - extraSpaces;
        for (int i = 0; i < baseSpace/2; i++) {
            str.append(" ");
        }
        str.append(info);
        for (int i = 0; i < baseSpace/2; i++) {
            str.append(" ");
        }
        str.append("|");
    }
    
}
