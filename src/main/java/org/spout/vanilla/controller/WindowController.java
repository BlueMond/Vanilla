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
package org.spout.vanilla.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.spout.api.material.BlockMaterial;

import org.spout.vanilla.controller.living.player.VanillaPlayer;
import org.spout.vanilla.inventory.window.Window;

public abstract class WindowController extends VanillaBlockController {
	private final Set<VanillaPlayer> viewers = new HashSet<VanillaPlayer>();

	protected WindowController(VanillaControllerType type, BlockMaterial blockMaterial) {
		super(type, blockMaterial);
	}

	public void open(VanillaPlayer player) {
		viewers.add(player);
		player.openWindow(createWindow(player));
	}

	public void close(VanillaPlayer player) {
		viewers.remove(player);
		player.closeWindow();

	}

	public void closeAll() {
		Iterator<VanillaPlayer> iter = viewers.iterator();
		while (iter.hasNext()) {
			close(iter.next());
		}
	}

	public Set<VanillaPlayer> getViewers() {
		return viewers;
	}

	public abstract Window createWindow(VanillaPlayer player);
}