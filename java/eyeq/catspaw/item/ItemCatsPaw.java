package eyeq.catspaw.item;

import com.google.common.collect.Multimap;
import eyeq.util.entity.player.EntityPlayerUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ItemCatsPaw extends ItemBow {
    public float damageVsEntity;

    public ItemCatsPaw() {
        this.damageVsEntity = 2.0F;
        this.setMaxDamage(0);
        this.setFull3D();
    }

    @Override
    protected boolean isArrow(ItemStack itemStack) {
        return itemStack.getItem() == Items.FISH;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityLivingBase entity, int timeLeft) {
        if(!(entity instanceof EntityPlayer)) {
            return;
        }
        if(timeLeft > 71980) {
            return;
        }
        double x = entity.posX;
        double y = entity.posY;
        double z = entity.posZ;
        world.playSound(null, x, y, z, SoundEvents.ENTITY_CAT_AMBIENT, entity.getSoundCategory(), 0.5F, 1.0F);
        if(world.isRemote) {
            return;
        }
        EntityPlayer player = ((EntityPlayer) entity);
        boolean isCreative = player.isCreative();
        for(EntityOcelot ocelot : world.getEntitiesWithinAABB(EntityOcelot.class, entity.getEntityBoundingBox().expand(6.0, 3.0, 6.0))) {
            ItemStack fish;
            if(isCreative) {
                fish = new ItemStack(Items.FISH);
            } else {
                try {
                    fish = findAmmo(this, player);
                } catch(InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                    return;
                }
            }
            if(fish.isEmpty()) {
                return;
            }
            // EntityOcelot processInteract
            if(!ocelot.isTamed()) {
                if(ocelot.getRNG().nextInt(5) == 0) {
                    ocelot.setTamed(true);
                    ocelot.setTameSkin(1 + world.rand.nextInt(3));
                    ocelot.setOwnerId(player.getUniqueID());
                    try {
                        playTameEffect(ocelot, true);
                    } catch(InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    ocelot.getAISit().setSitting(true);
                    ocelot.world.setEntityState(ocelot, (byte) 7);
                } else {
                    try {
                        playTameEffect(ocelot, false);
                    } catch(InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    ocelot.world.setEntityState(ocelot, (byte) 6);
                }
                itemStack.shrink(1);
            }
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack hoe = new ItemStack(Items.WOODEN_HOE);
        EnumActionResult result = EntityPlayerUtils.onItemUse(player, world, hoe, pos, facing, new Vec3d(hitX, hitY, hitZ), hand);
        return result;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        if(equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damageVsEntity, 0));
        }
        return multimap;
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {
        return true;
    }

    @Override
    public int getItemEnchantability() {
        return 0;
    }

    private boolean isPlaySound;

    @Override
    public boolean onEntitySwing(EntityLivingBase entity, ItemStack itemStack) {
        World world = entity.getEntityWorld();
        if(world.isRemote) {
            return false;
        }
        if(!entity.isSwingInProgress || entity.swingProgressInt >= getMaxSwingProgress(entity) / 2) {
            System.out.println(isPlaySound);
            System.out.println(entity.swingProgressInt == 0);

            isPlaySound |= entity.swingProgressInt == 0;
            if(isPlaySound) {
                world.playSound(null, entity.posX, entity.posY, entity.posZ, SoundEvents.ENTITY_CAT_AMBIENT, entity.getSoundCategory(), 0.5F, 1.0F);
            }
            isPlaySound = !isPlaySound;
        }
        return false;
    }

    private int getMaxSwingProgress(EntityLivingBase entity) {
        int max = 6;
        if(entity.isPotionActive(MobEffects.HASTE)) {
            max -= 1 + entity.getActivePotionEffect(MobEffects.HASTE).getAmplifier();
        } else if(entity.isPotionActive(MobEffects.MINING_FATIGUE)) {
            max += (1 + entity.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) * 2;
        }
        return max;
    }

    public static ItemStack findAmmo(ItemBow bow, EntityPlayer player) throws InvocationTargetException, IllegalAccessException {
        Method method = ReflectionHelper.findMethod(ItemBow.class, bow, new String[]{"findAmmo", "func_185060_a"}, EntityPlayer.class);
        return (ItemStack) method.invoke(bow, player);
    }

    public static void playTameEffect(EntityOcelot entity, boolean play) throws InvocationTargetException, IllegalAccessException {
        Method method = ReflectionHelper.findMethod(EntityOcelot.class, entity, new String[]{"playTameEffect", "func_70908_e"}, Boolean.TYPE);
        method.invoke(entity, play);
    }
}