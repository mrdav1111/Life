/**
 * Created by AngelDavid on 3/4/2016.
 */
public class Celula {
    private int viva;
    private int[] posicion;


    public Celula(int[] pos) {
        this.viva = 0;
        this.posicion = pos;
    }

    //Retorna si la celula esta viva o no;
   public boolean vida(){
       if (viva == 1){
           return true;
       } else {
           return false;
       }
   }



    public void sobrevive(){
        if (this.vida()){
            this.viva = 1;
        } else {
            this.viva = 0;
        }
    }

    public void nace(){
        this.viva = 1;
    }

    public void muere(){
        this.viva = 0;
    }

    public int[] getPosicion() {
        return posicion;
    }
}
