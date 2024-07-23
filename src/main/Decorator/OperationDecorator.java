package main.Decorator;

import main.OperationInterface.Operation;

public abstract class OperationDecorator implements Operation {

    protected Operation operation;


    public OperationDecorator(Operation operation) {

        this.operation = operation;
    }

    @Override
    public StringBuilder transform(StringBuilder substring) {
        return operation.transform(substring);
    }
}
