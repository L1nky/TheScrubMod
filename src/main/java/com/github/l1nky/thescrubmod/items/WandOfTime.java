package com.github.l1nky.thescrubmod.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class WandOfTime extends Item
{
    public WandOfTime()
    {
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(80);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected)
    {
        NBTTagCompound tag;
        if(stack.hasTagCompound())
        {
            tag = stack.getTagCompound();
            long tick = world.getTotalWorldTime();
            if(tick % 10 == 0)
            {
                byte id = (byte)((tick / 10) % 8);
                tag.setDouble("p" + id + "x", entity.posX);
                tag.setDouble("p" + id + "y", entity.posY);
                tag.setDouble("p" + id + "z", entity.posZ);
                tag.setDouble("m" + id + "x", entity.motionX);
                tag.setDouble("m" + id + "y", entity.motionY);
                tag.setDouble("m" + id + "z", entity.motionZ);
            }
            stack.setItemDamage(stack.getItem().getDamage(stack) - 1);
        }
        else
        {
            stack.setTagCompound(new NBTTagCompound());
            tag = stack.getTagCompound();
            for(int i = 0; i < 8; i++)
            {
                tag.setDouble("p" + i + "x", entity.posX);
                tag.setDouble("p" + i + "y", entity.posY);
                tag.setDouble("p" + i + "z", entity.posZ);
                tag.setDouble("m" + i + "x", entity.motionX);
                tag.setDouble("m" + i + "y", entity.motionY);
                tag.setDouble("m" + i + "z", entity.motionZ);
            }
            stack.setItemDamage(this.getMaxDamage());
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
        if(stack.hasTagCompound() && !world.isRemote)
        {
            if(stack.getItem().getDamage(stack) == 0)
            {
                player.addChatMessage(new TextComponentString("Back in time !"));
                NBTTagCompound tag = stack.getTagCompound();
                byte id = (byte)((world.getTotalWorldTime() / 10 + 1) % 8);
                player.addVelocity(tag.getDouble("m" + id + "x") - player.motionX, tag.getDouble("m" + id + "y") - player.motionY, tag.getDouble("m" + id + "z") - player.motionZ);
                player.setPosition(tag.getDouble("p" + id + "x"), tag.getDouble("p" + id + "y"), tag.getDouble("p" + id + "z"));
                stack.setItemDamage(this.getMaxDamage());
                return new ActionResult(EnumActionResult.SUCCESS, stack);
            }
            else
                return new ActionResult(EnumActionResult.PASS, stack);
        }
        return new ActionResult(EnumActionResult.FAIL, stack);
    }
}
