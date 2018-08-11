/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author T0194671
 */
public class NameAndTypeReference extends ConstantPoolValue<String> implements Resolvable{
    private int tag;
    int nameIndex;
    int typeIndex;

    public NameAndTypeReference(LowLevelClassFile.ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        setNameIndex(dis.readUnsignedShort());
        setTypeIndex(dis.readUnsignedShort());
    }

    @Override
    public String getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName(){
        return ((StringValue)get(nameIndex)).getValue();
    }
    
    public String getType(){
        return ((StringValue)get(typeIndex)).getValue();
    }

    public final int getTag() {
        return tag;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(int typeIndex) {
        this.typeIndex = typeIndex;
    }

    @Override
    public void resolve(Object context) {
        //((ClassFile.ConstantPool)context).get(nameTypeIndex);
    }
    
    
}
