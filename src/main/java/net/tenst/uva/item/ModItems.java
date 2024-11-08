package net.tenst.uva.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tenst.uva.Uva;

public class ModItems {

	public static final Item UVA = registerItem(
		new Item(new Item.Settings()),
		"uva"
	);

	public static void initialize() {
		// Get the event for modifying entries in the ingredients group.
		// And register an event handler that adds our suspicious item to the ingredients group.
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
			.register((itemGroup) -> itemGroup.add(ModItems.UVA));
	}

	public static Item registerItem(Item item, String id) {
		// Create the identifier for the item.
		Identifier itemID = Identifier.of(Uva.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}

    public static void RegisterVoidItems() {
		Uva.LOGGER.info("Register mod item for" + Uva.MOD_ID);
    }
}