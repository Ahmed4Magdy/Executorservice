package main.ClassesOfDecorator;

import main.Decorator.OperationDecorator;
import main.OperationInterface.Operation;

public class ReverseOperation extends OperationDecorator {


    public ReverseOperation(Operation operation) {
        super(operation);
    }



    @Override
    public StringBuilder transform(StringBuilder substring) {
        substring=super.transform(substring);
        substring.reverse();
        return substring;
    }
}

