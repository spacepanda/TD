package com.spacepanda.td.framework;
import com.spacepanda.td.*;
/**
 * Created by Logan on 12/18/13.
 *
 * Building blocks of an enemy.
 */
public abstract class Mob implements Movement, Condition {

    Status mStatus;
    Attack mAttack;


    //required methods to implement Movemement

    //Returns true if the unit has no status conditions that
    //render movement impossible.
    public boolean moveable() {
        if(this.currentSpeed() > 0)
            return true;
        else
            return false;

    }
    public double currentSpeed() {
        return this.status().speed.getModifiedValue();
    }

    //must be implemented by each subtype
    //currently 0 = ground, 1 = flying.
    abstract public int movementType();

    //returns this units attack capabilities
    public Attack attack() {
        return mAttack;
    }

    //required methods to implement Condition

    //return current status
    public Status status() {
        return mStatus;
    }

    //must be implemented by each subclass and contain starting stat values.
    //initializes mStatus and mAttack
    abstract public void startingCondition();
    //returns true if this mob is alive
    public boolean alive() {
        if (this.status().health.getModifiedValue() > 0)
            return true;
        return false;
    }
}
