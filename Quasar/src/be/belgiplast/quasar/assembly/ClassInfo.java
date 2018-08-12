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
public class ClassInfo extends ConstantPoolValue implements Resolvable{
    private int name;

    public ClassInfo(LowLevelClassFile.ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        setNameIndex(dis.readUnsignedShort());
    }

    public int getNameIndex() {
        return name;
    }

    protected void setNameIndex(int reference) {
        this.name = reference;
    }
    
    public String getName(){
        return ((StringValue)get(name)).getValue();
    }
    
    @Override
    public void resolve(Object context) {
        
    }

    @Override
    public Object getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
