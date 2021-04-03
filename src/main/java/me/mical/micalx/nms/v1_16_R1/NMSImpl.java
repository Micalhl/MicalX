package me.mical.micalx.nms.v1_16_R1;

import net.minecraft.server.v1_16_R1.*;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class NMSImpl implements me.mical.micalx.nms.NMSImpl {

    private static final UUID ZERO = new UUID(0, 0);

    @Override
    public void sendTitle(Player player, String title, String subTitle, int fadeIn, int stay, int fadeOut) {
        final EntityPlayer user = ((CraftPlayer) player).getHandle();
        user.playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, new ChatComponentText(title), fadeIn, stay, fadeOut));
        user.playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, new ChatComponentText(title), fadeIn, stay, fadeOut));
        user.playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, new ChatComponentText(subTitle), fadeIn, stay, fadeOut));
        user.playerConnection.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, new ChatComponentText(subTitle), fadeIn, stay, fadeOut));
    }

    @Override
    public void sendActionBar(Player player, String message) {
        final EntityPlayer user = ((CraftPlayer) player).getHandle();
        user.playerConnection.sendPacket(new PacketPlayOutChat(new ChatComponentText(message), ChatMessageType.GAME_INFO, ZERO));
    }
}

