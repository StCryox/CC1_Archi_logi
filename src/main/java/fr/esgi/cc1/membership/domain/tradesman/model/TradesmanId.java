package fr.esgi.cc1.membership.domain.tradesman.model;

import fr.esgi.cc1.core.EntityId;

public class TradesmanId implements EntityId {
    private final int value;

    public TradesmanId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TradesmanId{" +
                "value=" + value +
                '}';
    }
}
