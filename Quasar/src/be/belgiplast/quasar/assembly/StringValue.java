/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author T0194671
 */
public class StringValue extends ConstantPoolValue<String>{

    private String s;
    
    public StringValue(LowLevelClassFile.ConstantPool cp, DataInputStream dis) throws IOException{
        super(cp);
        int length = dis.readUnsignedShort();
        byte buf[] = new byte[length];
        dis.read(buf);
        s = new String(buf,"UTF-8");
    }

    @Override
    public String getValue() {
        return s;
    }

    @Override
    public String toString() {
        return s;
    }
    
    
    
}
