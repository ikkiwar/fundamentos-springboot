package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{
    private String nombre;
    private String apellido;

    public MyBeanWithPropertiesImplement(final String nombre, final String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre+" "+apellido;
    }
}
