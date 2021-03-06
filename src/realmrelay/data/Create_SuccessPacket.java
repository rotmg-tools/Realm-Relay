package realmrelay.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class Create_SuccessPacket extends Packet {
	
	public static final byte ID = 47;
	
	public int objectId;
	public int charId;

	@Override
	public byte id() {
		return ID;
	}

	@Override
	public void parseFromInput(DataInput in) throws IOException {
		this.objectId = in.readInt();
		this.charId = in.readInt();
	}

	@Override
	public void writeToOutput(DataOutput out) throws IOException {
		out.writeInt(this.objectId);
		out.writeInt(this.charId);
	}

}
