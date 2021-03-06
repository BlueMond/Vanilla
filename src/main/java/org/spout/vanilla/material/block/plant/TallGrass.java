/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, VanillaDev <http://www.spout.org/>
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
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.material.block.plant;

import java.util.ArrayList;
import java.util.Random;

import org.spout.api.geo.cuboid.Block;
import org.spout.api.inventory.ItemStack;
import org.spout.api.material.BlockMaterial;
import org.spout.api.material.block.BlockFace;

import org.spout.vanilla.material.Burnable;
import org.spout.vanilla.material.VanillaMaterials;

public class TallGrass extends DeadBush implements Burnable {
	public static final TallGrass DEAD_GRASS = new TallGrass("Dead Grass");
	public static final TallGrass TALL_GRASS = new TallGrass("Tall Grass", 1, DEAD_GRASS);
	public static final TallGrass FERN = new TallGrass("Fern", 2, DEAD_GRASS);

	private TallGrass(String name) {
		super((short) 0x0003, name, 31);
	}

	private TallGrass(String name, int data, TallGrass parent) {
		super(name, 31, data, parent);
	}

	@Override
	public boolean canSupport(BlockMaterial mat, BlockFace face) {
		return mat.equals(VanillaMaterials.FIRE);
	}

	@Override
	public int getBurnPower() {
		return 60;
	}

	@Override
	public int getCombustChance() {
		return 100;
	}

	@Override
	public TallGrass getParentMaterial() {
		return (TallGrass) super.getParentMaterial();
	}

	@Override
	public boolean canAttachTo(Block block, BlockFace face) {
		if (face == BlockFace.TOP) {
			return block.isMaterial(VanillaMaterials.GRASS, VanillaMaterials.DIRT);
		}
		return false;
	}

	@Override
	public ArrayList<ItemStack> getDrops(Block block, ItemStack holding) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		if (holding != null && holding.isMaterial(VanillaMaterials.SHEARS)) {
			drops.add(new ItemStack(this, 1));
		} else {
			Random rand = new Random();
			if (rand.nextInt(100) < (8 + rand.nextInt(7))) {
				drops.add(new ItemStack(VanillaMaterials.SEEDS, 1));
			}
		}
		return drops;
	}
}
