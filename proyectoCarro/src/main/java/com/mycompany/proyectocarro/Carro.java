/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocarro;

import java.util.Scanner;

/**
 *
 * @author sistemas
 */
public class Carro {
    public String color;
    private char placa;
    protected String chasis;
    public int modelo;
    public String marca;
    
    Scanner consola = new Scanner(System.in);
    public Carro() {
    }

    public Carro(String color, char placa, String chasis, int modelo, String marca) {
        this.color = color;
        this.placa = placa;
        this.chasis = chasis;
        this.modelo = modelo;
        this.marca = marca;
    }
    
    
        
    public Carro(String color){
        this.color = color;
    }

    //------getter and setter-------
    
    public String getColor() {
        
        return color;
    }

    public void setColor(String color) {
        System.out.println("Ingresa el color del auto: ");
        color = consola.nextLine();
        this.color = color;
    }

    public char getPlaca() {
        return placa;
    }

    public void setPlaca(char placa) {
        this.placa = placa;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
