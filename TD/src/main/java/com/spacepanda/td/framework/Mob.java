package com.spacepanda.td.framework;
import com.spacepanda.td.*;
/**
 * Created by Logan on 12/18/13.
 *
 * Building blocks of an enemy.
 */
public abstract class Mob implements Movement, Stats, Condition {

    //required methods to implement Movemement

    //Returns true if the unit is alive & no status conditions have
    //rendered movement impossible.
    public boolean moveable() {
        if(alive()){

        }
    }
    abstract public int currentSpeed();
    abstract public int movementType();

    //required methods to implement Stats
    abstract public double range();
    abstract public double speed();
    abstract public Attack attackValue();
    abstract public double armor();

    //required methods to implement Condition
    abstract public Status status();
    abstract public void startingCondition();
    abstract public boolean alive();
}
