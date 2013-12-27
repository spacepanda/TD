package com.spacepanda.td.framework;

public class GruntMob extends Mob {

    public void startingCondition() {
        mStatus = new Status()
    }

    public int movementType() {
        //returns 0 for ground type.
        return 0;
    }

}