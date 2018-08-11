/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import be.belgiplast.quasar.assembly.LowLevelClassFile.ConstantPool;
import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T0194671
 */
public class MethodInfo {
    private ConstantPool cp;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private List<AttributeInfo> attributes = new ArrayList<>();

    public MethodInfo(ConstantPool cp,DataInput dis) throws IOException{
        this.cp = cp;
        accessFlags = dis.readUnsignedShort();
        nameIndex = dis.readUnsignedShort();
        descriptorIndex = dis.readUnsignedShort();
        int attrs = dis.readUnsignedShort();
        for (int i = 0 ; i < attrs; i++){
            attributes.add(new AttributeInfo(cp,dis)); 
        }
    }
    
    public int getAccessFlags() {
        return accessFlags;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
    
    public String getName(){
        return ((StringValue)cp.get(nameIndex - 1)).getValue();
    }
    
    public String getDescriptor(){
        return ((StringValue)cp.get(descriptorIndex - 1)).getValue();
    }

    public List<AttributeInfo> getAttributes() {
        return attributes;
    }
    
    
}
