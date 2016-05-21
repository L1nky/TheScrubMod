package com.github.l1nky.thescrubmod;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TheScrubMod.MODID, name = "The Scrub Mod", version = "1.0")
public class TheScrubMod
{
    public static final String MODID = "thescrubmod";
    
    @Instance(TheScrubMod.MODID)
    public static TheScrubMod instance;
    
    @SidedProxy(clientSide = "com.github.l1nky.thescrubmod.TheScrubModClient", serverSide = "com.github.l1nky.thescrubmod.TheScrubModServer")
    public  static TheScrubModCommon proxy;
    
    public static Logger log;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        TheScrubMod.log = event.getModLog();
        TheScrubMod.proxy.preInit(event.getSuggestedConfigurationFile());
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
