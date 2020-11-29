package com.example.tictactoe

class Game {

    private var board = arrayOf("", "", "", "", "", "", "", "", "")
    var turn = "X"


    fun spotIsEmpty(index : Int) : Boolean {
        return board.get(index).equals("")
    }

    fun addMove(index : Int) {
        board.set(index, turn)

        if (turn.equals("X"))
        {
            turn = "O"
        }
        else
        {
            turn = "X"
        }

    }

    fun getWinner() : String {
        var winner = checkHorizontal(0)

        if (winner.equals("#"))
        {
            winner = checkVertical(0)

            if (winner.equals("#"))
            {
                winner = chechdiagnol1(0)
                if (winner.equals("#"))
                {
                    winner = chechdiagnol2(2)
                }
            }
        }

        return winner
    }

    fun getMoves() : Int {
        var moves = 0

        for (tile in board)
        {
            if (!tile.equals(""))
            {
                moves++
            }
        }

        return moves
    }

    private fun checkHorizontal(index : Int) : String {
        var temp = board.get(index)

        var score = 0

        for (i in index..(index+2))
        {
            if (temp.equals(board.get(i)))
            {
                score++
            }
        }

        if (score.equals(3) && !temp.equals(""))
        {
            return temp;
        }
        else
        {
            if (index < 6)
            {
                return checkHorizontal(index+3)
            }
            else
            {
                return "#"
            }
        }
    }

    private fun checkVertical(index : Int) : String {
        var temp = board.get(index)

        var score = 0

        for (i in index..8 step 3)
        {

            if (temp.equals(board.get(i)))
            {
                score++
            }
        }

        if (score.equals(3) && !temp.equals(""))
        {
            return temp;
        }
        else
        {
            if (index < 2)
            {
                return checkVertical(index + 1)
            }
            else
            {
                return "#"
            }
        }
    }

    private fun chechdiagnol1(index : Int) : String {
        var temp = board.get(index)

        var score = 0

        for (i in index..8 step 4)
        {
            if (temp.equals(board.get(i)))
            {
                score++
            }
        }

        if (score.equals(3) && !temp.equals(""))
        {
            return temp;
        }
        else
        {
            return "#"
        }
    }

    private fun chechdiagnol2(index : Int) : String {
        var temp = board.get(index)

        var score = 0

        for (i in 6 downTo 2 step 2)
        {
            if (temp.equals(board.get(i)))
            {
                score++
            }
        }

        if (score.equals(3) && !temp.equals(""))
        {
            return temp;
        }
        else
        {
            return "#"
        }
    }

}
