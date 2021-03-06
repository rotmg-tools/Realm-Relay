package realmrelay.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class AccountListPacket extends Packet {
	
	public static final byte ID = 81;
	
	public int accountListId;
	public String[] accountIds = new String[0];

	@Override
	public byte id() {
		return ID;
	}

	@Override
	public void parseFromInput(DataInput in) throws IOException {
		this.accountListId = in.readInt();
		this.accountIds = new String[in.readShort()];
		for (int i = 0; i < this.accountIds.length; i++) {
			this.accountIds[i] = in.readUTF();
		}
	}

	@Override
	public void writeToOutput(DataOutput out) throws IOException {
		out.writeInt(this.accountListId);
		out.writeShort(this.accountIds.length);
		for (String accountId: this.accountIds) {
			out.writeUTF(accountId);
		}
	}

}
