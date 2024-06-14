package main.java.come.magicvet.model;


public class Dog extends  Pet{

    private Size size;

    private HeathStatus heathStatus;

    public Dog(){}

    public Dog(Size size,String age,HeathStatus heathStatus){
        super.setAge(age);
        this.size = size;
        this.heathStatus = heathStatus;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public HeathStatus getHeathStatus() {return heathStatus;}

    public enum Size{
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0)
        ;

        private final int value;

        Size(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
}

