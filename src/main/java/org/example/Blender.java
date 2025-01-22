package org.example;

public class Blender implements IBlender {

    private byte powerStatus; // 0 - off, 1 - on 2 - suspended

    private byte speed; // 0 - 

    
    public void increaseSpeed() {
        if (this.powerStatus == 2 && this.actualCapacity() > 0) {
            if (this.speed <= 3 && this.speed >=0) {
                this.speed++;
            }
        } else {
            throw new IllegalStateException("The blender must be on and have a product to increase the speed.");
        }
    }

    public void decreaseSpeed(){
        if (this.powerStatus == 2 && this.actualCapacity() > 0) {
            if (this.speed <= 3 && this.speed >0) {
                this.speed--;
            } else if (this.speed == 0) {
                switchPowerStatus(0);
            }
        } else {
            throw new IllegalStateException("The blender must be on and have a product to decrease the speed.");
        }
    }

    public byte checkSpeed() {
        return this.speed;
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
    
}
