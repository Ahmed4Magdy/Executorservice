package main.ClassesOfDecorator;

import main.Decorator.OperationDecorator;
import main.OperationInterface.Operation;

import java.util.Arrays;

 public class SortingOperation extends OperationDecorator {


     public SortingOperation(Operation operation) {
         super(operation);
     }

     @Override
    public StringBuilder transform(StringBuilder substring) {

         substring=super.transform(substring);
         String s = substring.toString();
         substring.setLength(0);
         char[] firstChar = s.toCharArray();
         Arrays.sort(firstChar);
         substring.append(firstChar);
         return substring;
    }
}