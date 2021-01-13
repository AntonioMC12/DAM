package juego;

public class Jugador {
  
  private String name;
  private int code;
  private float score;
  
  public Jugador(String name, int code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public float getScore() {
    return score;
  }

  public void setScore(float score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "Jugador [name=" + name + ", code=" + code + ", score=" + score + "]";
  }
  
  
}
