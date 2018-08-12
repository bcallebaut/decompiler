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
public class StringRef extends ConstantPoolValue<String> implements Resolvable{
    final static int value = 8;
    int ref;

    public StringRef(LowLevelClassFile.ConstantPool cp,DataInputStream dis) throws IOException {
        super(cp);
        setRef(dis.readUnsignedShort());
    }

    public String getValue() {
        return (String)get(ref).getValue();
    }

    public void setRef(int ref) {
        this.ref = ref;
    }
    
    public int getRef() {
        return ref - 1;
    }

    @Override
    public void resolve(Object context) {
        ((LowLevelClassFile.ConstantPool)context).replace(this, ((LowLevelClassFile.ConstantPool)context).get(ref));
    }
    
    
}
