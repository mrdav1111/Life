/**
 * Created by AngelDavid on 3/4/2016.
 */
public class Life {
    private Matriz espacio;
    private int matrizSize;
    private int generaciones;

//Contructor, crea el espacio y puebla la matriz con n celulas vivas en posiciones al azar
    public Life(int matriz,int celulas, int generaciones) {
        espacio = new Matriz(matriz);
        espacio.Eva(celulas);
        if (generaciones > 20){
            System.out.println("El numero de generaciones es muy grande, se utilizara el maximo de 20");
            this.generaciones = 20;
        } else {
            this.generaciones = generaciones;
        }
        this.matrizSize = matriz;
    }
    //Aplica las reglas del juego y genera las diferentes generaciones
    public void evolucion(){
        System.out.println("Generacion: 1");
        espacio.imprimir();

        for (int i = 2; i <= generaciones; i++) {

            Matriz proximaGeneracion = espacio;

            for (Celula[] fila: espacio.getUniverso()){
                for (Celula celula :fila){
                    celula.setVecindad(espacio.vecindad(celula));
                }
            }

            for (Celula[] fila: proximaGeneracion.getUniverso()){
                for (Celula celula :fila){
                    int vecinos = celula.getVecindad();
                    if (vecinos== 3){
                        celula.nace();
                    } else if (vecinos < 2 || vecinos > 3){
                        celula.muere();
                    } else if (vecinos == 2 || vecinos == 3){
                        celula.sobrevive();
                    }
                }
            }
            espacio = proximaGeneracion;
            System.out.println("Generacion: "+i);
            espacio.imprimir();


        }
    }
}

