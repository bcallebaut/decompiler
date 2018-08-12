/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly.instructions;

import java.io.IOException;
import be.belgiplast.quasar.assembly.Code;
import be.belgiplast.quasar.assembly.Instruction;

/**
 *
 * @author T0194671
 */
public class TableSwitch extends Instruction{

    int defaultIndex;
    int low;
    int high;
    int[] jumps;
    
    public TableSwitch(Code.InstructionCounter dis) throws IOException {
        super(dis);
        while ((dis.getCounter() & 0xCFFFFFF )!= 0)
            dis.readByte();
        defaultIndex = dis.readByte() << 24 | dis.readByte() << 16 | dis.readByte() << 8 | dis.readByte();
        low = dis.readByte() << 24 | dis.readByte() << 16 | dis.readByte() << 8 | dis.readByte();
        high = dis.readByte() << 24 | dis.readByte() << 16 | dis.readByte() << 8 | dis.readByte();
        int count = high - low;
        jumps = new int[count];
        for (int i = 0; i < count ; i++){
            jumps[i] = dis.readByte() << 24 | dis.readByte() << 16 | dis.readByte() << 8 | dis.readByte();
        }
    }

    public int getDefaultIndex() {
        return defaultIndex;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }

    public int[] getJumps() {
        return jumps;
    }

    @Override
    public String getMnemonic() {
        return "tableswitch";
    }

    @Override
    public int getOpcode() {
        return 170;
    }
}
