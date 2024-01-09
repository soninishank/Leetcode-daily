class ParkingSystem {

    int bigCarParkingSlot;
    int mediumCarParkingSlot;
    int smallCarParkingSlot;
    public ParkingSystem(int big, int medium, int small) {
        this.bigCarParkingSlot = big;
        this.mediumCarParkingSlot = medium;
        this.smallCarParkingSlot = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
           return  bigCarParkingSlot-- > 0;
        }else if(carType == 2){
            return  mediumCarParkingSlot-- > 0;
        }else if(carType == 3){
            return smallCarParkingSlot-- > 0;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */