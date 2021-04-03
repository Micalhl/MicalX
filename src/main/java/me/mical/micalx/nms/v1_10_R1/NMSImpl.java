package me.mical.micalx.nms.v1_10_R1;

import net.minecraft.server.v1_10_R1.ChatComponentText;
import net.minecraft.server.v1_10_R1.EntityPlayer;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;
import net.minecraft.server.v1_10_R1.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NMSImpl implements me.mical.micalx.nms.NMSImpl {

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
        user.playerConnection.sendPacket(new PacketPlayOutChat(new ChatComponentText(message)));
    }
}
