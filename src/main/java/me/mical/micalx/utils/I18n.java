package me.mical.micalx.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.text.MessageFormat;

/**
 * 为了 MicalX 某些内部提示消息写的语言文件工具.
 * 有些信息显示格式来自 ParrotX.
 * ParrotX Repository (MIT): https://github.com/Polar-Pumpkin/ParrotX
 *
 * @author Mical
 * @author EntityParrot_
 */
public class I18n {

    private static final String MICALX_PREFIX = color("&bMicalX &f>> &7");

    public static String color(final String pattern) {
        return ChatColor.translateAlternateColorCodes('&', pattern);
    }

    public static String color(final String pattern, final Object... args) {
        return color(MessageFormat.format(pattern, args));
    }
    
    public static void log(final String message, final Object... args) {
        Bukkit.getConsoleSender().sendMessage(color(message, args));
    }

    public static void logWithPrefix(final String message, final Object... args) {
        log(MICALX_PREFIX + color(message, args));
    }

    /**
     * 快速向控制台发送带有格式化前缀的错误日志信息。
     *
     * @param action    动作名称。
     * @param object    操作对象。
     * @param exception 错误内容。
     * @param args      消息变量。
     */
    public static void logError(String action, String object, String exception, Object... args) {
        logWithPrefix("&7{0} &c{1} &7时遇到错误(&c{2}&7).", action, object, color(exception, args));
    }

    /**
     * 快速向控制台输出错误的堆栈跟踪。
     *
     * @param exception     Throwable 类型的异常。
     * @param packageFilter 包名关键词过滤，不需要可以填写 null。
     */
    public static void printStackTrace(Throwable exception, String packageFilter) {
        String msg = exception.getLocalizedMessage();
        log("&7===================================&c&l printStackTrace &7===================================");
        log("&7Exception Type ▶");
        log(ChatColor.RED + exception.getClass().getName());
        log(ChatColor.RED + ((msg == null || msg.length() == 0) ? "&7No description." : msg));
        // org.serverct.parrot.plugin.Plugin
        String lastPackage = "";
        for (StackTraceElement elem : exception.getStackTrace()) {
            String key = elem.getClassName();

            boolean pass = true;
            if (packageFilter != null) {
                pass = key.contains(packageFilter);
            }

            final String[] nameSet = key.split("[.]");
            final String className = nameSet[nameSet.length - 1];
            final String[] packageSet = new String[nameSet.length - 2];
            System.arraycopy(nameSet, 0, packageSet, 0, nameSet.length - 2);

            StringBuilder packageName = new StringBuilder();
            int counter = 0;
            for (String nameElem : packageSet) {
                packageName.append(nameElem);
                if (counter < packageSet.length - 1) {
                    packageName.append(".");
                }
                counter++;
            }

            if (pass) {
                if (!packageName.toString().equals(lastPackage)) {
                    lastPackage = packageName.toString();
                    log("");
                    log("&7Package &c" + packageName + " &7▶");
                }
                log("  &7▶ at Class &c" + className + "&7, Method &c" + elem.getMethodName() + "&7. (&c" + elem.getFileName() + "&7, Line &c" + elem.getLineNumber() + "&7)");
            }
        }
        log("&7===================================&c&l printStackTrace &7===================================");
    }

    /**
     * 快速向控制台发送带有格式化前缀的错误日志信息。
     * 该方法常用于 try...catch 语句块中，至少我是这么用的。awa
     *
     * @param action        动作名称。
     * @param object        操作对象。
     * @param e             Throwable 类型的异常。
     * @param packageFilter 包名关键词过滤，不需要可以填写 null。
     */
    public static void logError(String action, String object, Throwable e, String packageFilter) {
        logError(action, object, e.toString());
        printStackTrace(e, packageFilter);
    }
}
