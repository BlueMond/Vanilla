/*
 * This file is part of Vanilla (http://www.getspout.org/).
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.getspout.vanilla.protocol.msg;

import org.getspout.api.protocol.Message;

public final class CompressedChunkMessage extends Message {
	private final int x, z;
	private final int y;
	private final int width, height, depth;
	private final byte[] data;

	public CompressedChunkMessage(int x, int y, int z, int width, int height, int depth, byte[] data) {
		this.x = x;
		this.z = z;
		this.y = y;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.data = data;
	}

	public int getX() {
		return x;
	}

	public int getZ() {
		return z;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDepth() {
		return depth;
	}

	public byte[] getData() {
		return data;
	}

	@Override
	public String toString() {
	return "CompressedChunkMessage{x=" + x + ",y=" + y + ",z=" + z + ",width=" + width + ",height=" + height + ",depth=" + depth + ",data=" + depth + "}";
	}
}