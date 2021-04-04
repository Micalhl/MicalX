package me.mical.micalx.nms;

import me.mical.micalx.utils.I18n;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class NMS {

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
                case "v1_16_R1":
                    return new me.mical.micalx.nms.v1_16_R1.NMSImpl();
                case "v1_16_R2":
                    return new me.mical.micalx.nms.v1_16_R2.NMSImpl();
                case "v1_16_R3":
                    return new me.mical.micalx.nms.v1_16_R3.NMSImpl();
                default:
                    I18n.logError("获取", "NMSImpl", "不存在该版本 {0} 的 NMSImpl.", version);
                    return null;
            }
        } catch (Throwable e) {
            I18n.logError("获取", "NMSImpl", e, null);
            return null;
        }
    }

    public static String getVersion(final Server server) {
        return server.getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }
}
