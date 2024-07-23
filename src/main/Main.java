package main;

import main.ClassesOfDecorator.CompressionOperation;
import main.ClassesOfDecorator.ReverseOperation;
import main.ClassesOfDecorator.SortingOperation;
import main.ClassesOfDecorator.UpperCaseOperation;
import main.OperationInterface.Operation;
import main.OperationInterface.impl.BaseClass;
import main.StringFunifier.StringFunifier;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Scanner input = new Scanner(System.in);
        String boringstring = input.nextLine();

        List<Integer> startIndexes = List.of(1, 5, 7, 11, 13);
        List<Integer> endIndexes = List.of(3, 5, 10, 12, 14);
        List<Operation> operations = List.of(
                new ReverseOperation(new CompressionOperation(new BaseClass())),
                new UpperCaseOperation((new BaseClass())),
                new CompressionOperation(new UpperCaseOperation(new SortingOperation(new BaseClass()))),
                new CompressionOperation(new BaseClass()),
                new ReverseOperation(new UpperCaseOperation(new CompressionOperation(new BaseClass())))

        );

//        StringFunifier sd = new StringFunifier(boringstring ,  startIndexes, endIndexes , operations);
//        System.out.println(sd.getStringFunifier());

//        long startTime = System.nanoTime();
//        String funnyString = sd.getFunnyString();
//        long endTime = System.nanoTime();

//        System.out.println("Funny String: " + funnyString);
//        System.out.printf("Execution Time: %.2f milliseconds%n", (endTime - startTime) / 1e6);



        long start =System.currentTimeMillis();
        System.out.println("before ");
        System.out.println(start);


         //totalexecutiontime
//        System.out.println(end-start);

        StringFunifier sd = new StringFunifier(boringstring, startIndexes, endIndexes, operations);
        System.out.println(sd.getFunnyString());
        System.out.println("after");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
