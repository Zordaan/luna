package io.luna.game.event.impl;

import io.luna.game.model.item.Item;
import io.luna.game.model.mob.Player;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * An event sent when the equipment of a player changes.
 *
 * @author lare96 <http://github.org/lare96>
 */
public final class EquipmentChangeEvent extends PlayerEvent {

    /**
     * The index.
     */
    private final int index;

    /**
     * The old item on the index (removed item).
     */
    private final Optional<Item> oldItem;

    /**
     * The new item on the index (added item).
     */
    private final Optional<Item> newItem;

    /**
     * Creates a new {@link EquipmentChangeEvent}.
     *
     * @param index The index.
     * @param oldItem The old item on the index.
     * @param newItem The new item on the index.
     */
    public EquipmentChangeEvent(Player player, int index, Optional<Item> oldItem, Optional<Item> newItem) {
        super(player);
        this.index = index;
        this.oldItem = oldItem;
        this.newItem = newItem;
    }

    /**
     * @return The index.
     */
    public int index() {
        return index;
    }

    /**
     * @return The old item on the index.
     */
    public Optional<Item> oldItem() {
        return oldItem;
    }

    /**
     * @return The old item identifier on the index.
     */
    public OptionalInt oldId() {
        return oldItem.isPresent() ? OptionalInt.of(oldItem.get().getId()) : OptionalInt.empty();
    }

    /**
     * @return The new item on the index.
     */
    public Optional<Item> newItem() {
        return newItem;
    }

    /**
     * @return The new item identifier on the index.
     */
    public OptionalInt newId() {
        return newItem.isPresent() ? OptionalInt.of(newItem.get().getId()) : OptionalInt.empty();
    }
}
