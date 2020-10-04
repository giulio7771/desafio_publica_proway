/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author giuliog
 * 
 * Essa classe representa o resultado de partidas jogadas
 */
public class Match {
    //The score of Maria on this match
    private short matchScore;

    public short getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(short matchScore) throws RuntimeException {
        if (matchScore > 1000 || matchScore < 0) {
            throw new RuntimeException("A pontuação da partida deve estar dentro de 0 e 1000. \nPontuação recebida: " + matchScore);
        }
        this.matchScore = matchScore;
    }
    
}
