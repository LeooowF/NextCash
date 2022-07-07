package com.nextplugins.cash.api.event.operations;

import com.nextplugins.cash.api.event.CustomEvent;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Cancellable;

@Getter
@Setter
public final class CashGiveAllEvent extends CustomEvent implements Cancellable {

    private final double amount;
    private boolean cancelled;

    public CashGiveAllEvent(double amount) {
        super(false);
        this.amount = amount;
    }
}