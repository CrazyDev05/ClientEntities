package de.cubbossa.cliententities;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.bukkit.plugin.Plugin;

@SuppressWarnings("unused")
public record ClientEntities(Plugin plugin) {
    private static ServerVersion serverVersion;

    public void load() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(plugin));
        PacketEvents.getAPI().load();
    }

    public void enable() {
        PacketEvents.getAPI().init();
    }

    public void disable() {
        PacketEvents.getAPI().terminate();
    }

    public PacketEventsAPI<?> getAPI() {
        return PacketEvents.getAPI();
    }

    public static ServerVersion getServerVersion() {
        if (serverVersion == null) {
            serverVersion = PacketEvents.getAPI().getServerManager().getVersion();
        }

        return serverVersion;
    }
}
