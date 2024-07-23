package main.StringFunifier;
import main.OperationInterface.Operation;

import java.util.List;
import java.util.concurrent.*;
import java.util.ArrayList;

public class StringFunifier {

    private String boringString;
    private List<Integer> startIndexes;
    private List<Integer> endIndexes;
    private List<Operation> funOperations;

    public StringFunifier(String boringString, List<Integer> startIndexes, List<Integer> endIndexes, List<Operation> funOperations) {
        this.boringString = boringString;
        this.startIndexes = startIndexes;
        this.endIndexes = endIndexes;
        this.funOperations = funOperations;
    }

    public String getFunnyString() throws InterruptedException, ExecutionException {
        StringBuilder result = new StringBuilder();
        int current = 0;

        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<StringBuilder>> futures = new ArrayList<>();

        for (int i = 0; i < startIndexes.size(); i++) {
            int start = startIndexes.get(i);
            int end = endIndexes.get(i);
            Operation operation = funOperations.get(i);


            // Submit each operation to the executor
            futures.add(executor.submit(() -> {
                StringBuilder builder = new StringBuilder(boringString.substring(start, end + 1));
                return operation.transform(builder);
            }));

//            result.append(boringString, current, start);
//            current = end + 1;
        }

        for (int i = 0; i < startIndexes.size(); i++) {
            int start = startIndexes.get(i);
            int end = endIndexes.get(i);
            StringBuilder funSubString = futures.get(i).get();

            result.append(boringString, current, start);
            result.append("(").append(funSubString).append(")");
            current = end + 1;
        }

        executor.shutdown();
        return result.toString();
    }

}























//package main;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Vector;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class StringFunifier {
//
//    String boringString;
//    List<Integer> startIndexes = new ArrayList<>();
//    List<Integer> endIndexes = new ArrayList<>();
//    List<Operation> funOperations = new ArrayList<>();
//    Vector<OperationThreadedOutput> v = new Vector<>();
//
//
//    public StringFunifier(String boringString, List<Integer> startIndexes, List<Integer> endIndexes, List<Operation> funOperations) {
//
//        this.boringString = boringString;
//        this.startIndexes = startIndexes;
//        this.endIndexes = endIndexes;
//        this.funOperations = funOperations;
//
//    }
//
//    public String getStringFunifier() {
//
//        StringBuilder result = new StringBuilder();
//        int current = 0;
//        // start threads for different ranges
////        List<String>OPERATIONSEXECUTOR = new ArrayList<>(boringString,startIndexes,endIndexes,funOperations);
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//
//
//        for (int i = 0; i < startIndexes.size(); i++) {
//            int start = startIndexes.get(i);
//            int end = endIndexes.get(i);
//            // String operation = funOperations.get(i);
//            result.append(boringString, current, start);
//
//
//
//            StringBuilder str = new StringBuilder(boringString.substring(start, end + 1));
//
//            funOperations.get(i).transform(str);
////            search v for id = i
//// wait for thread result => threadResult
//
//
//
//            result.append('(').append(str).append(')');
//
//            current = end + 1;
//        }
//
//        result.append(boringString.substring(current));
//        return result.toString();
//    }
//
//}


