package com.vortx.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class ExampleSword extends SwordItem {

	public ExampleSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
		super(toolMaterial, attackDamage, attackSpeed, settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if(!world.isClient) {

		HitResult hit = user.raycast(100,0,false);
		if(hit.getType() == HitResult.Type.MISS) {
			user.sendMessage(Text.literal("BRUH AIM FOR THE STUPID BLOCK").setStyle(Style.EMPTY.withColor(Formatting.RED)),true);

		}

		if(hit.getType() == HitResult.Type.BLOCK) {
			BlockHitResult blockHit = (BlockHitResult)hit;
			double x = blockHit.getBlockPos().getX()+.5;
			double y = blockHit.getBlockPos().getY()+1;
			double z = blockHit.getBlockPos().getZ()+.5;
			world.playSound(null,user.getBlockPos(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS);
//			world.addParticle(ParticleTypes.PORTAL,user.getX(),user.getY()+1,user.getZ(),0,0,0);
			user.teleport(x,y,z);
			user.fallDistance = 0;
			user.getItemCooldownManager().set(this,20);

		}
		}
		return super.use(world, user, hand);
	}
}
