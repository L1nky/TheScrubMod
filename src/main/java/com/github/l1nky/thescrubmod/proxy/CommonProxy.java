package com.github.l1nky.thescrubmod.proxy;

import java.io.File;

import com.github.l1nky.thescrubmod.items.TheScrubModItems;

public class CommonProxy
{
    public void preInit(File configFile)
    {
        TheScrubModItems.registerItems();
    }
    
    public void init()
    {
        
    }
}
