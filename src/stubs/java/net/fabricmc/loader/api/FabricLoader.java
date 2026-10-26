package net.fabricmc.loader.api;

import java.util.Optional;

public interface FabricLoader {
    static FabricLoader getInstance() {
        return null;
    }

    Optional<ModContainer> getModContainer(String id);
}
