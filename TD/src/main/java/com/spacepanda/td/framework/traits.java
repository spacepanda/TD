package com.spacepanda.td.framework;

import java.util.ArrayList;

/**
 * Created by Logan on 12/18/13.
 *
 */

interface Movement {
    //Returns true if unit is currently moveable
    boolean moveable();
    //Returns current speed
    int currentSpeed();
    //current movement type. For now, stored as an int.
    int movementType();
}

interface Attackable {
    //Returns true is unit is currently attackable
    boolean isAttackable();

    boolean isWeak(Attack attack);
    boolean isStrong(Attack attack);

    Status attackResult(Condition condition, Attack attack);
}

abstract class Stat {
    String name;
    double value;
    double modifiedValue;

    private void modify(double modifier) {
        modifiedValue += modifier;
    }

    private double getModifiedValue() {
        return modifiedValue;
    }

    private double getValue()  {
        return value;
    }
}


abstract class Attack {
    Stat attackRate;
    Stat attackRange;
    Stat attackDamage;
    Stat armorPenetration;
    Modifier modInflicted;
}

abstract class Status {
    Stat health;
    Stat speed;
    Stat armor;
    Stat range;


    //probably scrap this method.
    private ArrayList<Modifier> mods;

    private void addMod(Modifier mod) {
        mods.add(mod);
    }

    private boolean removeMod(Modifier mod) {
        if(mods.contains(mod)) {
            mods.remove(mod);
            return true;
        } else {
            return false;
        }
    }

    private void activateMods() {
        if(mods.size() > 0) {
            for(Modifier mod: mods) {
                mod.effect();
            }
        }
    }
}

abstract class Modifier {
    String name;
    String description;
    //this method is problematic, no easy way to reverse.
    abstract void effect();
    double duration;
}

interface Condition {
    //returns a status object containing units current vital stats
    abstract Status status();
    //contains intial values
    abstract void startingCondition();
    //Returns true if the unit is alive
    boolean alive();
}

