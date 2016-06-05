package com.github.l1nky.thescrubmod.proxy;

import java.io.File;

import com.github.l1nky.thescrubmod.items.ModItems;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(File configFile)
    {
        super.preInit(configFile);
        ModItems.registerItemsRenderer();
    }

    @Override
    public void init()
    {
        super.init();
    }
}
