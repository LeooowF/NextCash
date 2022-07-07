package com.nextplugins.cash.listener.operation;

import com.nextplugins.cash.api.event.operations.CashGiveAllEvent;
import com.nextplugins.cash.configuration.MessageValue;
import com.nextplugins.cash.storage.AccountStorage;
import com.nextplugins.cash.util.text.NumberUtil;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

@RequiredArgsConstructor
public class CashGiveAllListener implements Listener {

    private final AccountStorage accountStorage;

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCashGiveAll(CashGiveAllEvent event) {

        if (event.isCancelled()) return;

        for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {

            val playersAccount = accountStorage.findAccount(onlinePlayers);

            playersAccount.depositAmount(event.getAmount());

            onlinePlayers.sendMessage(
                    "",
                    MessageValue.get(MessageValue::giveAll).replace("$amount", NumberUtil.format(event.getAmount())),
                    ""
            );
        }
    }
}