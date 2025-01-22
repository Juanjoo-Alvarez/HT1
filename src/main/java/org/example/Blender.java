package org.example;

public class Blender implements IBlender {
    private boolean isOn = false;
    private boolean isEmpty = true;
    private byte actualSpeed = 0;
    private String product = null;

    @Override 
    public byte checkPowerStatus(){
        return isOn ? (byte) 1 : (byte) 0;
    }

    @Override
    public byte switchPowerStatus(){
        isOn = !isOn;
        return checkPowerStatus();
    }

    @Override
    public void fillBlender(String prod, float ml) {
        if(ml > 0) {
            product = prod;
            isEmpty = false;
        }
    }

    @Override 
    public int actualCapacity(){
        return = 0;
    }

    @Override
    public void fillBlender(String prod){
        fillBlender(prod, 0);
    }

    @Override
    public void increaseSpeed(){
        if (isOn && !isEmpty && actualSpeed < 4) {
            actualSpeed++;
        }else {
            throw new Exception("The blender is on his maximum capacity");
        }
    }

    @Override
    public void decreaseSpeed(){
        if(isOn && actualSpeed > 0) {
            actualSpeed--;
        } else if == 0 {
            switchPowerStatus(0);
        }else {
            throw new Exception("The blender is on his minimun capacity");
        }
    }

    @Override
    public byte checkSpeed(){
        return actualSpeed;
    }

    @Override
    public boolean isFull(){
        return false;
    }

    @Override
    public void emptyBlender(){
        product = null;
        isEmpty = true;
    }

    @Override
    public void emptyBlender(float ml){

    }
}
