package main.javasource.come.magicvet.model;

import lombok.Data;

@Data
public class Dog extends  Pet{

    private Size size;

    private HeathStatus heathStatus;

    public Dog(){}
    @Override
    public String toString() {
        return "{"
                +"\n\tType - " + getType()
                + "\n\tSex - " + getSex()
                +"\n\tAge - " + getAge()
                +"\n\tName - " + getName()
                +"\n\tSize - " + getSize()
                +"\n\tOwner - " + getOwner()
                +"\n\t}";
    }

    public Dog(Size size,String age,HeathStatus heathStatus){
        super.setAge(age);
        this.size = size;
        this.heathStatus = heathStatus;
    }



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
        public static Size fromString(String value){
            for(Size size1 : values()){
                if(size1.toString().equals(value)){
                    return size1;
                }
            }
            System.out.println("Unable to parse data: " + value + " .Using default value " + UNKNOWN);
            return UNKNOWN;
        }
        public int getValue(){
            return value;
        }
    }
}

