import greenfoot.*;
import java.util.*;
import java.io.*;
import java.io.BufferedWriter;

public class RegisterRecords extends World
{
    private String text;
    private long points;
    private int y = 150;

    public void act(){
    }

    public RegisterRecords(String userInput,long maxScore)
    {    
        super(900, 600,1);
        
        List<Jugador> listaJugador = new LinkedList<>();

        Jugador newJugador = new Jugador(userInput,maxScore);
        
        
        

        try{
            listaJugador=this.leer();
        }catch(IOException ex){

        }
        
        listaJugador.add(newJugador);
        try{
            guardar(listaJugador);
        }catch (IOException ioe){
        }

        try{
            listaJugador=this.leer();
        }catch(IOException ex){

        }

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
            for(int i=0;i<listaJugador.size();i++){
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

        prepare();
    }

    private void borrar(){

    }

    private void prepare(){
        setBackground("records.jpg");
        CrosshairLabel crosshairLabel = new CrosshairLabel("Records");
        addObject(crosshairLabel, 800, 550);
    }

    private void guardar(List<Jugador> listaJugador) throws IOException{
        File archivo=new File("Jugadores.txt");

        listaJugador.sort(Comparator.comparingLong(Jugador::getMaxScore).reversed());

        try(FileWriter escritorAlArchivo = new FileWriter(archivo); 
        BufferedWriter escritorAlBuffer = new BufferedWriter(escritorAlArchivo);){

            Iterator<Jugador> it = listaJugador.listIterator();

            for(int i=0; it.hasNext() && i < 9; i++){
                Jugador jugador = it.next();
                escritorAlBuffer.write(jugador.getNombre()+","+ jugador.getMaxScore()+"\n");          
            }
        }
    }
    
    public static List<Jugador> leer() throws IOException, FileNotFoundException{
        File archivo=new File("Jugadores.txt");
        List<Jugador> listaJugadores = new LinkedList<>();
        
        try(FileReader lectorDelArchivo = new FileReader(archivo);
        BufferedReader lectorDelBuffer = new BufferedReader(lectorDelArchivo);){

            String linea = null;

            do{
                linea=lectorDelBuffer.readLine();
                if(linea!=null){
                    String[] vectorCadena = linea.split(",");
                    listaJugadores.add(new Jugador(vectorCadena[0],Long.parseLong(vectorCadena[1])));
                }
            }while(linea!=null);
        }

        return listaJugadores;
    }

}
