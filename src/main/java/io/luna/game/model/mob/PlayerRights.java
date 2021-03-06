package io.luna.game.model.mob;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * An enum representing authority levels.
 *
 * @author lare96 <http://github.org/lare96>
 */
public enum PlayerRights {
    PLAYER(0, 0),
    MODERATOR(1, 1),
    ADMINISTRATOR(2, 2),
    DEVELOPER(2, 3);

    /**
     * The protocol value. May only be between 0-2 (player, moderator, administrator).
     */
    private final int clientValue;

    /**
     * The server value.
     */
    private final int serverValue;

    /**
     * Creates a new {@link PlayerRights}.
     *
     * @param clientValue The protocol value.
     * @param serverValue The server value.
     */
    PlayerRights(int clientValue, int serverValue) {
        checkArgument(clientValue >= 0 && clientValue <= 2, "clientValue must be >= 0 && <= 2");

        this.clientValue = clientValue;
        this.serverValue = serverValue;
    }

    /**
     * Determines if this authority level is greater than {@code other}.
     */
    public boolean greater(PlayerRights other) {
        return serverValue > other.serverValue;
    }

    /**
     * Determines if this authority level is equal to or greater than {@code other}.
     */
    public boolean equalOrGreater(PlayerRights other) {
        return serverValue >= other.serverValue;
    }

    /**
     * Determines if this authority level is less than {@code other}.
     */
    public boolean less(PlayerRights other) {
        return serverValue < other.serverValue;
    }

    /**
     * Determines if this authority level is equal to or less than {@code other}.
     */
    public boolean equalOrLess(PlayerRights other) {
        return serverValue <= other.serverValue;
    }

    /**
     * Determines if this authority level is equal to {@code other}.
     */
    public boolean equal(PlayerRights other) {
        return serverValue == other.serverValue;
    }

    /**
     * @return The protocol value.
     */
    public final int getClientValue() {
        return clientValue;
    }

    /**
     * @return The server value.
     */
    public final int getServerValue() {
        return serverValue;
    }
}
