package com.spacepanda.td.framework;

public class GruntMob extends Mob {

    public void startingCondition() {
        mStatus = new Status(10, 5, 0, 0);

    }

    public int movementType() {
        //returns 0 for ground type.
        return 0;
    }

}