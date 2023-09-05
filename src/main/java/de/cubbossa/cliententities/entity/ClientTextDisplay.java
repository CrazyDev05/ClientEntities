package de.cubbossa.cliententities.entity;

import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import de.cubbossa.cliententities.PlayerSpaceImpl;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TextDisplay;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Getter
public class ClientTextDisplay extends ClientDisplay {

  private @Nullable Component text = null;
  private int lineWidth = 200;
  private @Nullable Color backgroundColor = Color.fromARGB(0x40, 0, 0, 0);
  private byte textOpacity = -1;
  private boolean shadowed = false;
  private boolean seeThrough = false;
  private boolean defaultBackground = false;
  private TextDisplay.TextAlignment alignment = TextDisplay.TextAlignment.CENTER;

  public ClientTextDisplay(PlayerSpaceImpl playerSpace, int entityId) {
    super(playerSpace, entityId, EntityType.TEXT_DISPLAY);
  }

  public String getText() {
    return text.toString();
  }

  public void setText(@Nullable String text) {
    this.text = setMeta(this.text, text == null ? null : Component.text(text));
  }

  public void setLineWidth(int width) {
    this.lineWidth = setMeta(this.lineWidth, width);
  }

  public void setBackgroundColor(@Nullable Color color) {
    this.backgroundColor = setMeta(this.backgroundColor, color);
  }

  public void setTextOpacity(byte opacity) {
    this.textOpacity = setMeta(this.textOpacity, opacity);
  }

  public void setShadowed(boolean shadow) {
    this.shadowed = setMeta(this.shadowed, shadow);
  }

  public void setSeeThrough(boolean seeThrough) {
    this.seeThrough = setMeta(this.seeThrough, seeThrough);
  }

  public void setDefaultBackground(boolean defaultBackground) {
    this.defaultBackground = setMeta(this.defaultBackground, defaultBackground);
  }

  public void setAlignment(@NotNull TextDisplay.TextAlignment alignment) {
    this.alignment = setMeta(this.alignment, alignment);
  }

  @Override
  List<EntityData> metaData() {
    List<EntityData> data = super.metaData();
    if (text != null) {
      data.add(new EntityData(22, EntityDataTypes.COMPONENT, GSON.serialize(text)));
    }
    if (lineWidth != 200) {
      data.add(new EntityData(23, EntityDataTypes.INT, lineWidth));
    }
    if (backgroundColor != null) {
      data.add(new EntityData(24, EntityDataTypes.INT, backgroundColor.asARGB()));
    }
    if (textOpacity != -1) {
      data.add(new EntityData(25, EntityDataTypes.BYTE, textOpacity));
    }
    byte mask = (byte) (
        (shadowed ? 0x01 : 0)
            | (seeThrough ? 0x02 : 0)
            | (defaultBackground ? 0x04 : 0)
            | (switch (alignment) {
          case CENTER -> 0x00;
          case LEFT -> 0x08;
          case RIGHT -> 0x10;
        }));
    if (mask != 0) {
      data.add(new EntityData(26, EntityDataTypes.BYTE, mask));
    }
    return data;
  }
}
