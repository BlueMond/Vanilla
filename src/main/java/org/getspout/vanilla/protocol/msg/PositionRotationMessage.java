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

public final class PositionRotationMessage extends Message {
	private final double x, y, z, stance;
	private final float rotation, pitch;
	private final boolean onGround;

	public PositionRotationMessage(double x, double y, double z, double stance, float rotation, float pitch, boolean onGround) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.stance = stance;
		this.rotation = rotation;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getStance() {
		return stance;
	}

	public double getZ() {
		return z;
	}

	public float getRotation() {
		return rotation;
	}

	public float getPitch() {
		return pitch;
	}

	public boolean isOnGround() {
		return onGround;
	}

	@Override
	public String toString() {
		return "PositionRotationMessage{x=" + x + ",y=" + y + ",z=" + z +
				",stance=" + stance + ",rotation=" + rotation + ",pitch=" +
				pitch + ",onGround=" + onGround + "}";
	}
}