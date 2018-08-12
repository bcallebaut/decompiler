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
public abstract class AbstractReference extends ConstantPoolValue<String> implements Resolvable{
    int classIndex;
    int nameTypeIndex;

    public AbstractReference(LowLevelClassFile.ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        setClassIndex(dis.readUnsignedShort());
        setNameTypeIndex(dis.readUnsignedShort());
    }

    public int getClassIndex() {
        return classIndex;
    }

    protected void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }

    public int getNameTypeIndex() {
        return nameTypeIndex;
    }

    protected void setNameTypeIndex(int nameTypeIndex) {
        this.nameTypeIndex = nameTypeIndex;
    }
    
    public String getName(){    
        return ((NameAndTypeReference)get(nameTypeIndex).getValue()).getName();
    }
    
    public String getType(){    
        return ((NameAndTypeReference)get(nameTypeIndex).getValue()).getType();
    }
    
    public String getClassname(){    
        return ((ClassInfo)get(classIndex).getValue()).getName();
    }

    @Override
    public void resolve(Object context) {
        ((LowLevelClassFile.ConstantPool)context).get(nameTypeIndex);
    }
    
    
}
