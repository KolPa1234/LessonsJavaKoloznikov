package Exceptions.ExceptionsPart4;

import java.io.IOException;
import java.text.ParseException;

public class ExceptionsPatr4 {
    public static void main(String[] args)throws IOException, ParseException {

        try {
            run();
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
       //try {
           //run();
       //}catch (IOException e){
           //e.printStackTrace();
     //  }catch (ParseException e){
           //e.printStackTrace();
       //}
    }
    public static void run()throws IOException,  IllegalArgumentException, ParseException {


    }
}
