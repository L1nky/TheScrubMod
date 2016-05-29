package com.github.l1nky.thescrubmod;

import org.apache.logging.log4j.Logger;

import com.github.l1nky.thescrubmod.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class TheScrubMod
{
    @Instance(Reference.MOD_ID)
    public static TheScrubMod instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    public static Logger log;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        TheScrubMod.log = event.getModLog();
        TheScrubMod.proxy.preInit(event.getSuggestedConfigurationFile());
        GameRegistry.registerWorldGenerator(new MyGenerator(), 100);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        TheScrubMod.proxy.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
}
