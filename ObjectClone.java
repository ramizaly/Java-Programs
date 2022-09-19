public class ObjectClone {
    
public static void main(String[] args) {
    Dog pet1 = new Dog("Tom");
    petowner num1 = new petowner("Ali" , pet1);
    petowner num2 = null;
    try
    {
        num2 = (petowner)num1.clone();
        System.out.println(num2);            

    } catch(CloneNotSupportedException e)
    {
        e.printStackTrace();
    }
    num1.name = "ahmed";
    num1.dog.name = "hero";
    System.out.println(num1);
    System.out.println(num2);
    if(num1.dog.hashCode() == num2.dog.hashCode())
    {
        System.out.println("Hi");
    }
}



}

class Dog implements Cloneable
{
    
    String name;
    //Bone bone;

    public String toString()
    {
       return "The name is" + name;
    }
    public Dog(String name)
    {
        this.name = name;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
     Dog duplicate = (Dog) super.clone();
     
     return duplicate;
    }
}

class petowner implements Cloneable
{
    String name;
    Dog dog;

    public String toString()
    {
        return "The name of the owner is:" + name + "and the name of the dog is: " + dog.name ;
    }
    public petowner(String name , Dog dog)
    {
        this.name = name;
        this.dog = dog;
    }
    public void setDog(Dog dog) {
        this.dog = dog;
    }
    public Dog getDog() {
        return dog;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
     petowner duplicate = (petowner) super.clone();
     duplicate.setDog((Dog)duplicate.getDog().clone()); //Because the dog object of duplicate and dog object of super is same hence duplicate.getdog works
     return duplicate;
    }
}