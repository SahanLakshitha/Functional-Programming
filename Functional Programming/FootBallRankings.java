
public class FootBallRankings implements Comparable<FootBallRankings> {
  private int TeamName;
  private String club;
  private int PlayedMatches;
  private int WonMatches;
  private int LostMatches;
  private int TeamPoints;
  private double TeamAVG;
  
  
  public FootBallRankings(int position, String club, int played, int won,int lost, int points, double avg) {
    this.TeamName = position;
    this.club = club;
    this.PlayedMatches = played;
    this.WonMatches = won;
    this.LostMatches = lost;
    this.TeamPoints = points;
    this.TeamAVG = avg;
  }

  public String toString() {
    return String.format("%-3d%-20s%10d%10d%10d%10d%25f", TeamName, club, PlayedMatches, WonMatches, LostMatches, TeamPoints,TeamAVG);
  }

  public int getPosition() {
    return TeamName;
  }

  public void setPosition(int position) {
    this.TeamName = position;
  }

  public String getClub() {
    return club;
  }

  public void setClub(String club) {
    this.club = club;
  }

  public int getPlayed() {
    return PlayedMatches;
  }

  public void setPlayed(int played) {
    this.PlayedMatches = played;
  }

  public int getWon() {
    return WonMatches;
  }

  public void setWon(int won) {
    this.WonMatches = won;
  }

  public int getLost() {
    return LostMatches;
  }

  public void setLost(int lost) {
    this.LostMatches = lost;
  }
  
  public int getPoints() {
	  return TeamPoints;
  }
  
  public void setPoints(int points) {
	  this.TeamPoints = points;
  }
  
  public double getAVG() {
	  return TeamAVG;
  }
  
  public void setNrr(double avg) {
	  this.TeamAVG = avg;
  }
  
@Override
public int compareTo(FootBallRankings c) {
    return ((Integer) TeamPoints).compareTo(c.TeamPoints);
  }
}
