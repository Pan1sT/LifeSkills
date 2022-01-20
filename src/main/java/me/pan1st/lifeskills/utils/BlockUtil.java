package me.pan1st.lifeskills.utils;

import me.pan1st.lifeskills.LifeSkills;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Objects;

public class BlockUtil {

    public static boolean isPlayerPlaced(@NotNull final Block block) {
        final Chunk chunk = block.getChunk();
        return chunk.getPersistentDataContainer().has(create("lifeskills",Integer.toString(block.getLocation().hashCode(), 16)), PersistentDataType.INTEGER);
    }

    public static void addPlayerPlaced(@NotNull final Block block) {
        final Chunk chunk = block.getChunk();
        chunk.getPersistentDataContainer().set(create("lifeskills",Integer.toString(block.getLocation().hashCode(), 16)), PersistentDataType.INTEGER, 1);
    }

    public static void removePlayerPlaced(@NotNull final Block block) {
        final Chunk chunk = block.getChunk();
        chunk.getPersistentDataContainer().remove(create("lifeskills",Integer.toString(block.getLocation().hashCode(), 16)));
    }

    @NotNull
    public static NamespacedKey create(@NotNull String namespace, @NotNull String key) {
        return Objects.requireNonNull(NamespacedKey.fromString((String)(namespace + ":" + key)));
    }

}
