package org.example;

import java.util.ArrayList;

/**
 * Clase que representa una licuadora, con funcionalidades para controlar su estado,
 * velocidad, capacidad y los productos que contiene.
 */
public class Blender implements IBlender {

    private byte powerStatus = 0; // 0 - off, 1 - on, 2 - suspended
    private byte speed = 0; // 0 - lowest speed, 3 - highest speed
    private ArrayList<String> products;
    private float capacity = 1;
    private float maxCapacity;

    /**
     * Aumenta la velocidad de la licuadora si está encendida y contiene productos.
     * La velocidad puede aumentar de 0 a 3.
     *
     * @throws IllegalStateException si la licuadora está apagada o no tiene productos.
     */
    public void increaseSpeed() {
        if (this.powerStatus == 1 && this.actualCapacity() > 0) {
            if (this.speed <= 3 && this.speed >=0) {
                this.speed++;
            }
        } else {
            throw new IllegalStateException("The blender must be on and have a product to increase the speed.");
        }
    }

    /**
     * Disminuye la velocidad de la licuadora si está encendida y contiene productos.
     * La velocidad puede disminuir de 3 a 0. Si la velocidad es 0, la licuadora se apaga.
     *
     * @throws IllegalStateException si la licuadora está apagada o no tiene productos.
     */
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

    /**
     * Obtiene la velocidad actual de la licuadora.
     *
     * @return la velocidad actual de la licuadora.
     */
    public byte checkSpeed() {
        return this.speed;
    }

    /**
     * Devuelve la capacidad actual de la licuadora.
     *
     * @return la capacidad actual en mililitros.
     */
    public float actualCapacity() {
        return this.capacity;
    }

    /**
     * Verifica si la licuadora está llena.
     *
     * @return {@code true} si la licuadora está llena, {@code false} en caso contrario.
     */
    public boolean isFull() {
        return this.capacity == this.maxCapacity;
    }

    /**
     * Obtiene el estado de encendido/apagado de la licuadora.
     *
     * @return el estado de encendido: 0 - apagado, 1 - encendido, 2 - suspendido.
     */
    public byte checkPowerStatus() {
        return this.powerStatus;
    }

    /**
     * Cambia el estado de encendido/apagado de la licuadora.
     * Si está apagada, pasa a encendida; si está encendida, se suspende; si está suspendida, se apaga.
     *
     * @return el nuevo estado de la licuadora después de cambiar: 0 - apagado, 1 - encendido, 2 - suspendido.
     */
    public byte switchPowerStatus(){
        if (this.powerStatus == 0) {
            // apagado
            this.powerStatus = 1;
            return 1;
        } else if (this.powerStatus == 1) {
            // encendido
            this.powerStatus = 2;
            return 2;
        } else {
            // suspendido
            this.powerStatus = 0;
            return 0;
        }
    }

    /**
     * Llena la licuadora con un producto y una cantidad de mililitros especificada.
     *
     * @param prod el nombre del producto a agregar.
     * @param ml la cantidad de mililitros a agregar al vaso.
     * @throws IllegalStateException si la licuadora está apagada o si se excede la capacidad máxima.
     */
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

    /**
     * Llena la licuadora con un producto y una cantidad de 250 ml por defecto.
     *
     * @param prod el nombre del producto a agregar.
     * @throws IllegalStateException si la licuadora está apagada o si se excede la capacidad máxima.
     */
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

    /**
     * Vacía la licuadora de todos los productos y restablece la capacidad a 0.
     */
    public void emptyBlender() {
        this.products.clear();
        this.capacity = 0;
    }

    /**
     * Vacía la licuadora de una cantidad específica de mililitros.
     *
     * @param ml la cantidad de mililitros a vaciar de la licuadora.
     * @throws IllegalStateException si la cantidad a vaciar excede la capacidad actual.
     */
    public void emptyBlender(float ml) {
        if (this.capacity - ml < 0) {
            throw new IllegalStateException("The blender is empty.");
        }
        this.capacity -= ml;
    }
}