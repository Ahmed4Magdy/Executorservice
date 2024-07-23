package main.OperationInterface.impl;

import main.OperationInterface.Operation;

public class BaseClass implements Operation {


    @Override
    public StringBuilder transform(StringBuilder substring) {
        return substring;
    }
}
