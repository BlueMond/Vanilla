/*
 * This file is part of Vanilla (http://www.spout.org/).
 *
 * Vanilla is licensed under the SpoutDev License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev license version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.inventory.player;

import org.spout.api.inventory.Inventory;
import org.spout.api.inventory.ItemStack;

import org.spout.vanilla.inventory.VanillaInventory;

/**
 * Represents the item collection in the {@link PlayerInventory}.
 */
public class MainInventory extends Inventory implements VanillaInventory {
	private static final long serialVersionUID = 1L;
	private int currentSlot = 0;

	public MainInventory() {
		super(PlayerInventory.MAIN_SIZE);
	}

	public ItemStack getCurrentItem() {
		return getItem(currentSlot);
	}

	public void setCurrentItem(ItemStack item) {
		setItem(currentSlot, item);
	}

	public int getCurrentSlot() {
		return currentSlot;
	}

	public void setCurrentSlot(int currentSlot) {
		this.currentSlot = currentSlot;
	}

	public void setCurrentItemAmount(int amount) {
		getItem(currentSlot).setAmount(amount);
	}

	public int getCurrentItemAmount() {
		return getCurrentItem().getAmount();
	}

	public void addCurrentItemAmount(int amount) {
		setCurrentItemAmount(getCurrentItemAmount() + amount);
	}

	public void addCurrentItemData(int data) {
		addItemData(currentSlot, data);
	}
}