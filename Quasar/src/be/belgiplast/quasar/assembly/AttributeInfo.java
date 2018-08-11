/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import be.belgiplast.quasar.assembly.LowLevelClassFile.ConstantPool;
import java.io.DataInput;
import java.io.IOException;


/**
 *
 * @author T0194671
 */
public final class AttributeInfo {
    private ConstantPool cp;
    private int nameIndex;
    private byte[] info;

    public AttributeInfo(ConstantPool cp,DataInput dis) throws IOException {
        this.cp = cp;
        nameIndex = dis.readUnsignedShort();
        info = new byte[dis.readInt()];
        dis.readFully(info);
    }
    
    public int getNameIndex() {
        return nameIndex;
    }
    
    public String getName(){
        return ((StringValue)cp.get(nameIndex - 1)).getValue();
    }

    public byte[] getInfo() {
        return info;
    }
    
    
}
