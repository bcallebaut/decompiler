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
public class FloatValue extends ConstantPoolValue<Float>{

    private float s;
    
    public FloatValue(LowLevelClassFile.ConstantPool cp, DataInputStream dis) throws IOException{
        super(cp);
        s = dis.readFloat();
    }

    @Override
    public Float getValue() {
        return s;
    }
    
}
