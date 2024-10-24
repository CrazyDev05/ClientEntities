package de.cubbossa.cliententities.entity;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import de.cubbossa.cliententities.PlayerSpaceImpl;
import de.cubbossa.cliententities.ServerSideMethodNotSupported;
import de.cubbossa.cliententities.TrackedField;
import java.util.List;
import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClientAbstractVillager extends ClientAgeableMob implements AbstractVillager {

    TrackedField<Integer> headShakeTimer = new TrackedField<>(40);

    public ClientAbstractVillager(PlayerSpaceImpl playerSpace, int entityId, EntityType entityType) {
        super(playerSpace, entityId, entityType);
    }

    @Override
    public @NotNull EntityCategory getCategory() {
        return EntityCategory.NONE;
    }

    @Override
    List<EntityData> metaData(boolean force) {
        List<EntityData> data = super.metaData(force);
        if (headShakeTimer.hasChanged() || force) {
            data.add(new EntityData(17, EntityDataTypes.INT, headShakeTimer.getValue()));
            headShakeTimer.flushChanged();
        }
        return data;
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        throw new ServerSideMethodNotSupported();
    }

    @NotNull
    @Override
    public List<MerchantRecipe> getRecipes() {
        throw new ServerSideMethodNotSupported();
    }

    @Override
    public void setRecipes(@NotNull List<MerchantRecipe> list) {
        throw new ServerSideMethodNotSupported();
    }

    @NotNull
    @Override
    public MerchantRecipe getRecipe(int i) throws IndexOutOfBoundsException {
        throw new ServerSideMethodNotSupported();
    }

    @Override
    public void setRecipe(int i, @NotNull MerchantRecipe merchantRecipe) throws IndexOutOfBoundsException {
        throw new ServerSideMethodNotSupported();
    }

    @Override
    public int getRecipeCount() {
        throw new ServerSideMethodNotSupported();
    }

    @Override
    public boolean isTrading() {
        throw new ServerSideMethodNotSupported();
    }

    @Nullable
    @Override
    public HumanEntity getTrader() {
        throw new ServerSideMethodNotSupported();
    }
}
