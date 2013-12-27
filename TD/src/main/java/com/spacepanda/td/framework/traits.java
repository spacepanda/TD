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
    double currentSpeed();
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

interface Condition {
    //returns a status object containing units current vital stats
    abstract Status status();
    //contains intial values
    abstract void startingCondition();
    //Returns true if the unit is alive
    boolean alive();
}

class Stat {
    String name;
    private double value;
    private double modifiedValue;

    public Stat(double v) {
        value = v;
        modifiedValue = v;
    }
    private void modify(double modifier) {
        modifiedValue += modifier;
    }

    public double getModifiedValue() {
        return modifiedValue;
    }

    public double getValue()  {
        return value;
    }
}

class Status {
    public Stat health;
    public Stat speed;
    public Stat armor;
    public Stat range;

    public Status (double mHealth, double mSpeed, double mArmor, double mRange) {
        health = new Stat(mHealth);
        speed = new Stat(mSpeed);
        armor = new Stat(mArmor);
        range = new Stat(mRange);
    }
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

class Attack {
    Stat attackRate;
    Stat attackRange;
    Stat attackDamage;
    Stat armorPenetration;
    Modifier modInflicted;

    public Attack (double mAttackRate, double mAttackRange, double mAttackDamage, double mArmorPenetration, Modifier mod) {
        attackRate = new Stat(mAttackRate);
        attackRange = new Stat(mAttackRange);
        attackDamage = new Stat(mAttackDamage);
        armorPenetration = new Stat(mArmorPenetration);
        modInflicted = mod;
    }
}



abstract class Modifier {
    String name;
    String description;
    //this method is problematic, no easy way to reverse.
    abstract void effect();
    double duration;
}



