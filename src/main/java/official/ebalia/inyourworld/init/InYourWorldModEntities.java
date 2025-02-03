
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package official.ebalia.inyourworld.init;

import official.ebalia.inyourworld.entity.VoladorEntity;
import official.ebalia.inyourworld.entity.InvisibleCobblestoneEntity;
import official.ebalia.inyourworld.entity.HijitusEntity;
import official.ebalia.inyourworld.entity.HijitusAtaqueEntity;
import official.ebalia.inyourworld.entity.HQuietoMirandoEntity;
import official.ebalia.inyourworld.entity.EstructuraFalsa2Entity;
import official.ebalia.inyourworld.entity.EstructuraFalsa1Entity;
import official.ebalia.inyourworld.entity.EntidadStalkerEntity;
import official.ebalia.inyourworld.entity.ChickenEntity;
import official.ebalia.inyourworld.entity.AtaqueEntidadEntity;
import official.ebalia.inyourworld.InYourWorldMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InYourWorldModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, InYourWorldMod.MODID);
	public static final RegistryObject<EntityType<HijitusAtaqueEntity>> HIJITUS_ATAQUE = register("hijitus_ataque", EntityType.Builder.<HijitusAtaqueEntity>of(HijitusAtaqueEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(HijitusAtaqueEntity::new).fireImmune().sized(0.6f, 0.1f));
	public static final RegistryObject<EntityType<HijitusEntity>> HIJITUS = register("hijitus",
			EntityType.Builder.<HijitusEntity>of(HijitusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(HijitusEntity::new).fireImmune().sized(0.6f, 0.1f));
	public static final RegistryObject<EntityType<ChickenEntity>> CHICKEN = register("chicken",
			EntityType.Builder.<ChickenEntity>of(ChickenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ChickenEntity::new)

					.sized(0.4f, 0.7f));
	public static final RegistryObject<EntityType<VoladorEntity>> VOLADOR = register("volador",
			EntityType.Builder.<VoladorEntity>of(VoladorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(VoladorEntity::new).fireImmune().sized(3f, 0.1f));
	public static final RegistryObject<EntityType<HQuietoMirandoEntity>> H_QUIETO_MIRANDO = register("h_quieto_mirando", EntityType.Builder.<HQuietoMirandoEntity>of(HQuietoMirandoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(HQuietoMirandoEntity::new).fireImmune().sized(4f, 0.1f));
	public static final RegistryObject<EntityType<InvisibleCobblestoneEntity>> INVISIBLE_COBBLESTONE = register("invisible_cobblestone", EntityType.Builder.<InvisibleCobblestoneEntity>of(InvisibleCobblestoneEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(InvisibleCobblestoneEntity::new).fireImmune().sized(0f, 0f));
	public static final RegistryObject<EntityType<AtaqueEntidadEntity>> ATAQUE_ENTIDAD = register("ataque_entidad", EntityType.Builder.<AtaqueEntidadEntity>of(AtaqueEntidadEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(AtaqueEntidadEntity::new).fireImmune().sized(0f, 0f));
	public static final RegistryObject<EntityType<EntidadStalkerEntity>> ENTIDAD_STALKER = register("entidad_stalker", EntityType.Builder.<EntidadStalkerEntity>of(EntidadStalkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(EntidadStalkerEntity::new).fireImmune().sized(0f, 0f));
	public static final RegistryObject<EntityType<EstructuraFalsa1Entity>> ESTRUCTURA_FALSA_1 = register("estructura_falsa_1", EntityType.Builder.<EstructuraFalsa1Entity>of(EstructuraFalsa1Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(EstructuraFalsa1Entity::new).fireImmune().sized(6f, 0.1f));
	public static final RegistryObject<EntityType<EstructuraFalsa2Entity>> ESTRUCTURA_FALSA_2 = register("estructura_falsa_2", EntityType.Builder.<EstructuraFalsa2Entity>of(EstructuraFalsa2Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(1000).setUpdateInterval(3).setCustomClientFactory(EstructuraFalsa2Entity::new).fireImmune().sized(6f, 0.1f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			HijitusAtaqueEntity.init();
			HijitusEntity.init();
			ChickenEntity.init();
			VoladorEntity.init();
			HQuietoMirandoEntity.init();
			InvisibleCobblestoneEntity.init();
			AtaqueEntidadEntity.init();
			EntidadStalkerEntity.init();
			EstructuraFalsa1Entity.init();
			EstructuraFalsa2Entity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(HIJITUS_ATAQUE.get(), HijitusAtaqueEntity.createAttributes().build());
		event.put(HIJITUS.get(), HijitusEntity.createAttributes().build());
		event.put(CHICKEN.get(), ChickenEntity.createAttributes().build());
		event.put(VOLADOR.get(), VoladorEntity.createAttributes().build());
		event.put(H_QUIETO_MIRANDO.get(), HQuietoMirandoEntity.createAttributes().build());
		event.put(INVISIBLE_COBBLESTONE.get(), InvisibleCobblestoneEntity.createAttributes().build());
		event.put(ATAQUE_ENTIDAD.get(), AtaqueEntidadEntity.createAttributes().build());
		event.put(ENTIDAD_STALKER.get(), EntidadStalkerEntity.createAttributes().build());
		event.put(ESTRUCTURA_FALSA_1.get(), EstructuraFalsa1Entity.createAttributes().build());
		event.put(ESTRUCTURA_FALSA_2.get(), EstructuraFalsa2Entity.createAttributes().build());
	}
}
