public class Main {

    public static void main(String[] args) {
	// Inicia el juego de la vida los parametros son : Tamaño de la matriz, Cantidad de celulas iniciales y cantidad de generaciones
        Life genesis = new Life(10,20,20);
        genesis.evolucion();
    }
}
