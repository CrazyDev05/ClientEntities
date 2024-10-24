package de.cubbossa.cliententities.entity;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import de.cubbossa.cliententities.PlayerSpaceImpl;
import de.cubbossa.cliententities.ServerSideMethodNotSupported;
import de.cubbossa.cliententities.TrackedField;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.EnderSignal;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClientEyeOfEnder extends ClientEntity implements EnderSignal {

    TrackedField<Location> targetLocation = new TrackedField<>(location);
    TrackedField<@Nullable ItemStack> item = new TrackedField<>();

    public ClientEyeOfEnder(PlayerSpaceImpl playerSpace, int entityId) {
        super(playerSpace, entityId, EntityTypes.EYE_OF_ENDER);
    }

    @Override
    List<EntityData> metaData(boolean force) {
        List<EntityData> data = super.metaData(force);
        if (item != null) {
            data.add(new EntityData(8, EntityDataTypes.ITEMSTACK, item));
        }
        return data;
    }

    public void setItem(ItemStack item) {
    setMeta(this.item, item);
    }

    @Override
    public int getDespawnTimer() {
        throw new ServerSideMethodNotSupported();
    }

    @Override
    public void setDespawnTimer(int i) {
        throw new ServerSideMethodNotSupported();
    }

    @NotNull
    @Override
    public Location getTargetLocation() {
        return targetLocation.getValue();
    }

    public void setTargetLocation(@NotNull Location location) {
        this.targetLocation.setValue(location);
        this.velocity.setValue(this.location.clone().subtract(targetLocation.getValue()).toVector()
            .multiply(new Vector(1, 0, 1))
            .normalize().multiply(0.5)
            .add(new Vector(0, 8, 0)));
    }

    @Override
    public boolean getDropItem() {
        throw new ServerSideMethodNotSupported();
    }

    @Override
    public void setDropItem(boolean b) {
        throw new ServerSideMethodNotSupported();
    }

    @NotNull
    @Override
    public ItemStack getItem() {
        return item.getValue();
    }
}
