/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Match;
import model.Seasson;

/**
 *
 * @author giuliog
 */
public class SeassonController {
    //As I am not using DB I am keeping this in memory
    private static Seasson seasson = new Seasson();
    
    /**
     * 
     * @param matchScore Maria score for this match
     * @return Message with the status of the process
     */
    public static String addMatch(String matchScore) {
        try {
            short matchScoreShort = Short.parseShort(matchScore);
            Match match = new Match();
            match.setMatchScore(matchScoreShort);
            seasson.addMatch(match);
        } catch (RuntimeException ex) {
            return ex.getMessage();
        }
        return "Partida cadastrada com sucesso";
    }
    
    public static String getHistoryReport() {
        try {
            return seasson.getHistoryReport();
        } catch (RuntimeException ex) {
            return ex.getMessage();   
        }
    }
}
