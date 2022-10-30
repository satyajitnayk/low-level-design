
public class Player {
  private String playerName;
  private int id;

  Player(String playerName, int id) {
    this.playerName = playerName;
    this.id = id;
  }

  public Object getPlayerName() {
    return this.playerName;
  }
}