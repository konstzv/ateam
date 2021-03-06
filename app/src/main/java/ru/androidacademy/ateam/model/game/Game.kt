package ru.androidacademy.ateam.model.game

import javax.inject.Inject
import kotlin.random.Random

class Game @Inject constructor() {
    val randomInt = Random.nextInt()
    var skipNum:Int = 3
    var timeInSec: Int = 30
    var words: List<String> = emptyList()
    var teams: List<Team> = emptyList()
    var rounds:List<Round> = emptyList()

    private var currentWordIndex: Int = 0
    private var currentTeamIndex: Int = 0
     lateinit var currentRound: Round


    fun setRandomTeam(){
        currentTeamIndex = Random.nextInt(0, teams.size)
    }

    fun getWordsLeft(): Int {
        return words.size -  currentWordIndex
    }

    fun getNextTeam(): Team {
        return teams[nextIndex()]
    }

    private fun nextIndex(): Int {
        if (currentTeamIndex >= teams.size - 1) {
            currentTeamIndex = 0
            return currentTeamIndex
        } else {
            currentTeamIndex += 1
            return currentTeamIndex
        }
    }

    fun getNextRound(): Round {
        val team = getNextTeam()
        currentRound = Round(team, team.getNextPlayer(), team.getNextPlayer())
        currentRound.skipNum = skipNum
        return currentRound
    }

    fun getNextWord(): String? {
        if (currentWordIndex < words.size) {
            return words[currentWordIndex++]
        }else{
            return null
        }
    }

    fun getWinner(): Team?{
       return teams.maxBy { it.score }
    }

    override fun toString(): String {
        return randomInt.toString()
    }
}