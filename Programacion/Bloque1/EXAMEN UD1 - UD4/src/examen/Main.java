package examen;

public class Main { 
    static int NTAULER;
    static final int SIMBOL_NEGRE = 1;
    static final int SIMBOL_VERMELL = 2;
    static final int SIMBOL_PEO = 8;
    static final int SIMBOL_COSTAT = 9;
    static int[][] tauler;
    
    public static void main(String[] args) {
        NTAULER = UtilitatsConsola.llegirSencer("Mida del tauler: ");
        tauler = new int[NTAULER][NTAULER];  // matriu NTAULERxNTAULER
        
        emplenaCostats(tauler);
        UtilitatsMatrius.mostrarMatriu(tauler);
        
        emplenaInterior(tauler);
        UtilitatsMatrius.mostrarMatriu(tauler);

        situaPeoVermell(tauler, SIMBOL_VERMELL);
        UtilitatsMatrius.mostrarMatriu(tauler);
        
        situaPeoNegre(tauler, SIMBOL_NEGRE);
        UtilitatsMatrius.mostrarMatriu(tauler);

        mostraTauler(tauler);
    }
    
    public static void emplenaCostats(int[][] tauler) {
        /**
         * Ha de rebre un la matriu 'tauler' i ha d'emplenar els costats exteriors 
         * amb el valor 'SIMBOL_COSTAT'.
         */
        for (int i = 0; i < tauler.length ; i++) {
            tauler[i][0] = SIMBOL_COSTAT;
            tauler[0][i] = SIMBOL_COSTAT;
            tauler[NTAULER - 1][i] = SIMBOL_COSTAT;
            tauler[i][NTAULER - 1] = SIMBOL_COSTAT;
        }
    }
    
    public static void emplenaInterior(int[][] tauler) {
        /**
         * Ha de rebre un la matriu 'tauler' i ha d'emplenar les posicions alternes 
         * amb 'SIMBOL_NEGRE' i 'SIMBOL_VERMELL'
         */
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[i].length; j++) {
                if (tauler[i][j]!=SIMBOL_COSTAT)
                if ((i+j) % 2 == 0) {
                    tauler[i][j] = SIMBOL_NEGRE;
                } else {
                    tauler[i][j] = SIMBOL_VERMELL;
                }
            }
        }
    }
    
    public static void situaPeoVermell(int[][] tauler, int vermell) {
        
          /*Ha de rebre la matriu 'tauler' i ha de situar un 'SIMBOL_PEO'
          en qualsevol posició aleatòria igual a 'SIMBOL_VERMELL'.*/
         
        for (int i = 0; i < 1; i++) {
            int[] peo;
            do {
                peo = UtilitatsArrays.generaArray(2, 0, tauler.length - 1);
            } while (tauler[peo[0]][peo[1]] == SIMBOL_NEGRE);
            tauler[peo[0]][peo[1]] = SIMBOL_PEO;         
        }
    }
    
    public static void situaPeoNegre(int[][] tauler, int negre) {
        
          /*Ha de rebre la matriu 'tauler' i ha de situar un 'SIMBOL_PEO'
          en qualsevol posició aleatòria igual a 'SIMBOL_VERMELL'.*/
         
        for (int i = 0; i < 1; i++) {
            int[] peo;
            do {
                peo = UtilitatsArrays.generaArray(2, 0, tauler.length - 1);
            } while (tauler[peo[0]][peo[1]] == SIMBOL_VERMELL);
            tauler[peo[0]][peo[1]] = SIMBOL_PEO;            
        }
    }
    
    public static void mostraTauler(int[][] tauler) {
        /**
         * Ha de rebre la matriu 'tauler' i ha de substituir cada símbol segons la següent taula:
            SIMBOL_VERMELL -> "  "
            SIMBOL_NEGRE -> " : "
            SIMBOL_PEO -> " Z "
            SIMBOL_COSTAT -> " | "
         */
        char caracter = ' ';
        for (int[] array : tauler) {
            for (int a : array) {
                switch (a) {
                    case SIMBOL_VERMELL -> caracter = ' ';
                    case SIMBOL_NEGRE -> caracter = ':';
                    case SIMBOL_PEO -> caracter = 'Z';
                    case SIMBOL_COSTAT -> caracter = '|';
                    
                }
                System.out.print(caracter + " ");
            }
            System.out.println();
        }
    }
}

