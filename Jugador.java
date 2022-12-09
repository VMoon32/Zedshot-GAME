import greenfoot.*;

public class Jugador extends Actor
{
    private String nombre;
    private long maxScore;

    public void act(){
    }

    public Jugador(String nombre,long maxScore){
        this.nombre = nombre;
        this.maxScore = maxScore;
    }

    public Jugador(){

    }

    public String getNombre(){
        return nombre;
    }

    public long getMaxScore(){
        return maxScore;
    }
}
