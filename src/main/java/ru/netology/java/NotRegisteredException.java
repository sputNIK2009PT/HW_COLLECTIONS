package ru.netology.java;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String name){
        super("Игрок " + name + ", не найден");
    }
}