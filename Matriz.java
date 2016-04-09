import java.util.DoubleSummaryStatistics;
import java.util.Random;


/**
 * Created by AngelDavid on 3/4/2016.
 */
public class Matriz {
    private Celula[][] universo;
    private int size;



// Constructor de la matriz
    public Matriz(int size){
        if (size < 10) {
            System.out.println("El valor "+size+" es muy pequeño se usara el valor minimo de 10");
            universo = new Celula[10][10];
            this.size = 10;
        } else {
            universo = new Celula[size][size];
            this.size = size;
        }
       for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++  ) {
                int[] pos = {i,j};
                universo[i][j] = new Celula(pos);
            }
        }

    }

    //Aleatoriamente puebla de n celulas a la matriz universo
    public void Eva(int n){
        if (n<5){
            System.out.println("La cantidad de celulas es muy pequeña se usara 5");
            n = 5;
        }
        for (int i = 0; i < n ; i++) {
            int x = (int)(Math.random() * size);
            int y = (int) (Math.random() * size);
            universo[x][y].nace();
        }


    }

    //Cantidad de celuas vivas alrededor de la celula
    public int vecindad(Celula celula){
        int contador = 0;
        int columna = celula.getPosicion()[1] ;
        int fila = celula.getPosicion()[0];
        int[] pos = celula.getPosicion();
        int[] alrededorColumna = {columna-1,columna,columna+1};
        int[] alrededorFila = {fila-1,fila,fila+1};
        for (int i: alrededorFila){
            for (int j: alrededorColumna){
                int[] posicion = {i,j};
                try{
                    //System.out.println(i+","+j);
                    //System.out.println(pos[0]+","+pos[1]+"/ "+ posicion[0]+" "+posicion[1]);
                    if (universo[i][j].vida() &&(i < size && j < size) &&(i >= 0 && j >= 0) && universo[i][j] != celula ){

                        contador++;
                    }}catch (Exception e){
                    //System.out.println(j+","+i+", "+e);
                }

            }
        }
        //System.out.println(contador +": Cordenadas "+fila+' '+columna);
        return contador;
    }

    public Celula[][] getUniverso() {
        return universo;
    }
    public void imprimir(){

        for (Celula[] filas: universo) {
            for (Celula celula : filas) {
                if (celula.vida()){
                    System.out.print("[*]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
