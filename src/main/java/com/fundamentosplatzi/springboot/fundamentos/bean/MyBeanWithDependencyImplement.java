package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements  MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
   private  MyOperation myOperation;

    public MyBeanWithDependencyImplement(final MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos Ingresado al metodo print with dependency");
        int numero = 1;
        LOGGER.debug("El Numero enviado como parametro es: "+numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("hola desde mi implementacion con dependencias");
    }
}
