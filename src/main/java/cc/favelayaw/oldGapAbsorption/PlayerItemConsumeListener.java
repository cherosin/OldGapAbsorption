package cc.favelayaw.oldGapAbsorption;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Optional;

public class PlayerItemConsumeListener implements Listener {

    @EventHandler
    public void onFoodLevelChangeEvent(FoodLevelChangeEvent event) {
        if (event.getItem() == null || event.getItem().getType() != Material.GOLDEN_APPLE) {
            return;
        }

        Optional<PotionEffect> currentAbsorption = event.getEntity().getActivePotionEffects()
                .stream()
                .filter(potionEffect -> potionEffect.getType().equals(PotionEffectType.ABSORPTION))
                .findFirst();

        if (currentAbsorption.isPresent() && currentAbsorption.get().getAmplifier() != 3) {
            return;
        }

        event.getEntity().setAbsorptionAmount(16);
    }

    @EventHandler
    public void onEntityPotionEffectEvent(EntityPotionEffectEvent event) {
        if (event.getModifiedType() == PotionEffectType.ABSORPTION
                && event.getCause() == EntityPotionEffectEvent.Cause.UNKNOWN
                && event.getAction() == EntityPotionEffectEvent.Action.REMOVED) {
            event.setCancelled(true);
        }
    }

}
