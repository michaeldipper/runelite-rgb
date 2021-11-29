package com.rgb;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("rgb")
public interface RgbConfig extends Config
{
	@ConfigItem(
			position = 0,
			keyName = "customColorEnabled",
			name = "Enable Custom Color",
			description = "Determines whether the custom color will be used"
	)
	default boolean customColorEnabled()
	{
		return false;
	}

	@ConfigItem(
			position = 1,
			keyName = "customColor",
			name = "Custom Color",
			description = "Specify a custom color"
	)
	default Color customColor()
	{
		return Color.WHITE;
	}
}
