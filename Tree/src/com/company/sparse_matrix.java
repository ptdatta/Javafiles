package com.company;

// Java code to perform add,
// multiply and transpose on sparse matrices

public class sparse_matrix {

    // Maximum number of elements in matrix
    int MAX = 100;

    // Array representation
    // of sparse matrix
    //[][0] represents row
    //[][1] represents col
    //[][2] represents value
    int data[][] = new int[MAX][3];

    // dimensions of matrix
    int row, col;

    // total number of elements in matrix
    int len;

    public sparse_matrix(int r, int c)
    {

        // initialize row
        row = r;

        // initialize col
        col = c;

        // initialize length to 0
        len = 0;
    }

    // insert elements into sparse matrix
    public void insert(int r, int c, int val)
    {

        // invalid entry
        if (r > row || c > col) {
            System.out.println("Wrong entry");
        }

        else {

            // insert row value
            data[len][0] = r;

            // insert col value
            data[len][1] = c;

            // insert element's value
            data[len][2] = val;

            // increment number of data in matrix
            len++;
        }
    }



    public sparse_matrix transpose()
    {

        // new matrix with inversed row X col
        sparse_matrix result = new sparse_matrix(col, row);

        // same number of elements
        result.len = len;

        // to count number of elements in each column
        int count[] = new int[col + 1];

        // initialize all to 0
        for (int i = 1; i <= col; i++)
            count[i] = 0;

        for (int i = 0; i < len; i++)
            count[data[i][1]]++;

        int[] index = new int[col + 1];

        // to count number of elements having col smaller
        // than particular i

        // as there is no col with value < 1
        index[1] = 0;

        // initialize rest of the indices
        for (int i = 2; i <= col; i++)

            index[i] = index[i - 1] + count[i - 1];

        for (int i = 0; i < len; i++) {

            // insert a data at rpos and increment its value
            int rpos = index[data[i][1]]++;

            // transpose row=col
            result.data[rpos][0] = data[i][1];

            // transpose col=row
            result.data[rpos][1] = data[i][0];

            // same value
            result.data[rpos][2] = data[i][2];
        }

        // the above method ensures
        // sorting of transpose matrix
        // according to row-col value
        return result;
    }



    // printing matrix
    public void print()
    {
        System.out.println("Dimension: " + row + "x" + col);
        System.out.println("Sparse Matrix: \nRow Column Value");

        for (int i = 0; i < len; i++) {

            System.out.println(data[i][0] + " "
                    + data[i][1] + " " + data[i][2]);
        }
    }

    public static void main(String args[])
    {

        // create two sparse matrices and insert values
        sparse_matrix a = new sparse_matrix(6, 5);


        a.insert(2, 2, -76);
        a.insert(2, 3, -12);
        a.insert(3, 1, -30);
        a.insert(4, 1, -6);
        a.insert(4, 3, -5);
        a.insert(5,2,-10);

        // Output resul
        System.out.println("\nTranspose: ");
        sparse_matrix atranspose = a.transpose();
        atranspose.print();
    }
}

// This code is contributed by Sudarshan Khasnis
