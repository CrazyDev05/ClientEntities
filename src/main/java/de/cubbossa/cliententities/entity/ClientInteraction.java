package de.cubbossa.cliententities.entity;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import de.cubbossa.cliententities.PlayerSpaceImpl;
import de.cubbossa.cliententities.ServerSideMethodNotSupported;
import de.cubbossa.cliententities.TrackedBoolField;
import de.cubbossa.cliententities.TrackedField;
import de.cubbossa.cliententities.entitydata.InteractionDataWrapper;
import java.util.List;
import org.bukkit.entity.Interaction;
import org.jetbrains.annotations.Nullable;

public class ClientInteraction extends ClientEntity implements Interaction {

  TrackedField<Float> interactionWidth = new TrackedField<>(1f);
  TrackedField<Float> interactionHeight = new TrackedField<>(1f);
  TrackedBoolField responsive = new TrackedBoolField(false);

  public ClientInteraction(PlayerSpaceImpl playerSpace, int entityId) {
    super(playerSpace, entityId, EntityTypes.INTERACTION);
    responsive.setValue(true);
  }

  @Override
  public float getInteractionWidth() {
    return interactionWidth.getValue();
  }

  public void setInteractionWidth(float width) {
    setMeta(this.interactionWidth, width);
  }

  @Override
  public float getInteractionHeight() {
    return interactionHeight.getValue();
  }

  public void setInteractionHeight(float height) {
    setMeta(this.interactionHeight, height);
  }

  @Override
  public boolean isResponsive() {
    return responsive.getBooleanValue();
  }

  public void setResponsive(boolean response) {
    setMeta(this.responsive, response);
  }

  @Nullable
  @Override  @Deprecated
  public PreviousInteraction getLastAttack() {
    throw new ServerSideMethodNotSupported();
  }

  @Nullable
  @Override  @Deprecated
  public PreviousInteraction getLastInteraction() {
    throw new ServerSideMethodNotSupported();
  }

  @Override
  List<EntityData> metaData(boolean force) {
    List<EntityData> data = super.metaData(force);
    if (interactionWidth.hasChanged() || force) {
      data.add(InteractionDataWrapper.width(interactionWidth.getValue()));
    }
    if (interactionHeight.hasChanged() || force) {
      data.add(InteractionDataWrapper.height(interactionHeight.getValue()));
    }
    if (responsive.hasChanged() || force) {
      data.add(InteractionDataWrapper.responsive(responsive.getBooleanValue()));
    }
    return data;
  }
}
