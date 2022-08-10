package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements  MyBeanWithDependency{

    MyOperation myOperation;

    public MyBeanWithDependencyImplement(final MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 1;
        System.out.println(myOperation.sum(numero));
        System.out.println("hola desde mi implementacion con dependencias");
    }
}
