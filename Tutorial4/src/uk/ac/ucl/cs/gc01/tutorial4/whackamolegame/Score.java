package uk.ac.ucl.cs.gc01.tutorial4.whackamolegame;

/** 
 * Create a high score class in order to sort the high scores.
 * Each high score has two properties, a name and a score 
 * Will create an array list to allow the use of collections.sort based on the score.
 */
public class Score {

	String name;
	int score;
	
	public Score(String name, int score){
		this.name=name;
		this.score=score;
	}
    public String getName()
    {
        return name;
    }
 
    public int getScore()
    {
        return score;
    }
 
    public String toString()
    {
        return name + " : " + score;
    }
}

