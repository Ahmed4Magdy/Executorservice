package main.ClassesOfDecorator;

import main.Decorator.OperationDecorator;
import main.OperationInterface.Operation;

public class UpperCaseOperation extends OperationDecorator {



     public UpperCaseOperation(Operation operation) {
         super(operation);
     }

     @Override
    public StringBuilder transform(StringBuilder substring) {

         substring=super.transform(substring);

         for (int i = 0; i < substring.length(); i++) {
             if (Character.isLowerCase(substring.charAt(i))) {
                 substring.setCharAt(i,
                         Character.toUpperCase(substring.charAt(i)));
             }
         }
         return substring;
    }

 }