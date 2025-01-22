package org.example;

import java.util.ArrayList;

public class Blender implements IBlender {

    private byte powerStatus; // 0 - off, 1 - on 2 - suspended

    private byte speed; // 0 - 
    private ArrayList<String> products;
    private float capacity;
    private float maxCapacity;
    private boolean isEmpty = true;

    private int productsCount = 0;


    
    public void increaseSpeed() {
        if (this.powerStatus == 1 && this.actualCapacity() > 0) {
            if (this.speed <= 3 && this.speed >=0) {
                this.speed++;
            }
        } else {
            throw new IllegalStateException("The blender must be on and have a product to increase the speed.");
        }
    }

    public void decreaseSpeed(){
        if (this.powerStatus == 1 && this.actualCapacity() > 0) {
            if (this.speed <= 3 && this.speed >0) {
                this.speed--;
            } else if (this.speed == 0) {
               this.powerStatus = 0;
            }
        } else {
            throw new IllegalStateException("The blender must be on and have a product to decrease the speed.");
        }
    }

    public byte checkSpeed() {
        return this.speed;
    }

    public float actualCapacity() {
        return this.capacity;
    }

    public boolean isFull() {
        return this.capacity == this.maxCapacity;
    }

    public byte checkPowerStatus() {
        return this.powerStatus;
    }

    public byte switchPowerStatus(){
        if (this.powerStatus == 0) {
            // off
            this.powerStatus = 1;
            return 1;
        } else if (this.powerStatus == 1) {
            // on
            this.powerStatus = 2;
            return 2;
        } else { 
            // suspended
            this.powerStatus = 0;
            return 0;
        }
    }

  
   public void fillBlender(String prod, float ml) {
        if (this.powerStatus == 0) {
            throw new IllegalStateException("The blender must be on to fill it with a product.");
        }
        if (this.capacity + ml > this.maxCapacity) {
            throw new IllegalStateException("The blender is full.");
        }
        this.capacity += ml;
        this.products.add(prod);
    }

    // Se debe llenar con 250ml por defecto
    public void fillBlender(String prod) {
        if (this.powerStatus == 0) {
            throw new IllegalStateException("The blender must be on to fill it with a product.");
        }
        if (this.capacity + 250 > this.maxCapacity) {
            throw new IllegalStateException("The blender is full.");
        }
        this.capacity += 250;
        this.products.add(prod);
    }

    public void emptyBlender() {
        products = new ArrayList<String>;
        productsCount = 0; 
        isEmpty = true;
    }
    
}