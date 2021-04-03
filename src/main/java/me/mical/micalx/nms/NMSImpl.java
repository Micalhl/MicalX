package me.mical.micalx.nms;

import org.bukkit.entity.Player;

public interface NMSImpl {

    void sendTitle(final Player player, final String title, String subTitle, int fadeIn, int stay, int fadeOut);

    void sendActionBar(final Player player, final String message);
}
