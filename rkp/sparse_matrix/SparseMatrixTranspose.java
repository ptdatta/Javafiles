package sparse_matrix;

import java.util.*;

public class SparseMatrixTranspose {

    static class MatrixElement {
        int row;
        int column;
        int value;

        MatrixElement(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + column + ", " + value + ")";
        }
    }

    public static List<MatrixElement> transposeSparseMatrix(List<MatrixElement> matrix, int numRows, int numCols) {
        List<MatrixElement> transposedMatrix = new ArrayList<>();

        for (MatrixElement element : matrix) {
            transposedMatrix.add(new MatrixElement(element.column, element.row, element.value));
        }

        transposedMatrix.sort(Comparator.comparingInt((MatrixElement e) -> e.row)
                                        .thenComparingInt(e -> e.column));

        return transposedMatrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int numCols = scanner.nextInt();

        System.out.print("Enter the number of non-zero elements: ");
        int numNonZeroElements = scanner.nextInt();

        List<MatrixElement> sparseMatrix = new ArrayList<>();

        System.out.println("Enter the non-zero elements as (row, column, value): ");
        for (int i = 0; i < numNonZeroElements; i++) {
            System.out.print("Enter row, column, value: ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            int value = scanner.nextInt();
            sparseMatrix.add(new MatrixElement(row, column, value));
        }

        System.out.println("\nOriginal Sparse Matrix:");
        for (MatrixElement element : sparseMatrix) {
            System.out.println(element);
        }

        List<MatrixElement> transposedMatrix = transposeSparseMatrix(sparseMatrix, numRows, numCols);

        System.out.println("\nTransposed Sparse Matrix (lexicographic order):");
        for (MatrixElement element : transposedMatrix) {
            System.out.println(element);
        }

        scanner.close();
    }
}
