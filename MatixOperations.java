import java.util.Scanner;

 interface Matrix
{
    public double getElem(int i , int j);
    public void setElem(int i , int j , double value);
    public Matrix add(Matrix other);
    public Matrix Multiply(Matrix other);
}
class matrix2DArray implements Matrix
{
    double data[][];
    int height;
    int width;

    public matrix2DArray(int height , int widhth)
    {
        this.height = height;
        this.width = widhth;
        data = new double[height][widhth];
    }

    public double getElem(int i , int j)
    {
        double value = this.data[i][j];
        return value;
    }
    public void setElem(int i , int j , double value)
    {
        this.data[i][j] = value;
    }
    public void initalizeMatrix()
    {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.println("Enter the element at position (" + i + ',' + j + ")");
                int elem = scanner.nextInt();
                this.setElem(i, j, elem);
            }
        }
        // scanner.close();
    }
    public Matrix add(Matrix other)
    {
        Matrix result = new matrix2DArray(this.height, this.width);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                result.setElem(i, j, this.getElem(i, j)+ other.getElem(i, j));
            }
        }
        return result;
    }

    public String toString()
    {
        String result = "The resulting Matrix is\n";
        for (int i = 0; i < data.length; i++) {
            result += "\n";
            for (int j = 0; j < data[0].length; j++) {
                result += this.getElem(i, j) + "\t";
            }
        }
        return result;

    }
    public Matrix Multiply(Matrix other)
    {
        double elem;
        Matrix result = new matrix2DArray(this.height, this.width);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                elem = 0;
                for (int j2 = 0; j2 < data.length; j2++) {
                    elem += this.getElem(i, j2)*other.getElem(j2, j);
                }
                result.setElem(i, j, elem);
            }
        }
        return result;
    }
    private double min(double a , double b)
    {
        double min = a>b?b:a;
        return min;
    }

}

abstract class matrixLin implements Matrix
{
    protected double data[];
    protected int height;
    protected int width;
    

    public abstract matrix2DArray deliniarize();
    protected double min(double a , double b)
    {
        double min = a>b?b:a;
        return min;
    }
}

class matrixrowWise extends matrixLin
{
    int len;
    public matrixrowWise(int height , int width)
    {
        this.height = height;
        this.width = width; 
        data = new double[width];
        len = (int) Math.sqrt(this.data.length);
    }

    @Override
    public matrix2DArray deliniarize()
    {
        int k = 0;
        
        matrix2DArray matrix = new matrix2DArray(len, len);
        for (int i = 0; i < matrix.data.length; i++) {
            for (int j = 0; j < matrix.data[0].length; j++) {
                if(k<=this.data.length)
                {
                    matrix.setElem(i, j, this.data[k++]);
                }
            }
        }
        return matrix;
    }

    @Override
    public double getElem(int i , int j)
    {
        double elem = 0.0;
        int index = -1;
        for (int k = 0; k < len; k++) {
            for (int k2 = 0; k2 < len; k2++) {
                index++;
                if(k==i && k2==j)
                {
                    elem = this.data[index];
                    break;
                }
            }
        }
        return elem;
    }
    
    @Override
    public void setElem(int i , int j , double value)
    {
        int index = -1;
        for (int k = 0; k < len; k++) {
            for (int k2 = 0; k2 < len; k2++) {
                index++;
                if(k==i && k2==j)
                {
                    this.data[index] = value;
                    break;
                }
            }
        }
    }

    public void insert()
    {
        Scanner newscan = new Scanner(System.in);
        for (int i = 0; i < this.data.length; i++) {
            System.out.println("Enter the element at index no" + " " + i);
            int elem = newscan.nextInt();
            // this.setElem(i, j, value);
            this.data[i] = elem;
        }
    }

    public Matrix add(Matrix other)
    {
        Matrix result = new matrixrowWise(0, this.data.length);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                
            result.setElem(i, j, this.getElem(i, j) + other.getElem(i, j));
            }
        }
        return result;
    }
    public Matrix Multiply(Matrix other)
    {
        double elem;
        Matrix result = new matrixrowWise(0, this.data.length);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                elem = 0;
                for (int j2 = 0; j2 < data.length; j2++) {
                    elem += this.getElem(i, j2)*other.getElem(j2, j);
                }
                result.setElem(i, j, elem);
            }
        }
        return result;
    }

    public String toString()
    {
        String result = "The resulting Array is\n";
        for (int i = 0; i < this.data.length; i++) {
            result += this.data[i] + "\t";
        }
        return result;
    }
}

class matrixColumnWise extends matrixLin
{
    int len;
    public matrixColumnWise(int height , int width)
    {
        this.height = height;
        this.width = width; 
        data = new double[width];
        len = (int) Math.sqrt(this.data.length);
    }

    @Override
    public matrix2DArray deliniarize()
    {
        int k = 0;
        
        matrix2DArray matrix = new matrix2DArray(len, len);
        for (int i = 0; i < matrix.data.length; i++) {
            for (int j = 0; j < matrix.data[0].length; j++) {
                if(k<=9)
                {
                    matrix.setElem(j, i, this.data[k++]);
                }
            }
        }
        return matrix;
    }
    @Override
    public double getElem(int i , int j)
    {
        double elem = 0.0;
        int index = -1;
        for (int k = 0; k < len; k++) {
            for (int k2 = 0; k2 < len; k2++) {
                index++;
                if(k2==i && k==j)
                {
                    elem = this.data[index];
                    break;
                }
            }
        }
        return elem;
    }
    @Override
    public void setElem(int i , int j , double value)
    {
        int index = -1;
        for (int k = 0; k < len; k++) {
            for (int k2 = 0; k2 < len; k2++) {
                index++;
                if(k2==i && k==j)
                {
                    this.data[index] = value;
                    break;
                }
            }
        }
    }

    public void insert()
    {
        Scanner newscan = new Scanner(System.in);
        for (int i = 0; i < this.data.length; i++) {
            System.out.println("Enter the element at index no" + " " + i);
            int elem = newscan.nextInt();
            // this.setElem(i, j, value);
            this.data[i] = elem;
        }
    }

    public Matrix add(Matrix other)
    {
        Matrix result = new matrixrowWise(0, this.data.length);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                
            result.setElem(i, j, this.getElem(i, j) + other.getElem(i, j));
            }
        }
        return result;
    }

    public Matrix Multiply(Matrix other)
    {
        double elem;
        Matrix result = new matrixrowWise(0, this.data.length);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                elem = 0;
                for (int j2 = 0; j2 < data.length; j2++) {
                    elem += this.getElem(i, j2)*other.getElem(j2, j);
                }
                result.setElem(i, j, elem);
            }
        }
        return result;
    }

    public String toString()
    {
        String result = "The resulting Array is\n";
        for (int i = 0; i < this.data.length; i++) {
            result += this.data[i] + "\t";
        }
        return result;
    }
    
}





public class MatixOperations
{
    public static void main(String[] args) {
    
        new matrixtest().run();
   

    }

    public void run()
    {
    //Instantiating a 3x3 Matrix
        matrix2DArray matrix2DArray = new matrix2DArray(3, 3);
        //Input your Elements
        matrix2DArray.initalizeMatrix();
        System.out.println(matrix2DArray);

        //Instantiating a 3x3 Matrix
        matrix2DArray matrix2DArray2 = new matrix2DArray(3, 3);
        //Input your Elements
        matrix2DArray2.initalizeMatrix();

        //Adding Both Matrices
        System.out.println(matrix2DArray.add(matrix2DArray2));

        // Multiplying both matrices
        System.out.println(matrix2DArray.Multiply(matrix2DArray2));

        // Instantiating a Row wise matrix
        matrixrowWise matrix1 = new matrixrowWise(0,9);
        //input the elements
        matrix1.insert();
        System.out.println(matrix1);

        // Instantiating another Row wise matrix
        matrixrowWise matrix2 = new matrixrowWise(0,9);
        //Input the elements
        matrix2.insert();
        System.out.println(matrix2);
        
        //Adding two row wise matrices
        System.out.println(matrix1.add(matrix2));

        //Multiplying two row wise matrices
        System.out.println(matrix1.Multiply(matrix2));
    
        //Delinearizing the row wise matrix
        System.out.println(matrix1.deliniarize());

        //Instantiating a column wise matrix
        matrixColumnWise matrix3 = new matrixColumnWise(0,9);
        // input the elements
        matrix3.insert();
        System.out.println(matrix3);

        //Instantiating another column wise matrix
        matrixColumnWise matrix4 = new matrixColumnWise(0,9);
        // input the elements
        matrix4.insert();
        System.out.println(matrix4);
    
        // Adding two column wise matrices
        System.out.println(matrix3.add(matrix4));

        // Multiplying two column wise matrices
        System.out.println(matrix3.Multiply(matrix4));
    
        //Deliniarizing a column wise matrix
        System.out.println(matrix3.deliniarize());
    }
}

