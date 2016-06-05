package com.github.l1nky.thescrubmod.items;

import com.github.l1nky.thescrubmod.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems
{
    public static Item wandOfTime;
    
    public static void registerItems()
    {
        wandOfTime = registerItem(new WandOfTime(), "WandOfTime");
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerItemsRenderer()
    {
        registerItemRenderer(ModItems.wandOfTime);
    }
    
    private static Item registerItem(Item item, String name)
    {
        item.setUnlocalizedName(Reference.MOD_ID + "." + name).setRegistryName(name);
        GameRegistry.register(item);
        return item;
    }
    
    @SideOnly(Side.CLIENT)
    private static Item registerItemRenderer(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        return item;
    }
}
