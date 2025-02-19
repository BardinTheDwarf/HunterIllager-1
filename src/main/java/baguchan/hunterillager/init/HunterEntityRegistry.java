package baguchan.hunterillager.init;

import baguchan.hunterillager.entity.HunterIllagerEntity;
import baguchan.hunterillager.entity.projectile.BoomerangEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.raid.Raid;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = "hunterillager", bus = EventBusSubscriber.Bus.MOD)
public class HunterEntityRegistry {
	public static final EntityType<HunterIllagerEntity> HUNTERILLAGER = EntityType.Builder.of(HunterIllagerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).build(prefix("hunterillager"));

	public static final EntityType<BoomerangEntity> BOOMERANG = EntityType.Builder.<BoomerangEntity>of(BoomerangEntity::new, MobCategory.MISC).setCustomClientFactory(BoomerangEntity::new).sized(0.3F, 0.3F).build(prefix("boomerang"));

	@SubscribeEvent
	public static void registerEntity(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().register(HUNTERILLAGER.setRegistryName("hunterillager"));
		event.getRegistry().register(BOOMERANG.setRegistryName("boomerang"));
		Raid.RaiderType.create("hunterillager", HUNTERILLAGER, new int[]{0, 0, 1, 2, 2, 1, 2, 3});
	}

	@SubscribeEvent
	public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
		event.put(HUNTERILLAGER, HunterIllagerEntity.createAttributes().build());
	}

	private static String prefix(String path) {
		return "hunterillager." + path;
	}
}
