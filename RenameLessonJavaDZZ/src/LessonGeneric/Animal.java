package LessonGeneric;

public class Animal {
    public int id;
   public Animal (int id){
       this.id = id;
   }
   public void eat(){
       System.out.println("Animal eating....");
   }
   public Animal(){
   }
   public String toString(){
       return String.valueOf(id);
   }
}
