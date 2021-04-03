package me.mical.micalx.nms;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class NMSManager {

    public static NMSImpl handle(final JavaPlugin plugin) {
        try {
            final String version = getVersion(plugin.getServer());
            switch (version) {
                case "v1_8_R1":
                    return new me.mical.micalx.nms.v1_8_R1.NMSImpl();
                case "v1_8_R2":
                    return new me.mical.micalx.nms.v1_8_R2.NMSImpl();
                case "v1_8_R3":
                    return new me.mical.micalx.nms.v1_8_R3.NMSImpl();
                case "v1_9_R1":
                    return new me.mical.micalx.nms.v1_9_R1.NMSImpl();
                case "v1_9_R2":
                    return new me.mical.micalx.nms.v1_9_R2.NMSImpl();
                case "v1_10_R1":
                    return new me.mical.micalx.nms.v1_10_R1.NMSImpl();
                case "v1_11_R1":
                    return new me.mical.micalx.nms.v1_11_R1.NMSImpl();
                case "v1_12_R1":
                    return new me.mical.micalx.nms.v1_12_R1.NMSImpl();
                case "v1_13_R1":
                    return new me.mical.micalx.nms.v1_13_R1.NMSImpl();
                case "v1_13_R2":
                    return new me.mical.micalx.nms.v1_13_R2.NMSImpl();
                case "v1_14_R1":
                    return new me.mical.micalx.nms.v1_14_R1.NMSImpl();
                case "v1_15_R1":
                    return new me.mical.micalx.nms.v1_15_R1.NMSImpl();
                default:
                    return null;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getVersion(final Server server) {
        return server.getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }
}
