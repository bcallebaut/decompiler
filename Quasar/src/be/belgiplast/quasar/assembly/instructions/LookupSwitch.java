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
public class LookupSwitch extends Instruction{

    int defaultIndex;
    int[] offsets;
    int[] pairs;
    
    public LookupSwitch(Code.InstructionCounter dis) throws IOException {
        super(dis);
        while ((dis.getCounter() & 0xCFFFFFF )!= 0)
            dis.readByte();
        defaultIndex = dis.readByte() << 24 | dis.readByte() << 16 | dis.readByte() << 8 | dis.readByte();
        int count = dis.readByte() << 24 | dis.readByte() << 16 | dis.readByte() << 8 | dis.readByte();
        offsets = new int[count];
        pairs = new int[count]; 
        for (int i = 0; i < count ; i++){
            offsets[i] = dis.readByte();
            pairs[i] = dis.readByte() << 24 | dis.readByte() << 16 | dis.readByte() << 8 | dis.readByte();
        }
    }

    public int getDefaultIndex() {
        return defaultIndex;
    }

    public int[] getOffsets() {
        return offsets;
    }

    public int[] getPairs() {
        return pairs;
    }

    @Override
    public String getMnemonic() {
        return "lookupswitch";
    }

    @Override
    public int getOpcode() {
        return 171;
    }
}
