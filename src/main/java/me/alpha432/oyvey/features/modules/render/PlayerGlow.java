package me.alpha432.oyvey.features.modules.render;  // ← adjust package if your modules use subpackages like render/visual/etc.

import me.alpha432.oyvey.features.modules.Module;   // ← this should already exist
// If your base uses a different base class name (e.g. Mod, Hack, Feature), change it

public class PlayerGlow extends Module {

    public PlayerGlow() {
        super("PlayerGlow", "Makes other players glow (visible through walls)", Category.RENDER);  // ← change Category to VISUAL / RENDER / HUD / etc. if needed
        // You can add settings here later, e.g. color, mode (team color / white / rainbow), etc.
    }

    // Most bases call onEnable / onDisable when toggled
    @Override
    public void onEnable() {
        // Optional: send chat message or play sound
    }

    @Override
    public void onDisable() {
        // Optional cleanup
    }

    // Some bases use onUpdate / onTick — leave empty if not needed
}
