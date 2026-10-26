package net.fabricmc.loader.api.metadata.version;

import java.util.function.Predicate;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;

public interface VersionPredicate extends Predicate<Version> {
    static VersionPredicate parse(String predicate) throws VersionParsingException {
        return null;
    }
}
