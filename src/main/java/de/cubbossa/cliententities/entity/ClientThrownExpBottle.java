package de.cubbossa.cliententities.entity;

import de.cubbossa.cliententities.PlayerSpace;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.inventory.ItemStack;

public class ClientThrownExpBottle extends ClientThrownItemProjectile implements ThrownExpBottle {

    public ClientThrownExpBottle(PlayerSpace playerSpace, int entityId) {
        super(playerSpace, entityId, EntityType.THROWN_EXP_BOTTLE, new ItemStack(Material.EXPERIENCE_BOTTLE));
    }
}
