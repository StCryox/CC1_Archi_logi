package fr.esgi.cc1.core;

public final class NoSuchEntityException extends RuntimeException {

    private NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(EntityId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }
}
