# OG Pots

A Fabric client-side mod that brings back the enchantment glint on potions with effects. One jar works for **Minecraft 1.21 to 26.3**.

Author: **betongoat**

## Attribution
This project is based on **[Shiny Pots](https://modrinth.com/mod/shiny-pots)** by **[nukebob](https://modrinth.com/user/nukebob)**, licensed under **[CC-BY-4.0](https://creativecommons.org/licenses/by/4.0/)**.

**Code modified on the basis of the Shiny Pots project**: it was ported from 1.21.10–1.21.11 to every version from 1.21 to 26.3 in a single jar, and the name, mod ID and icon were changed. See [NOTICE.md](NOTICE.md) for details.

## How it works
`PotionItem` gets an `isFoil` override that returns `true` when the stack has a potion with effects. Mojang changed things twice in this range, so the jar contains three mixins and `OgPotsMixinPlugin` applies only the one that matches the running game:

| Minecraft | Mixin | Names |
|---|---|---|
| 1.21 – 1.21.4 | `PotionItemMixin1_21` | intermediary, `ComponentMap.get` = `method_57829` |
| 1.21.5 – 1.21.11 | `PotionItemMixin1_21_5` | intermediary, `ComponentMap.get` = `method_58694` |
| 26.1 – 26.3 | `PotionItemMixin26_1` | Mojang names (the game is no longer obfuscated) |

## Building
```
./gradlew build
```
The jar is written to `build/libs/ogpots-<version>.jar`.

Minecraft and Fabric Loader classes are not downloaded. The few classes the mod uses are declared as compile-only stubs in `src/stubs`, so the build needs only Maven Central (Mixin, ASM, SLF4J).

## Modrinth
- Description: [MODRINTH.md](MODRINTH.md)
- Summary: [MODRINTH_SUMMARY.txt](MODRINTH_SUMMARY.txt)
- Icon: [icon.png](icon.png)
- Loader: Fabric · Environment: client required, server unsupported
- Game versions: 1.21, 1.21.1, 1.21.2, 1.21.3, 1.21.4, 1.21.5, 1.21.6, 1.21.7, 1.21.8, 1.21.9, 1.21.10, 1.21.11, 26.1, 26.1.1, 26.1.2, 26.2, 26.3
- License: CC-BY-4.0

## License
[CC-BY-4.0](LICENSE)
