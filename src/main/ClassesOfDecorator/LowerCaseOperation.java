package main.ClassesOfDecorator;

import main.Decorator.OperationDecorator;
import main.OperationInterface.Operation;

public class LowerCaseOperation extends OperationDecorator {


    public LowerCaseOperation(Operation operation) {
        super(operation);
    }


    @Override
    public StringBuilder transform(StringBuilder substring) {
        substring=super.transform(substring);

        for (int i = 0; i < substring.length(); i++) {
            if (Character.isUpperCase(substring.charAt(i))) {
                substring.setCharAt(i,
                        Character.toLowerCase(substring.charAt(i)));
            }
        }
        return substring;
    }
}