package io.github.kasukusakura.mcsp;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

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
        getLogger().info("Loaded");
    }
}
