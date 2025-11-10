
class Shape {
    int size;
}

class Rectangle extends Shape {

    Rectangle() {
        super.size = 4;
    }
}

class ComplexNumber {

    int real;
    int imaginary;

    ComplexNumber(int real, int imaginary) {
        this.imaginary = imaginary;
        this.real = real;
    }

    public void add(ComplexNumber otherClass) {
        this.real = this.real + otherClass.real;
        this.imaginary = this.imaginary + otherClass.imaginary;

    }

    public void sub(ComplexNumber otherClass) {
        this.real = this.real - otherClass.real;
        this.imaginary = this.real - otherClass.imaginary;

    }

    public void mul(ComplexNumber otherClass) {
        this.real = this.real * otherClass.real;
        this.imaginary = this.imaginary * otherClass.imaginary;
    }

    @Override
    public String toString() {
        return "ComplexNumber [real=" + real + ", imaginary=" + imaginary + "]";
    }

}

class Questions {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(2, 3);

        ComplexNumber c2 = new ComplexNumber(3, 5);

        c1.add(c2);

        System.out.println(c1);

    }
}