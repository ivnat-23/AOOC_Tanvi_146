import java.util.Scanner;
public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] A = new int[2][2];
        int[][] B = new int[2][2];
        int[][] result = new int[2][2];
        System.out.println("Enter elements of Matrix A (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter elements of Matrix B (2x2):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        int choice;
        do {
            System.out.println("\n===== Matrix Operations Menu =====");
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Transpose of Matrix A");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            result[i][j] = A[i][j] + B[i][j];
                        }
                    }
                    System.out.println("Result of Addition:");
                    printMatrix(result);
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            result[i][j] = 0;
                            for (int k = 0; k < 2; k++) {
                                result[i][j] += A[i][k] * B[k][j];
                            }
                        }
                    }
                    System.out.println("Result of Multiplication:");
                    printMatrix(result);
                    break;
                case 3:
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            result[i][j] = A[j][i];
                        }
                    }
                    System.out.println("Transpose of Matrix A:");
                    printMatrix(result);
                    break;
                case 4:
                    System.out.println("Exiting Program... Thank You!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}