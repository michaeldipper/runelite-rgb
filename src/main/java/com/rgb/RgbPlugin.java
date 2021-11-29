package com.rgb;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "RGB"
)
public class RgbPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private RgbConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("RGB started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("RGB stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			log.info(String.format("Custom color enabled: %s", config.customColorEnabled()));
			log.info(String.format("Custom color: %s", config.customColor().toString()));
		}
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{

	}

	@Provides
	RgbConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RgbConfig.class);
	}
}
