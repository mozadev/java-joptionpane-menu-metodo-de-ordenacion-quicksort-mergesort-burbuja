package metodosordenacion;

import javax.swing.JOptionPane;

public class Metodosordenacion {

    /**
     * @param a
     * @param primero
     * @param ultimo
     */
    public static void quicksort1(int[] a, int primero, int ultimo) {
        int i, j, central;
        int pivote;
        central = ((primero + ultimo) / 2);
        pivote = a[central];
        i = primero;
        j = ultimo;

        do {

            while (a[i] < pivote) {
                i++;
            }
            while (a[j] > pivote) {
                j--;
            }

            if (i <= j) {
                int temp;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
            
        } while (i <= j);
        
        if (primero < j) {
            quicksort1(a, primero, j);
        }
        if (i < ultimo) {
            quicksort1(a, i, ultimo);
        }

    }

    public static int[] mergesort(int[] a) {
        int i, j, k;
        if (a.length > 1) {
            int nIzq = a.length / 2;
            int nDer = a.length - nIzq;
            int aIzq[] = new int[nIzq];
            int aDer[] = new int[nDer];
            //copiando los elem de la parte derecha al arreglo dere
            for (i = 0; i < nIzq; i++) {
                aIzq[i] = a[i];
            }
            //copiando los elem de la parte 1era al arreglo izq
            for (i = nIzq; i < nIzq + nDer; i++) {
                aDer[i - nIzq] = a[i];
            }
            //recursividad
            aIzq = mergesort(aIzq);
            aDer = mergesort(aDer);

            i = 0;
            j = 0;
            k = 0;
//ordenando
            while (aIzq.length != j && aDer.length != k) {
                if (aIzq[j] < aDer[k]) {
                    a[i] = aIzq[j];
                    i++;
                    j++;

                } else {
                    a[i] = aDer[k];
                    i++;
                    k++;

                }
            }//arreglo final
           /* while (aIzq.length != j) {

                a[i] = aIzq[j];
                i++;
                j++;
            }

            while (aDer.length != k) {

                a[i] = aDer[k];
                i++;
                k++;

            }*/
        }//fin if
        return a;
    }

    public static void main(String[] args) {
        int num, i, menu, j;
        String cadena = "";

        num = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño del arreglo"));

        int[] x = new int[num];

        for (i = 0; i < x.length; i++) {
            x[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor[" + i + "]"));

        }

        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog("Selecciona una opcion"
                    + "\n 1) Muestra los numeros que ingresaste al arreglo "
                    + "\n 2) Ordenamiento por metodo burbuja  "
                    + "\n 3) Ordenamiento por metodo quicksort  "
                    + "\n 4) Ordenamiento por metodo mergesort "
                    + "\n 5) Salir"));

            switch (menu) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Los valores ingresados son");
                    for (i = 0; i < x.length; i++) {
                        cadena = cadena + x[i] + " ";
                        JOptionPane.showMessageDialog(null, x[i]);
                    }
                    JOptionPane.showMessageDialog(null, cadena);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Ordenado por el metodo burbuja ");
                    String cadenaburbuja = "";
                    for (i = 0; i < x.length; i++) {
                        for (j = 0; j < x.length - 1; j++) {
                            if (x[j] > x[j + 1]) {
                                int tem = x[j];
                                x[j] = x[j + 1];
                                x[j + 1] = tem;

                            }
                        }
                    }

                    for (i = 0; i < x.length; i++) {
                        cadenaburbuja = cadenaburbuja + x[i] + " ";
                        JOptionPane.showMessageDialog(null, x[i] + " ");
                    }
                    JOptionPane.showMessageDialog(null, cadenaburbuja);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "ordenando por metodo quicksort");
                    String cadenaquicksort = "";
                   // quicksort1(x, 0, x.length - 1);
                    Metodosordenacion.quicksort1(x, 0, x.length - 1);
                    for (int k = 0; k < x.length; k++) {
                        cadenaquicksort = cadenaquicksort + x[k] + " ";
                        JOptionPane.showMessageDialog(null, x[k] + " ");
                    }
                    JOptionPane.showMessageDialog(null, cadenaquicksort);

                    break;
//este es una actualizacion 
                case 4:
                    JOptionPane.showMessageDialog(null, "ordenando por metodo mergesort");
                    String cadenamergesort = "";
                    mergesort(x);
                    for (int k = 0; k < x.length; k++) {
                        cadenamergesort = cadenamergesort + x[k] + " ";
                        JOptionPane.showMessageDialog(null, x[k] + " ");
                    }
                    JOptionPane.showMessageDialog(null, cadenamergesort);

                    break;
                case 5:

                    break;
            }
        } while (menu != 5);
    }

}
