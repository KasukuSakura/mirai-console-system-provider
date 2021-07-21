package io.github.kasukusakura.mcsp;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.utils.MiraiLogger;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class MiraiConsoleSystemProvider extends JavaPlugin {
    public static final MiraiConsoleSystemProvider INSTANCE = new MiraiConsoleSystemProvider();

    private MiraiConsoleSystemProvider() {
        super(new JvmPluginDescriptionBuilder(
                        "io.github.kasukusakura.mirai-console-system-provider", "1.0.0"
                )
                        .name("mirai-console-system-provider")
                        .build()
        );
    }

    @Override
    public void onEnable() {
        MiraiLogger logger = getLogger();
        getLogger().info("Loaded");
        {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            logger.info("Loaded sql drivers:");
            while (drivers.hasMoreElements()) {
                logger.info(" `- " + drivers.nextElement());
            }
        }
    }

    static {
        try {
            for (String sqlC : new String[]{
                    "org.h2.Driver",
                    "com.mysql.cj.jdbc.Driver",
                    "org.postgresql.Driver",
            }) {
                Class.forName(sqlC);
            }
        } catch (Throwable throwable) {
            throw new ExceptionInInitializerError(throwable);
        }
    }
}
