package co.edu.udistrital.main;

import java.util.Random;
import java.util.Scanner;

import co.edu.udistrital.controller.*;

public class LaMain {

	public static void main(String[] args) {

		Scanner leer = new Scanner(System.in);

		Venta a;
		Venta b;

		a = new Venta();
		b = new Venta();

		int semanas = 4;
		int dias = 7;

		double sem1 = 0;
		double sem2 = 0;
		double sem3 = 0;
		double sem4 = 0;

		double[][] mes = new double[semanas][dias];

		int p = 1;

		System.out.println("Escoja una opcion: ");
		System.out.println("1. ingresar las ventas de forma manual.");
		System.out.println("2. ingresar las ventas de forma aleatorea.");
		int opcion = leer.nextInt();

		switch (opcion) {
		case 1:
			for (int i = 0; i < semanas; i++) {
				for (int j = 0; j < dias; j++) {

					System.out.println("Ingrese las ventas del dia " + p);
					a.valor = leer.nextDouble();
					mes[i][j] = a.valor;
					p++;
				}
			}
		case 2:
			System.out.println("los numeros seran generados en un rango de  [25.000, 999.900]");
			System.out.println();

			Random rand = new Random();
			int min = 25000;
			int max = 999900;
			int numeroAleatorio = 0;

			for (int i = 0; i < semanas; i++) {
				for (int j = 0; j < dias; j++) {

					numeroAleatorio = rand.nextInt(max - min + 1) + min;
					a.valor = numeroAleatorio;
					System.out.println("las ventas del dia " + p + " fueron: " + a.valor);

					mes[i][j] = a.valor;
					p++;
				}
			}
			break;
		default:
			System.out.println("Opción no válida");
		}

		System.out.println();
		System.out.println("las ventas del mes son: ");

		for (int i = 0; i < semanas; i++) {
			for (int j = 0; j < dias; j++) {
				System.out.print(mes[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();

		sem1 = ((mes[0][0]) + (mes[0][1]) + (mes[0][2]) + (mes[0][3]) + (mes[0][4]) + (mes[0][5]) + (mes[0][6]));
		sem2 = ((mes[1][0]) + (mes[1][1]) + (mes[1][2]) + (mes[1][3]) + (mes[1][4]) + (mes[1][5]) + (mes[1][6]));
		sem3 = ((mes[2][0]) + (mes[2][1]) + (mes[2][2]) + (mes[2][3]) + (mes[2][4]) + (mes[2][5]) + (mes[2][6]));
		sem4 = ((mes[3][0]) + (mes[3][1]) + (mes[3][2]) + (mes[3][3]) + (mes[3][4]) + (mes[3][5]) + (mes[3][6]));

		for (int i = 0; i < semanas; i++) {
			for (int j = 0; j < dias; j++) {
				String day = "";
				if (j == 0) {
					day = "Lunes";
				} else if (j == 1) {
					day = "Martes";
				} else if (j == 2) {
					day = "Miercoles";
				} else if (j == 3) {
					day = "Jueves";
				} else if (j == 4) {
					day = "Viernes";
				} else if (j == 5) {
					day = "Sabado";
				} else if (j == 6) {
					day = "domingo";
				}
				System.out.println("las ventas del " + day + " de la semana " + (i + 1) + " son: " + mes[i][j] + " ");
				if (j > 6) {
					j = 0;
				}
			}
			System.out.println();
		}

		System.out.println("1.) ********** TOTAL DE VENTAS DE CADA SEMANA **********");
		System.out.println();
		System.out.println("el total de ventas de la primera semana es: " + sem1);
		System.out.println();
		System.out.println("el total de ventas de la segunda semana es: " + sem2);
		System.out.println();
		System.out.println("el total de ventas de la tercera semana es: " + sem3);
		System.out.println();
		System.out.println("el total de ventas de la cuarta semana es: " + sem4);
		System.out.println();

		double[] matrizSemanas = { sem1, sem2, sem3, sem4 };
		int n = matrizSemanas.length;

		// Algoritmo de burbuja para ordenar de menor a mayor
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (matrizSemanas[j] > matrizSemanas[j + 1]) {
					// Intercambiar las variables si están en el orden incorrecto
					double temp = matrizSemanas[j];
					matrizSemanas[j] = matrizSemanas[j + 1];
					matrizSemanas[j + 1] = temp;
				}
			}
		}

		// Imprimir las variables ordenadas
		System.out.println(" ********* 2.) las ventas por semana ordenadas de menor a mayor: ");
		for (int i = 0; i < n; i++) {
			System.out.println(matrizSemanas[i] + " ");
		}

		// El promedio de ventas por semana y en el mes

		System.out.println("**************3.) El promedio de ventas por semana y en el mes**************");
		System.out.println();
		double promedioSem1 = sem1 / 7;
		System.out.println("el promedio de ventas de la semana 1 es de: " + promedioSem1);
		double promedioSem2 = sem2 / 7;
		System.out.println("el promedio de ventas de la semana 2 es de: " + promedioSem2);
		double promedioSem3 = sem3 / 7;
		System.out.println("el promedio de ventas de la semana 3 es de: " + promedioSem3);
		double promedioSem4 = sem4 / 7;
		System.out.println("el promedio de ventas de la semana 4 es de: " + promedioSem4);

		System.out.println();

		double sumaSemanas = (promedioSem1 + promedioSem2 + promedioSem3 + promedioSem4);
		
		double promedioMes = (sumaSemanas/ 4);
		System.out.println("el promedio de las ventas del mes es de: " + promedioMes);

		// El valor máximo vendido en cada semana y en el mes
		System.out.println();
		System.out.println("**************4.) El valor maximo vendido en cada semana y en el mes**************");
		System.out.println();

		double mayorS1 = mes[0][0]; // Suponemos que el primer elemento es el mayor
		double mayorS2 = mes[0][0];
		double mayorS3 = mes[0][0];
		double mayorS4 = mes[0][0];

		for (int j = 0; j < 7; j++) {
			if (mes[0][j] > mayorS1) {
				mayorS1 = mes[0][j];
			}
		}
		for (int j = 0; j < 7; j++) {
			if (mes[1][j] > mayorS2) {
				mayorS2 = mes[1][j];
			}
		}
		for (int j = 0; j < 7; j++) {
			if (mes[2][j] > mayorS3) {
				mayorS3 = mes[2][j];
			}
		}
		for (int j = 0; j < 7; j++) {
			if (mes[3][j] > mayorS4) {
				mayorS4 = mes[3][j];
			}
		}

		double mayormes = mes[0][0]; // Suponemos que el primer elemento es el mayor

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				if (mes[i][j] > mayormes) {
					mayormes = mes[i][j];
				}
			}
		}

		System.out.println("el valor maximo vendido en la semana 1 es de: " + mayorS1);
		System.out.println("el valor maximo vendido en la semana 2 es de: " + mayorS2);
		System.out.println("el valor maximo vendido en la semana 3 es de: " + mayorS3);
		System.out.println("el valor maximo vendido en la semana 4 es de: " + mayorS4);
		System.out.println();
		System.out.println("el valor maximo vendido del mes es de: " + mayormes);

		// El valor mínimo vendido en cada semana y en el mes
		System.out.println();
		System.out.println("************** 5.) El valor minimo vendido en cada semana y en el mes**************");
		System.out.println();

		double menorS1 = mes[0][0];
		double menorS2 = mes[0][0];
		double menorS3 = mes[0][0];
		double menorS4 = mes[0][0];

		for (int j = 0; j < 7; j++) {
			if (mes[0][j] < menorS1) {
				menorS1 = mes[0][j];
			}
		}
		for (int j = 0; j < 7; j++) {
			if (mes[1][j] < menorS2) {
				menorS2 = mes[1][j];
			}
		}
		for (int j = 0; j < 7; j++) {
			if (mes[2][j] < menorS3) {
				menorS3 = mes[2][j];
			}
		}
		for (int j = 0; j < 7; j++) {
			if (mes[3][j] < menorS4) {
				menorS4 = mes[3][j];
			}
		}

		double menormes = mes[0][0];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				if (mes[i][j] < menormes) {
					menormes = mes[i][j];
				}
			}
		}
		System.out.println("El valor minimo vendido en la semana 1 es de: " + menorS1);
		System.out.println("El valor minimo vendido en la semana 2 es de: " + menorS2);
		System.out.println("El valor minimo vendido en la semana 3 es de: " + menorS3);
		System.out.println("El valor minimo vendido en la semana 4 es de: " + menorS4);
		System.out.println();
		System.out.println("El valor minimo vendido en Todo el mes es de: " + menormes);

	
		
		//Que día se vende más
		System.out.println();
		System.out.println("************ 6.) que dia se vende mas ************");
		System.out.println();
		int diavendemas = 0;
		String day = "";
		mayormes = mes[0][0];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				if (mes[i][j] > mayormes) {
					mayormes = mes[i][j];
					
					if (j == 0) {
						day = "Lunes";
					} else if (j == 1) {
						day = "Martes";
					} else if (j == 2) {
						day = "Miercoles";
					} else if (j == 3) {
						day = "Jueves";
					} else if (j == 4) {
						day = "Viernes";
					} else if (j == 5) {
						day = "Sabado";
					} else if (j == 6) {
						day = "domingo";
					}
					if(i == 0) {
						diavendemas = 1;
					}else if(i == 1) {
						diavendemas = 2;
					}else if(i == 2) {
						diavendemas = 3;
					}else if(i == 3) {
						diavendemas = 4;
					}
				}
			}
		}
		System.out.println("el dia que mas se vende es el " + day + " de la " + diavendemas + " semana");
		
		//Que día se vende menos
		System.out.println();
		System.out.println("************ 7.) que dia se vende menos ************");
		System.out.println();
		int diavendemenos = 0;
		day = "";
		menormes = mes[0][0];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				if (mes[i][j] < menormes) {
					menormes = mes[i][j];
					
					if (j == 0) {
						day = "Lunes";
					} else if (j == 1) {
						day = "Martes";
					} else if (j == 2) {
						day = "Miercoles";
					} else if (j == 3) {
						day = "Jueves";
					} else if (j == 4) {
						day = "Viernes";
					} else if (j == 5) {
						day = "Sabado";
					} else if (j == 6) {
						day = "domingo";
					}
					if(i == 0) {
						diavendemenos = 1;
					}else if(i == 1) {
						diavendemenos = 2;
					}else if(i == 2) {
						diavendemenos = 3;
					}else if(i == 3) {
						diavendemenos = 4;
					}
				}
			}
		}
		System.out.println("el dia que menos se vende es el " + day + " de la " + diavendemenos + " semana");
		
		// Cuantos días esta por encima del promedio de ventas del mes
		System.out.println();
		System.out.println("************ 8.) DIAS POR ENCIMA DEL PROMEDIO DE VENTAS DEL MES ************");

		int diassuperior = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				if (mes[i][j] > promedioMes) {
					diassuperior++;
				}
			}
		}
		System.out.println("hay " + diassuperior + " dias que estan por encima del promedio de ventas del mes");
	}/// main

}
