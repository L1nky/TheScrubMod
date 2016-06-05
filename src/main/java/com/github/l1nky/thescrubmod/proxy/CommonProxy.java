package com.github.l1nky.thescrubmod.proxy;

import java.io.File;

import com.github.l1nky.thescrubmod.items.ModItems;

public class CommonProxy
{
    public void preInit(File configFile)
    {
        ModItems.registerItems();
    }
    
    public void init()
    {
        
    }
}
