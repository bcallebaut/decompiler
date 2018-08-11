/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly.instructions;

import java.io.DataInput;
import java.io.IOException;
import be.belgiplast.quasar.assembly.Instruction;

/**
 *
 * @author T0194671
 */
public class ALoad extends Instruction{

    private int index;
    
    @Override
    public String getMnemonic() {
        return "aload";
    }

    @Override
    public int getOpcode() {
        return 25;
    }
    
    public void decode(DataInput dis) throws IOException{
        index = dis.readByte();
    }
}
