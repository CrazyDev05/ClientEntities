package de.cubbossa.cliententities.entitydata;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.util.Quaternion4f;
import com.github.retrooper.packetevents.util.Vector3f;
import org.bukkit.entity.Display;

import java.awt.*;

public class DisplayMetaDataWrapper {

    private DisplayMetaDataWrapper() {}

    public static class InterpolationDelay extends EntityDataWrapper {
        public InterpolationDelay(int delay) {
            super(EntityDataTypes.INT, delay);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            return 8;
        }
    }

    public static class InterpolationDuration extends EntityDataWrapper {
        public InterpolationDuration(int duration) {
            super(EntityDataTypes.INT, duration);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            return 9;
        }
    }

    public static class PosRosInterpolationDuration extends EntityDataWrapper {
        public PosRosInterpolationDuration(int duration) {
            super(EntityDataTypes.INT, duration);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_20_2)) {
                return -1;
            }
            return 10;
        }
    }

    public static class Translation extends EntityDataWrapper {
        public Translation(Vector3f translation) {
            super(EntityDataTypes.VECTOR3F, translation);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 11;
            }
            return 10;
        }
    }

    public static class Scale extends EntityDataWrapper {
        public Scale(Vector3f scale) {
            super(EntityDataTypes.VECTOR3F, scale);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 12;
            }
            return 11;
        }
    }

    public static class LeftRotation extends EntityDataWrapper {
        public LeftRotation(Quaternion4f rotation) {
            super(EntityDataTypes.QUATERNION, rotation);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 13;
            }
            return 12;
        }
    }

    public static class RightRotation extends EntityDataWrapper {
        public RightRotation(Quaternion4f rotation) {
            super(EntityDataTypes.QUATERNION, rotation);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 14;
            }
            return 13;
        }
    }

    public static class BillboardConstraints extends EntityDataWrapper {
        public BillboardConstraints(byte billboardIndex) {
            super(EntityDataTypes.BYTE, billboardIndex);
        }

        public BillboardConstraints(Display.Billboard billboard) {
            this((byte) billboard.ordinal());
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 15;
            }
            return 14;
        }
    }

    public static class BrightnessOverride extends EntityDataWrapper {
        public BrightnessOverride(int lightValue) {
            super(EntityDataTypes.INT, lightValue);
        }

        public BrightnessOverride() {
            this(-1);
        }

        public BrightnessOverride(int blockLight, int skyLight) {
            this(blockLight << 4 | skyLight << 20);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 16;
            }
            return 15;
        }
    }

    public static class ViewRange extends EntityDataWrapper {
        public ViewRange(float chunks) {
            super(EntityDataTypes.FLOAT, chunks);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 17;
            }
            return 16;
        }
    }

    public static class ShadowRadius extends EntityDataWrapper {
        public ShadowRadius(float size) {
            super(EntityDataTypes.FLOAT, size);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 18;
            }
            return 17;
        }
    }

    public static class ShadowStrength extends EntityDataWrapper {
        public ShadowStrength(float strength) {
            super(EntityDataTypes.FLOAT, strength);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 19;
            }
            return 18;
        }
    }

    public static class Width extends EntityDataWrapper {
        public Width(float width) {
            super(EntityDataTypes.FLOAT, width);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 20;
            }
            return 19;
        }
    }

    public static class Height extends EntityDataWrapper {
        public Height(float width) {
            super(EntityDataTypes.FLOAT, width);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 21;
            }
            return 20;
        }
    }

    public static class GlowColorOverride extends EntityDataWrapper {
        public GlowColorOverride(Color color) {
            this(color.getRGB());
        }

        public GlowColorOverride(org.bukkit.Color color) {
            this(color.asRGB());
        }

        public GlowColorOverride() {
            this(-1);
        }

        public GlowColorOverride(int rgb) {
            super(EntityDataTypes.INT, rgb);
        }

        @Override
        protected int versionedIndex() {
            if (this.serverVersion.isOlderThan(ServerVersion.V_1_19_4)) {
                return -1;
            }
            if (this.serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20_2)) {
                return 22;
            }
            return 21;
        }
    }
}
