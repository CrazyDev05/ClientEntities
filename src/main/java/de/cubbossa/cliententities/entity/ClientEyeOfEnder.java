package de.cubbossa.cliententities.entity;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import de.cubbossa.cliententities.ClientEntityMethodNotSupportedException;
import de.cubbossa.cliententities.PlayerSpace;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.Metadatable;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter
public class ClientEyeOfEnder extends ClientEntity implements EnderSignal {

    ItemStack item = null;

    public ClientEyeOfEnder(PlayerSpace playerSpace, int entityId) {
        super(playerSpace, entityId, EntityType.ENDER_SIGNAL);
    }

    @Override
    List<EntityData> metaData() {
        List<EntityData> data = super.metaData();
        if (item != null) {
            data.add(new EntityData(8, EntityDataTypes.ITEMSTACK, item));
        }
        return data;
    }

    @Override
    public void setItem(ItemStack item) {
        this.item = setMeta(this.item, item);
    }

    @NotNull
    @Override
    public Location getTargetLocation() {
        return null;
    }

    @Override
    public void setTargetLocation(@NotNull Location location) {

    }

    @Override
    public boolean getDropItem() {
        throw new ClientEntityMethodNotSupportedException();
    }

    @Override
    public void setDropItem(boolean b) {
        throw new ClientEntityMethodNotSupportedException();
    }

    @Override
    public int getDespawnTimer() {
        throw new ClientEntityMethodNotSupportedException();
    }

    @Override
    public void setDespawnTimer(int i) {
        throw new ClientEntityMethodNotSupportedException();
    }
}