package ru.geekbrains.spring_less_web.excemption;

public class ResorseNotFoundExecemption extends RuntimeException{
    public ResorseNotFoundExecemption(String message) {
        super(message);
    }
}
