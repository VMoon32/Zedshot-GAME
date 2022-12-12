import greenfoot.*;  
import java.util.*;
import java.io.*;
import java.io.BufferedWriter;

public class Records extends World
{
    private List<Jugador> listaJugador = new LinkedList<>();
    private String text;
    private long points;

    public Records()
    {    
        super(900, 600, 1); 

        CrosshairLabel crosshairLabel = new CrosshairLabel("Records");
        addObject(crosshairLabel, 800, 500);

        try{
            listaJugador=this.leer();
        }catch(IOException ex){

        }

        listaJugador.sort(Comparator.comparingLong(Jugador::getMaxScore).reversed());

        if(listaJugador.size()<=8){
            for(int i=0;i<listaJugador.size();i++){
                text=listaJugador.get(i).getNombre();
                points=listaJugador.get(i).getMaxScore();
                Jugador imprimeJugador = new Jugador();
                imprimeJugador.setImage(new GreenfootImage(""+text+" - "+points+" points ",30,Color.WHITE,Color.BLACK));
                addObject(imprimeJugador,450,150+(50*i));
            }
        }else{
            int x=0;
            
            for(int i=0;i<listaJugador.size()-1;i++){
                if(x != 8){
                    x++;
                    text=listaJugador.get(i).getNombre();
                    points=listaJugador.get(i).getMaxScore();
                    Jugador imprimeJugador = new Jugador();
                    imprimeJugador.setImage(new GreenfootImage(""+text+" - "+points+" points ",30,Color.WHITE,Color.BLACK));
                    addObject(imprimeJugador,450,100+(50*(x)));
                }
            }
        }

        /*if(listaJugador.size()<=8){
        for(int i=0;i<listaJugador.size();i++){
        text=listaJugador.get(i).getNombre();
        points=listaJugador.get(i).getMaxScore();
        Jugador imprimeJugador = new Jugador();
        imprimeJugador.setImage(new GreenfootImage(""+text+" - "+points+" points ",30,Color.WHITE,Color.BLACK));
        addObject(imprimeJugador,450,150+(50*i));
        }
        }else{
        banderaTamLista=listaJugador.size()-8;
        for(int i=banderaTamLista-3;i<listaJugador.size()-3;i++){
        text=listaJugador.get(i).getNombre();
        points=listaJugador.get(i).getMaxScore();
        Jugador imprimeJugador = new Jugador();
        imprimeJugador.setImage(new GreenfootImage(""+text+" - "+points+" points ",30,Color.WHITE,Color.BLACK));
        addObject(imprimeJugador,450,150+(50*(i-banderaTamLista+3)));
        }
        }*/

    }

    public static List<Jugador> leer() throws IOException, FileNotFoundException{
        File archivo=new File("Jugadores.txt");

        FileReader lectorDelArchivo = new FileReader(archivo);

        BufferedReader lectorDelBuffer = new BufferedReader(lectorDelArchivo);

        List<Jugador> listaJugadores = new LinkedList<>();

        String linea = null;

        do{
            linea=lectorDelBuffer.readLine();
            if(linea!=null){
                String[] vectorCadena = linea.split(",");
                listaJugadores.add(new Jugador(vectorCadena[0],Long.parseLong(vectorCadena[1])));
            }
        }while(linea!=null);

        lectorDelBuffer.close();

        return listaJugadores;
    }

}
